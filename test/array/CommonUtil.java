package array;

import java.util.List;

/**
 * @author zoubaitao
 * date 2022/01/04
 */
public class CommonUtil {

    public static int[] listToArr(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
