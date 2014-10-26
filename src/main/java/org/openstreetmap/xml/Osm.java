package org.openstreetmap.xml;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"bounds", "nodes", "ways", "relations"})
@XmlRootElement(name = "osm")
public class Osm {
    @XmlAttribute(name = "version", required = true)
    private BigDecimal version = new BigDecimal("0.6");
    @XmlAttribute(name = "generator")
    private String generator;
    @XmlElement(name = "bounds", type = Bounds.class)
    private Bounds bounds;
    @XmlElements({@XmlElement(name = "node", type = Node.class)})
    private final List<Node> nodes = new ArrayList<>();
    @XmlElements({@XmlElement(name = "way", type = Way.class)})
    private final List<Way> ways = new ArrayList<>();
    @XmlElements({@XmlElement(name = "relation", type = Relation.class)})
    private final List<Relation> relations = new ArrayList<>();

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public final List<Node> getNodes() {
        return nodes;
    }

    public final List<Way> getWays() {
        return ways;
    }

    public final List<Relation> getRelations() {
        return relations;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Bounds {
        @XmlAttribute(name = "minlat", required = true)
        private float minlat;
        @XmlAttribute(name = "minlon", required = true)
        private float minlon;
        @XmlAttribute(name = "maxlat", required = true)
        private float maxlat;
        @XmlAttribute(name = "maxlon", required = true)
        private float maxlon;

        public float getMinlat() {
            return minlat;
        }

        public void setMinlat(float minlat) {
            this.minlat = minlat;
        }

        public float getMinlon() {
            return minlon;
        }

        public void setMinlon(float minlon) {
            this.minlon = minlon;
        }

        public float getMaxlat() {
            return maxlat;
        }

        public void setMaxlat(float maxlat) {
            this.maxlat = maxlat;
        }

        public float getMaxlon() {
            return maxlon;
        }

        public void setMaxlon(float maxlon) {
            this.maxlon = maxlon;
        }
    }
}
