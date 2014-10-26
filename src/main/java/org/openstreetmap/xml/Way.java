package org.openstreetmap.xml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"nodes"})
@XmlRootElement(name = "way")
public class Way extends OsmBasicType {
    @XmlElementRefs({@XmlElementRef(name = "nd", type = Nd.class, required = false)})
    private final List<Nd> nodes = new ArrayList<>();

    public final List<Nd> getNodes() {
        return nodes;
    }
}
