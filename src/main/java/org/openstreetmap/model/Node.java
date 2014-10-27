package org.openstreetmap.model;

import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.Map;

public final class Node extends OsmBasicType {
    private final float lat;
    private final float lon;

    private final String toString;

    public Node(BigInteger id, String user, BigInteger uid, GregorianCalendar timestamp, Integer changeset, Integer version, Boolean visible, Map<String, String> tags, float lat, float lon) {
        super(id, user, uid, timestamp, changeset, version, visible, tags);
        this.lat = lat;
        this.lon = lon;

        this.toString = getClass().getSimpleName() + "(id: " + String.valueOf(getId()) + ", lat: " + String.valueOf(getLat()) + ", lon: " + String.valueOf(getLon()) + ")";
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return toString;
    }
}
