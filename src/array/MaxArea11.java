package array;

/**
 * 11. 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * Created by Administrator on 2019\1\10 0010.
 */
public class MaxArea11 {

    /**
     * 1、暴力算法: time complexity O(N^2), space complexity O(1)
     * 2、Memorization：time complexity O(N), space complexity O(N)
     * 3、
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        /*return maxAreaByBruteForce(height);*/
        return maxAreaByDoublePointer(height);
    }

    /**
     * 暴力算法: time complexity O(N^2), space complexity O(1).
     *
     * @param height 数组
     * @return 最大区间
     */
    private int maxAreaByBruteForce(int[] height) {
        int max = 0;
        for (int i = 1; i < height.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int area = (i - j) * Math.min(height[j], height[i]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    /**
     * 双指针算法: tim complexity O(N), space complexity O(1)
     * 双指针算法: 这个算法目前并没有理解，后面再写题解
     * @param height 数组
     * @return 最大区间
     */
    private int maxAreaByDoublePointer(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        int min;
        int len;
        while (left < right) {
            len = right - left;
            if (height[left] <= height[right]) {
                min = height[left];
                left++;
            } else {
                min = height[right];
                right--;
            }
            max = Math.max(max, len * min);
        }
        return max;
    }

}
