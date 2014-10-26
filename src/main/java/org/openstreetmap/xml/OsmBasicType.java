package org.openstreetmap.xml;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "osmBasicType", propOrder = {"tags"})
@XmlSeeAlso({Relation.class, Way.class, Node.class})
public class OsmBasicType {
    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "unsignedLong")
    private BigInteger id;
    @XmlAttribute(name = "user")
    private String user;
    @XmlAttribute(name = "uid")
    @XmlSchemaType(name = "unsignedLong")
    private BigInteger uid;
    @XmlAttribute(name = "timestamp")
    @XmlSchemaType(name = "dateTime")
    private XMLGregorianCalendar timestamp;
    @XmlAttribute(name = "changeset")
    private Integer changeset;
    @XmlAttribute(name = "version")
    private Integer version;
    @XmlAttribute(name = "visible")
    private Boolean visible;
    @XmlElementRefs({@XmlElementRef(name = "tag", type = Tag.class, required = false)})
    private final List<Tag> tags = new ArrayList<>();

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(XMLGregorianCalendar timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getChangeset() {
        return changeset;
    }

    public void setChangeset(Integer changeset) {
        this.changeset = changeset;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public final List<Tag> getTags() {
        return tags;
    }
}
