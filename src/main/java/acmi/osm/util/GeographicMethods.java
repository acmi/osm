package acmi.osm.util;

import org.openstreetmap.xml.Node;

import static java.lang.Math.*;

public class GeographicMethods {
    public static final int EARTH_RADIUS = 6373;

    public static double distBetween(double lat1, double lon1, double lat2, double lon2) {
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = pow(sin(dlat / 2), 2) + cos(lat1) * cos(lat2) * pow(sin(dlon / 2), 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));
        return c * EARTH_RADIUS;
    }

    public static double distBetween(Node n1, Node n2) {
        return distBetween(n1.getLat(), n1.getLon(), n2.getLat(), n2.getLon());
    }
}
