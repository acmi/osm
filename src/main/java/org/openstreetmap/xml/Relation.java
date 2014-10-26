package org.openstreetmap.xml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"members"})
@XmlRootElement(name = "relation")
public class Relation extends OsmBasicType {
    @XmlElements({@XmlElement(name = "member", type = Member.class)})
    private final List<Member> members = new ArrayList<>();

    public final List<Member> getMembers() {
        return members;
    }
}
