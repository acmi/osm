import acmi.osm.pathfinding.OsmPathFinding;
import acmi.osm.pathfinding.PathFinding;
import acmi.osm.util.OsmMethods;
import org.openstreetmap.model.Node;
import org.openstreetmap.model.Osm;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.LogManager;

public class Test {
    private static void configureLogger() {
        try {
            LogManager.getLogManager().readConfiguration(new ByteArrayInputStream((
                    "handlers= java.util.logging.ConsoleHandler\n" +
                            ".level=FINE\n" +
                            "javax.xml.level=INFO\n"+
                            "com.sun.xml.level=INFO\n"+
                            "java.util.logging.ConsoleHandler.level=FINE\n" +
                            "java.util.logging.ConsoleHandler.formatter=java.util.logging.SimpleFormatter\n" +
                            "java.util.logging.SimpleFormatter.format=%5$s %6$s%n"
            ).getBytes()));
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }

    public static void main(String[] args) {
        configureLogger();

        Osm osm = OsmMethods.parse(Test.class.getResourceAsStream("/map"));

        Node start = osm.getNodes().get(new BigInteger("255598049"));
        Node end = osm.getNodes().get(new BigInteger("480676619"));

        PathFinding<Node> pathFinding = new OsmPathFinding(osm);
        List<Node> path = pathFinding.findPath(start, end);

        path.forEach(System.out::println);
    }
}
