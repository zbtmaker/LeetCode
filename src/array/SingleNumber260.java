package array;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author baitao zou
 * date 2020/02/10
 */
public class SingleNumber260 {

    /**
     * 这种方法和SingleNumber136、SingleNumber137相似。暂时我们使用time complexityO(N),space complexityO(N)
     * 的方法。后面再优化
     *
     * @param nums 目标数组
     * @return 只出现一次的数字集合
     */
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = ArrayUtils.count(nums);
        List<Integer> result = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
