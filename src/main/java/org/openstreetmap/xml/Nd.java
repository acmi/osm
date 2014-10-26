package org.openstreetmap.xml;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "nd")
public class Nd {
    @XmlAttribute(name = "ref", required = true)
    @XmlSchemaType(name = "unsignedLong")
    private BigInteger ref;

    public BigInteger getRef() {
        return ref;
    }

    public void setRef(BigInteger ref) {
        this.ref = ref;
    }
}
