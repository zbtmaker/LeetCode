package common;

import java.util.Collection;

/**
 * @author zoubaitao
 * date 2021/09/06
 */
public class CollectionUtils {

    public static<T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static<T> boolean isNotEmpty(Collection<T> collection) {
        return collection != null && !collection.isEmpty();
    }
}
