package array;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 *
 * @author Baitao Zou
 * date 2020/12/20
 */
public class RemoveDuplicates26 {
    /**
     * 这个题目让我们不借用额外空间的方式实现重复元素的删除，那么我们需要用两个指针来实现。
     * 一个fast指针用于遍历整个数组，一个slow指针用于指向无重复的元素，如果发现不一样的元素，
     * 那么slow指针往右移一步，然后把这个不同的元素放在slow位置即可，以此循环直到数组结束。
     * 对于这类题目我们都采用快慢指针的方式实现，例如第27、83、86都可以用这个思想解决
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int slow = 0, fast = 1;
        while (fast < len) {
            if (nums[fast] != nums[fast - 1]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
