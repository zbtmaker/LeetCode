package array;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\28 0028.
 */
public class SummaryRanges228 {

    /**
     * 这个题目其实就是求每一个连续子序列，那么这种方式，那么我们就在循环当中再用一个循环判断是否是连续上升的序列
     * 这里的妙处在于使用一个k指针来指向上升的子序列，跳出循环后再判断这个k指针和i指针的位置。另一个比较好的地方
     * 就是我们选择List很重要，因为这里只是对List进行遍历，那么我们选择LinkedList会比ArrayList好很多，因为这样
     * 避免了扩容机制。时间复杂度O(N)
     *
     * @param nums 数组
     * @return 结果
     */
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> list = new LinkedList<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < len) {
            int k = i + 1;
            while (k < len && nums[k] == nums[k - 1] + 1) {
                k++;
            }
            if (k == i + 1) {
                sb.append(nums[i]);
            } else {
                sb.append(nums[i]).append("->").append(nums[k - 1]);
            }
            list.add(sb.toString());
            sb = new StringBuilder();
            i = k;
        }
        return list;
    }
}
