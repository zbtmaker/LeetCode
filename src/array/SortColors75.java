package array;

/**
 * @author baitao zou
 * date 2020/05/06
 */
public class SortColors75 {
    /**
     * 根据Leetcode官网提示，这是一道荷兰国旗问题，这一类型的题目适用于将满足某一类条件的
     * 元素放在一块，但是就我目前的理解是最多划分三类。
     * 这里的思想就是用三个指针，left指针表示左边left的左边全是0，right指针表示right的
     * 右边全是2，那么left和right这一区间就全部都是1，我们用一个cur指针来遍历整个数组，如果
     * nums[cur] == 0,那么我们就交换cur、和left位置的值，然后left++表示left指向下一个可以交换的非0值，
     * 如果nums[cur] == 2，那么交换cur、right位置的值，，然后right指向下一个可以交换的位置。
     * 这里还有几个case需要注意一下的就是我写代码时疑问的点，如果left交换以后或者时right和cur交换之后
     * 发生了cur位置还是0或者2怎么办，这个时候我们就需要借助while循环来处理了。
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        while (cur <= right) {
            while (nums[cur] == 0 || nums[cur] == 2) {
                if (nums[cur] == 0) {
                    if (cur == left) {
                        left++;
                        break;
                    } else {
                        ArrayUtils.swap(nums, cur, left);
                        left++;
                    }
                }
                if (nums[cur] == 2) {
                    if (cur == right) {
                        right--;
                        break;
                    } else {
                        ArrayUtils.swap(nums, cur, right);
                        right--;
                    }
                }
            }
            cur++;
        }
    }
}
