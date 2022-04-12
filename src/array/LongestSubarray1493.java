package array;

/**
 * 此题和MaxRepOptI1156类似
 *
 * @author zoubaitao
 * date 2022/04/12
 */
public class LongestSubarray1493 {
    /**
     * 这里需要删除一个字符，返回最长的且只包含1的非空子数组的长度。这里需要用两个指针left、right两个指针维护窗口来维持
     * 全1的字符串。那么left和right中间可以允许出现一个0字符，如果字符中出现0的数字大于1，此时需要移动左边的窗口来维持
     * 窗口的条件。我们用lastDifIndex表示数字0出现在连续1的位置。
     * <p>
     * 1、如果left = right 且 nums[right] = 0, 此时窗口内数字1的元素为0，且包含数字0的频次为1，因此不满足窗口的
     * 条件。
     * <p>
     * 2、如果left < right 且 nums[right] = 0, 此时如果lastDifIndex = -1，此时表明窗口内出现0的频次为0，此时出现了
     * 一个0之后，lastDifIndex = right。
     * <p>
     * 3、如果left < right 且 nums[right] = 0, 此时如果lastDifIndex != -1, 表明窗口内出现0的频次为2，此时不满足窗
     * 口的定义。那么此时就需要移动left指针使得窗口内最多出现1个数字0。如果lastDifIndex + 2 == right, 此时窗口内只有上一个
     * 0出现的位置和当前位置只相隔一个位(1010)，那么此时就应该left = right - 1；lastDifIndex = right。
     * 如果lastDifIndex + 2 < right，此时窗口内的元素形如10110，此时left = lastDifIndex + 1, lastDifIndex = right。
     * 如果lastDifIndex + 2 > right，此时窗口内的元素形如100，此时left = right + 1, lastDifIndex = -1。
     *
     * @param nums 数组
     * @return 最长只包含1的非空子数组的长度
     */
    public int longestSubarray(int[] nums) {
        int res = 0, left = 0, right = 0, lastDifIndex = -1, len = nums.length;
        while (right < len) {
            if (nums[right] == 0) {
                if (left == right) {
                    left = right + 1;
                    lastDifIndex = -1;
                } else {
                    if (lastDifIndex == -1) {
                        lastDifIndex = right;
                    } else {
                        if (lastDifIndex + 2 < right) {
                            left = lastDifIndex + 1;
                            lastDifIndex = right;
                        } else if (lastDifIndex + 2 == right) {
                            left = right - 1;
                            lastDifIndex = right;
                        } else {
                            left = right + 1;
                            lastDifIndex = -1;
                        }
                    }
                }
            }
            res = Math.max(res, calcLen(left, right, lastDifIndex, len));
            right++;
        }
        return res;
    }

    private int calcLen(int left, int right, int lastDifIndex, int len) {
        if (left > right) {
            return 0;
        }
        if (left == 0 && right == len - 1) {
            return len - 1;
        }
        return lastDifIndex == -1 ? right - left + 1 : right - left;
    }
}
