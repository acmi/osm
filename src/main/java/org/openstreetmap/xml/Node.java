package org.openstreetmap.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "node")
public class Node extends OsmBasicType {
    @XmlAttribute(name = "lat", required = true)
    private float lat;
    @XmlAttribute(name = "lon", required = true)
    private float lon;

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(id: " + String.valueOf(getId()) + ", lat: " + String.valueOf(lat) + ", lon: " + String.valueOf(lon) + ")";
    }
}
