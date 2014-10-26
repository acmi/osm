package org.openstreetmap.model;

import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public final class Way extends OsmBasicType {
    private final List<Node> nodes;

    public Way(BigInteger id, String user, BigInteger uid, GregorianCalendar timestamp, Integer changeset, Integer version, Boolean visible, Map<String, String> tags, List<Node> nodes) {
        super(id, user, uid, timestamp, changeset, version, visible, tags);
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(id: " + String.valueOf(getId()) + ", nodes.size: " + getNodes().size() + ")";
    }
}
