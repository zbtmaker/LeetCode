package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\1\10 0010.
 */
public class GetRow119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = new ArrayList<>();
        last.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(last.get(j - 1) + last.get(j));
                }
            }
            last = cur;
        }
        return last;
    }
}
