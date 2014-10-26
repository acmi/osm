package org.openstreetmap.model;

import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public final class Way extends OsmBasicType {
    private final List<Node> nodes;

    private final String toString;

    public Way(BigInteger id, String user, BigInteger uid, GregorianCalendar timestamp, Integer changeset, Integer version, Boolean visible, Map<String, String> tags, List<Node> nodes) {
        super(id, user, uid, timestamp, changeset, version, visible, tags);
        this.nodes = nodes;

        this.toString = getClass().getSimpleName() + "(id: " + String.valueOf(getId()) + ")";
    }

    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return toString;
    }
}
