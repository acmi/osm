import acmi.osm.pathfinding.OsmPathFinding;
import acmi.osm.util.OsmMethods;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import org.openstreetmap.model.Node;
import org.openstreetmap.model.Osm;
import org.openstreetmap.model.Way;

import java.util.List;

public class View extends Application {
    private Node startNode;
    private Polyline path;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final Group group = new Group();

        Osm osm = OsmMethods.parse(View.class.getResourceAsStream("/map"));
        OsmPathFinding pf = new OsmPathFinding(osm);
        for (Way way : OsmMethods.getHighways(osm)) {
            for (Node node : way.getNodes()) {
                Point2D point = fromNode(osm, node);
                Circle circle = new Circle(point.getX(), point.getY(), 2);
                circle.setOnMouseClicked(event -> {
                    if (startNode == null) {
                        startNode = node;

                        group.getChildren().remove(path);
                    } else {
                        path = build(osm, pf.findPath(startNode, node));
                        startNode = null;

                        path.setStroke(Color.RED);
                        group.getChildren().add(path);
                    }
                });
                group.getChildren().add(circle);
            }
            group.getChildren().add(build(osm, way.getNodes()));
        }

        primaryStage.setScene(new Scene(group));
        primaryStage.show();
    }

    private static Point2D fromNode(Osm osm, Node node) {
        return new Point2D((node.getLon() - osm.getBounds().getMinlon()) * 10000 + 100, (node.getLat() - osm.getBounds().getMinlat()) * 10000 + 100);
    }

    private static Polyline build(final Osm osm, List<Node> nodes) {
        final Polyline polyline = new Polyline();

        for (Node node : nodes) {
            Point2D point = fromNode(osm, node);
            polyline.getPoints().add(point.getX());
            polyline.getPoints().add(point.getY());
        }

        return polyline;
    }

    public static void main(String[] args) {
        Application.launch(View.class, args);
    }

}
