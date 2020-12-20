package array;

/**
 * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 *
 * @author Baitao Zou
 * date 2020/12/20
 */
public class RemoveDuplicates80 {

    private static final int DUPLICATE = 2;

    /**
     * 此题和RemoveDuplicates26不一样，这个题目容忍数组元素不超过2个，那这里的slow指针移动的条件就有
     * 两个了，一个是当fast指针和fast - 1两个位置元素不同的时候，另一个就是fast和fast - 1位置元素相同
     * 但是相同的个数不超过两个。有了这两个规则之后，我们就可以写代码了。
     *
     * @param nums 数组
     * @return 不重复元素个数
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int slow = 0, fast = 1, count = 1;
        while (fast < len) {
            if (nums[fast] != nums[fast - 1]) {
                nums[++slow] = nums[fast];
                count = 1;
            } else {
                if (count < DUPLICATE) {
                    nums[++slow] = nums[fast];
                }
                count++;
            }
            fast++;
        }
        return slow + 1;
    }
}
