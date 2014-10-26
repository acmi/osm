package org.openstreetmap.model;

public final class Member {
    private OsmBasicType object;
    private String role;

    public Member(OsmBasicType object, String role) {
        this.object = object;
        this.role = role;
    }

    public OsmBasicType getObject() {
        return object;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(object: " + String.valueOf(getObject()) + ", role: " + String.valueOf(getRole()) + ")";
    }
}
