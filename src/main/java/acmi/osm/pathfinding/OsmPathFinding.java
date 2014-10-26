package acmi.osm.pathfinding;

import org.openstreetmap.xml.Node;
import org.openstreetmap.xml.Osm;
import org.openstreetmap.xml.Way;
import acmi.osm.util.GeographicMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Logger;

import static java.util.Collections.synchronizedList;
import static acmi.osm.util.CollectionsMethods.indexOf;
import static acmi.osm.util.OsmMethods.getHighways;
import static acmi.osm.util.OsmMethods.getNodeByNd;

public class OsmPathFinding implements PathFinding<Node> {
    private static Logger log = Logger.getLogger(OsmPathFinding.class.getName());

    private PathFinding<Node> engine;

    public OsmPathFinding(Osm osm) {
        engine = new AStar<>(GeographicMethods::distBetween, GeographicMethods::distBetween, buildGetNeighboursFunction(osm));
    }

    private static Function<Node, Iterable<Node>> buildGetNeighboursFunction(Osm osm) {
        List<Way> highways = getHighways(osm);
        return (Node node) -> {
            List<Node> list = synchronizedList(new ArrayList<>());

            log.fine(node::toString);

            highways.parallelStream().forEach(way -> {
                int index = indexOf(way.getNodes(), nd -> nd.getRef().equals(node.getId()));

                if (index == -1)
                    return;

                log.fine(() -> String.format("%s[%d/%d]", way, index, way.getNodes().size() - 1));

                if (index != 0)
                    list.add(getNodeByNd(osm, way.getNodes().get(index - 1)));

                if (index != way.getNodes().size() - 1)
                    list.add(getNodeByNd(osm, way.getNodes().get(index + 1)));
            });

            log.fine(list::toString);

            return list;
        };
    }

    @Override
    public List<Node> findPath(Node start, Node goal) {
        return engine.findPath(start, goal);
    }
}
