package array;

public class LargestRectangleArea84 {

    public int largestRectangleArea(int[] heights) {
        return largestRectangleAreaByBruteForce(heights);
    }

    /**
     * 使用暴力的方式得到的结果就是时间复杂度为O(N^3),空间复杂度为O(1)。
     * 这种方式在LeetCode上面超时了。
     * @param heights
     * @return
     */
    private int largestRectangleAreaByBruteForce(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            for(int j = 0;j <= i;j++){
                int min = heights[j];
                for(int k = j;k <= i;k++){
                    min = Math.min(heights[k],min);
                }
                max = Math.max(max,min * (i - j + 1));
            }
        }
        return max;
    }
}
