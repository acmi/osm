package org.openstreetmap.model;

import java.math.BigInteger;
import java.util.Map;

public final class Osm {
    private final Bounds bounds;
    private final Map<BigInteger, Node> nodes;
    private final Map<BigInteger, Way> ways;
    private final Map<BigInteger, Relation> relations;

    public Osm(Bounds bounds, Map<BigInteger, Node> nodes, Map<BigInteger, Way> ways, Map<BigInteger, Relation> relations) {
        this.bounds = bounds;
        this.nodes = nodes;
        this.ways = ways;
        this.relations = relations;
    }

    public Bounds getBounds() {
        return bounds;
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

    public final static class Bounds {
        private float minlat;
        private float minlon;
        private float maxlat;
        private float maxlon;

        private final String toString;

        public Bounds(float minlat, float minlon, float maxlat, float maxlon) {
            this.minlat = minlat;
            this.minlon = minlon;
            this.maxlat = maxlat;
            this.maxlon = maxlon;

            this.toString = getClass().getSimpleName() + "(minlat: " + String.valueOf(getMinlat()) + ", minlon: " + String.valueOf(getMinlon()) + ", maxlat: " + String.valueOf(getMaxlat()) + ", maxlon: " + String.valueOf(getMaxlon()) + ")";
        }

        public float getMinlat() {
            return minlat;
        }

        public float getMinlon() {
            return minlon;
        }

        public float getMaxlat() {
            return maxlat;
        }

        public float getMaxlon() {
            return maxlon;
        }

        @Override
        public String toString() {
            return toString;
        }
    }
}
