package acmi.osm.pathfinding;

import java.util.List;

public interface PathFinding<Node> {
    List<Node> findPath(Node start, Node goal);
}
