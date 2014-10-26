package org.openstreetmap.xml;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    public Osm createOsm() {
        return new Osm();
    }

    public Tag createTag() {
        return new Tag();
    }

    public Osm.Bounds createOsmBounds() {
        return new Osm.Bounds();
    }

    public Node createNode() {
        return new Node();
    }

    public OsmBasicType createOsmBasicType() {
        return new OsmBasicType();
    }

    public Way createWay() {
        return new Way();
    }

    public Nd createNd() {
        return new Nd();
    }

    public Relation createRelation() {
        return new Relation();
    }

    public Member createMember() {
        return new Member();
    }
}
