package org.openstreetmap.model;

public final class Member {
    private final OsmBasicType object;
    private final String role;

    private final String toString;

    public Member(OsmBasicType object, String role) {
        this.object = object;
        this.role = role;

        this.toString = getClass().getSimpleName() + "(object: " + String.valueOf(getObject()) + ", role: " + String.valueOf(getRole()) + ")";
    }

    public OsmBasicType getObject() {
        return object;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return toString;
    }
}
