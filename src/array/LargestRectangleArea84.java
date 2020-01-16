package array;

public class LargestRectangleArea84 {

    public int largestRectangleArea(int[] heights) {
        return largestRectangleDynamicProgramming(heights);
    }

    /**
     * 使用暴力的方式得到的结果就是时间复杂度为O(N^3),空间复杂度为O(1)。
     * 这种方式在LeetCode上面超时了。
     *
     * @param heights
     * @return
     */
    private int largestRectangleAreaByBruteForce(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j <= i; j++) {
                int min = heights[j];
                for (int k = j; k <= i; k++) {
                    min = Math.min(heights[k], min);
                }
                max = Math.max(max, min * (i - j + 1));
            }
        }
        return max;
    }

    /**
     * 同样是使用暴力的方式，为什么别人使用暴力的方式可以将指针将为2个，
     * 2我需要3个指针呢？我们固定一个起始位置，那么随着柱子的范围的扩大，
     * 当前区间的最小值肯定也是有可能是扩张区间的最小值，相当于在这个概念
     * 中使用了动态规划的思想，minHeights[j] = {minHeights[j-1],heights}.
     * 但是这里我们又没必要保存一个数组来记录每一个区间的最小值，所以这个
     * 算法的时间复杂度O(N^2),空间复杂度为O(1)
     *
     * @param heights
     * @return
     */
    private int largestRectangleDynamicProgramming(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(heights[j], minHeight);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }
}
