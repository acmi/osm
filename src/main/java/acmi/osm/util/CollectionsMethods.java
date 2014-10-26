package acmi.osm.util;

import java.util.List;
import java.util.function.Predicate;

public class CollectionsMethods {
    public static <T> int indexOf(List<T> list, Predicate<T> predicate){
        for (int i=0; i<list.size(); i++)
            if (predicate.test(list.get(i)))
                return i;
        return -1;
    }
}
