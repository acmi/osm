package org.openstreetmap.model;

import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.Map;

public final class Node extends OsmBasicType {
    private final double lat;
    private final double lon;

    private final String toString;

    public Node(BigInteger id, String user, BigInteger uid, GregorianCalendar timestamp, Integer changeset, Integer version, Boolean visible, Map<String, String> tags, double lat, double lon) {
        super(id, user, uid, timestamp, changeset, version, visible, tags);
        this.lat = lat;
        this.lon = lon;

        this.toString = getClass().getSimpleName() + "(id: " + String.valueOf(getId()) + ", lat: " + String.valueOf(getLat()) + ", lon: " + String.valueOf(getLon()) + ")";
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return toString;
    }
}
