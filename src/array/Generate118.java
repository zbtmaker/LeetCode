package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019\1\10 0010.
 */
public class Generate118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> arr = new ArrayList<>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    arr.add(1);
                } else {
                    arr.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                }
            }
            lists.add(arr);
        }
        return lists;
    }

}
