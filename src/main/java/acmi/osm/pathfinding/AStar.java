package acmi.osm.pathfinding;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.StreamSupport;

public final class AStar<Node> implements PathFinding<Node> {
    private static Logger log = Logger.getLogger(AStar.class.getName());

    private BiFunction<Node, Node, Double> distBetween;
    private BiFunction<Node, Node, Double> heuristicCostEstimate;
    private Function<Node, Iterable<Node>> neighborNodes;

    public AStar(BiFunction<Node, Node, Double> distBetween, BiFunction<Node, Node, Double> heuristicCostEstimate, Function<Node, Iterable<Node>> neighborNodes) {
        this.distBetween = Objects.requireNonNull(distBetween);
        this.heuristicCostEstimate = Objects.requireNonNull(heuristicCostEstimate);
        this.neighborNodes = Objects.requireNonNull(neighborNodes);
    }

    @Override
    public List<Node> findPath(Node start, Node goal) {
        Set<Node> closedSet = new HashSet<>();

        Map<Node, Double> gScore = new ConcurrentHashMap<>();
        gScore.put(start, 0.0);

        Map<Node, Double> fScore = new ConcurrentHashMap<>();
        fScore.put(start, gScore.get(start) + heuristicCostEstimate.apply(start, goal));

        Queue<Node> openSet = new PriorityQueue<>((n1, n2) -> Double.compare(fScore.get(n1), fScore.get(n2)));
        openSet.add(start);

        Map<Node, Node> cameFrom = new HashMap<>();

        while (!openSet.isEmpty()) {
            Node current = openSet.remove();

            log.fine(() -> String.format("Examine %s:", current));

            if (current == goal) {
                log.fine(() -> "Goal reached");

                return reconstructPath(cameFrom, goal);
            }

            closedSet.add(current);

            StreamSupport.stream(neighborNodes.apply(current).spliterator(), true).forEach(neighbor -> {
                if (closedSet.contains(neighbor))
                    return;

                double tentativeGScore = gScore.get(current) + distBetween.apply(current, neighbor);

                if (!openSet.contains(neighbor) || tentativeGScore < gScore.get(neighbor)) {
                    log.fine(() -> String.format("Update info for %s", neighbor));

                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentativeGScore);
                    fScore.put(neighbor, gScore.get(neighbor) + heuristicCostEstimate.apply(neighbor, goal));
                    if (!openSet.contains(neighbor))
                        openSet.add(neighbor);
                }
            });
        }

        log.fine(() -> "Path not found");

        return null;
    }

    private List<Node> reconstructPath(Map<Node, Node> cameFrom, Node node) {
        List<Node> p = cameFrom.containsKey(node) ? reconstructPath(cameFrom, cameFrom.get(node)) : new ArrayList<>();
        p.add(node);
        return p;
    }
}
