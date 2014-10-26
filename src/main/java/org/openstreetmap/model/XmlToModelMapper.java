package org.openstreetmap.model;

import org.openstreetmap.xml.Nd;
import org.openstreetmap.xml.Tag;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class XmlToModelMapper implements Function<org.openstreetmap.xml.Osm, Osm> {
    @Override
    public Osm apply(org.openstreetmap.xml.Osm osm) {
        Map<BigInteger, Node> nodes = osm.getNodes()
                .stream()
                .collect(Collectors.toMap(
                        org.openstreetmap.xml.OsmBasicType::getId,
                        n -> new Node(
                                n.getId(),
                                n.getUser(),
                                n.getUid(),
                                mapTimestamp(n.getTimestamp()),
                                n.getChangeset(),
                                n.getVersion(),
                                n.getVisible(),
                                mapTags(n.getTags()),
                                n.getLat(),
                                n.getLon())
                ));
        Map<BigInteger, Way> ways = osm.getWays()
                .stream()
                .collect(Collectors.toMap(
                        org.openstreetmap.xml.OsmBasicType::getId,
                        n -> new Way(
                                n.getId(),
                                n.getUser(),
                                n.getUid(),
                                mapTimestamp(n.getTimestamp()),
                                n.getChangeset(),
                                n.getVersion(),
                                n.getVisible(),
                                mapTags(n.getTags()),
                                mapNodes(n.getNodes(), nodes))
                ));
        Map<BigInteger, Relation> relations = osm.getRelations()
                .stream()
                .collect(Collectors.toMap(
                        org.openstreetmap.xml.OsmBasicType::getId,
                        n -> new Relation(
                                n.getId(),
                                n.getUser(),
                                n.getUid(),
                                mapTimestamp(n.getTimestamp()),
                                n.getChangeset(),
                                n.getVersion(),
                                n.getVisible(),
                                mapTags(n.getTags()),
                                mapMembers(n.getMembers(), nodes, ways))
                ));
        return new Osm(
                Collections.unmodifiableMap(nodes),
                Collections.unmodifiableMap(ways),
                Collections.unmodifiableMap(relations)
        );
    }

    private Map<String, String> mapTags(List<Tag> tags) {
        return tags.stream()
                .collect(Collectors.toMap(Tag::getK, Tag::getV));
    }

    private GregorianCalendar mapTimestamp(XMLGregorianCalendar timestamp) {
        return timestamp.toGregorianCalendar();
    }

    private List<Node> mapNodes(List<Nd> nds, Map<BigInteger, Node> nodes) {
        return nds.stream()
                .map(nd -> nodes.get(nd.getRef()))
                .collect(Collectors.toList());
    }

    private List<Member> mapMembers(List<org.openstreetmap.xml.Member> members, Map<BigInteger, Node> nodes, Map<BigInteger, Way> ways) {
        return members.stream()
                .map(m -> {
                    OsmBasicType object = m.getType().equals("node") ? nodes.get(m.getRef()) :
                            m.getType().equals("way") ? ways.get(m.getRef()) :
                                    null;
                    return new Member(object, m.getRole());
                })
                .collect(Collectors.toList());
    }
}
