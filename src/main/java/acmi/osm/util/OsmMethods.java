package acmi.osm.util;

import org.openstreetmap.model.Osm;
import org.openstreetmap.model.Way;
import org.openstreetmap.model.XmlToModelMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class OsmMethods {
    public static Osm parse(File file) throws IOException {
        try (InputStream is = new FileInputStream(file)) {
            return parse(is);
        }
    }

    public static Osm parse(InputStream is) {
        try {
            org.openstreetmap.xml.Osm osm = (org.openstreetmap.xml.Osm) JAXBContext.newInstance("org.openstreetmap.xml")
                    .createUnmarshaller()
                    .unmarshal(is);
            return new XmlToModelMapper().apply(osm);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Way> getHighways(Osm osm) {
        return osm.getWays().values().parallelStream()
                .filter(way -> way.getTags().containsKey("highway"))
                .collect(Collectors.toList());
    }
}
