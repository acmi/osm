package acmi.osm.util;

import org.openstreetmap.xml.Nd;
import org.openstreetmap.xml.Node;
import org.openstreetmap.xml.Osm;
import org.openstreetmap.xml.Way;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class OsmMethods {
    public static Osm parse(File file) throws IOException{
        try(InputStream is = new FileInputStream(file)){
            return parse(is);
        }
    }

    public static Osm parse(InputStream is) {
        try {
            return (Osm)JAXBContext.newInstance("org.openstreetmap.xml")
                    .createUnmarshaller()
                    .unmarshal(is);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Way> getHighways(Osm osm) {
        return osm.getWays().parallelStream()
                .filter(way -> way.getTags().parallelStream().anyMatch(tag -> tag.getK().equals("highway")))
                .collect(Collectors.toList());
    }

    public static Node getNodeById(Osm osm, BigInteger id) throws NoSuchElementException {
        return osm.getNodes().parallelStream().filter(n -> n.getId().equals(id)).findAny().get();
    }

    public static Node getNodeByNd(Osm osm, Nd nd) throws NoSuchElementException {
        return getNodeById(osm, nd.getRef());
    }
}
