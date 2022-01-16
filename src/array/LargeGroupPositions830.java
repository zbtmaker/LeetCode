package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019\1\18 0018.
 */
public class LargeGroupPositions830 {

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> indexArr;
        char[] ch = s.toCharArray();
        int count = 1, start = 0;
        int i = 1;
        for (; i < ch.length; i++) {
            if (ch[i] == ch[i - 1]) {
                count++;
            } else {
                if (count >= 3) {
                    indexArr = new ArrayList<>(2);
                    indexArr.add(start);
                    indexArr.add(i - 1);
                    list.add(indexArr);
                }
                count = 1;
                start = i;
            }
        }
        // 最后一个连续较大的组
        if (count >= 3) {
            indexArr = new ArrayList<>();
            indexArr.add(start);
            indexArr.add(i - 1);
            list.add(indexArr);
        }

        return list;
    }
}
