package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleArea84 {

    public int largestRectangleArea(int[] heights) {
        return largestRectangleMonotonicStack(heights);
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

    /**
     * 通过暴力的方式解决
     *
     * @param heights
     * @return 最大距形
     */
    private int largestRectangleBruteForce(int[] heights) {
        int len = heights.length;
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            int area = heights[i];
            int j = i - 1;
            while (j > -1 && heights[j] >= heights[i]) {
                area += heights[i];
                j--;
            }
            int k = i + 1;
            while (k < len && heights[k] >= heights[i]) {
                area += heights[i];
                k++;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    /**
     * 单调栈
     *
     * @param heights
     * @return
     */
    private int largestRectangleMonotonicStack(int[] heights) {
        int len = heights.length;
        //左边单调栈
        int[] left = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peekLast()]) {
                stack.pollLast();
            }
            if (stack.isEmpty()) {
                left[i] = i;
            } else {
                left[i] = i - stack.peekLast() - 1;
            }
            stack.addLast(i);
        }
        //右边单调栈
        stack.clear();
        int[] right = new int[len];
        for (int j = len - 1; j > -1; j--) {
            while (!stack.isEmpty() && heights[j] <= heights[stack.peekLast()]) {
                stack.pollLast();
            }
            if (stack.isEmpty()) {
                right[j] = len - 1 - j;
            } else {
                right[j] = (stack.peekLast() - 1) - j;
            }
            stack.addLast(j);
        }
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            maxArea = Math.max((left[i] + right[i] + 1) * heights[i], maxArea);
        }
        return maxArea;
    }
}
