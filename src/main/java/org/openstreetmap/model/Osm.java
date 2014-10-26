package org.openstreetmap.model;

import java.math.BigInteger;
import java.util.Map;

public final class Osm {
    private final Map<BigInteger, Node> nodes;
    private final Map<BigInteger, Way> ways;
    private final Map<BigInteger, Relation> relations;

    public Osm(Map<BigInteger, Node> nodes, Map<BigInteger, Way> ways, Map<BigInteger, Relation> relations) {
        this.nodes = nodes;
        this.ways = ways;
        this.relations = relations;
    }

    public Map<BigInteger, Node> getNodes() {
        return nodes;
    }

    public Map<BigInteger, Way> getWays() {
        return ways;
    }

    public Map<BigInteger, Relation> getRelations() {
        return relations;
    }
}
