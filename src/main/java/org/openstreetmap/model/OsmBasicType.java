package org.openstreetmap.model;

import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.Map;

public class OsmBasicType {
    private final BigInteger id;
    private final String user;
    private final BigInteger uid;
    private final GregorianCalendar timestamp;
    private final Integer changeset;
    private final Integer version;
    private final Boolean visible;
    private final Map<String, String> tags;

    public OsmBasicType(BigInteger id, String user, BigInteger uid, GregorianCalendar timestamp, Integer changeset, Integer version, Boolean visible, Map<String, String> tags) {
        this.id = id;
        this.user = user;
        this.uid = uid;
        this.timestamp = timestamp;
        this.changeset = changeset;
        this.version = version;
        this.visible = visible;
        this.tags = tags;
    }

    public BigInteger getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public BigInteger getUid() {
        return uid;
    }

    public GregorianCalendar getTimestamp() {
        return timestamp;
    }

    public Integer getChangeset() {
        return changeset;
    }

    public Integer getVersion() {
        return version;
    }

    public Boolean getVisible() {
        return visible;
    }

    public Map<String, String> getTags() {
        return tags;
    }
}
