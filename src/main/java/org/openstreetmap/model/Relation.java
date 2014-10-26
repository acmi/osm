package org.openstreetmap.model;

import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public final class Relation extends OsmBasicType{
    private final List<Member> members;

    public Relation(BigInteger id, String user, BigInteger uid, GregorianCalendar timestamp, Integer changeset, Integer version, Boolean visible, Map<String, String> tags, List<Member> members) {
        super(id, user, uid, timestamp, changeset, version, visible, tags);
        this.members = members;
    }

    public List<Member> getMembers() {
        return members;
    }
}
