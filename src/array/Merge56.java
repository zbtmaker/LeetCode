package array;

import java.util.*;

/**
 * Created by Administrator on 2019\2\27 0027.
 */
public class Merge56 {

    /**
     * 这个问题第一个关键问题是排序，第二个关键是栈。而第二个点栈的解决思路是问题的
     * 关键之处，如果区间存在交叉则和并，否则就直接添加到栈中。
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return intervals;
        }
        sortIntervalsByBubbleSort(intervals);
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        // 入栈操作
        for (int i = 1; i < intervals.length; i++) {
            int[] preIntervals = stack.peek();
            if (intervals[i][0] < preIntervals[1]) {
                if (intervals[i][1] > preIntervals[1]) {
                    // 这个时候就需要合并去区间，相当于[1,3],[2,6]
                    preIntervals = stack.pop();
                    preIntervals[1] = intervals[i][1];
                    stack.push(preIntervals);
                }
            } else if (intervals[i][0] == preIntervals[1]) {
                preIntervals = stack.pop();
                preIntervals[1] = intervals[i][1];
                stack.push(preIntervals);
            } else {
                stack.push(intervals[i]);
            }
        }

        // 出栈操作
        int[][] result = new int[stack.size()][2];
        for (int j = stack.size() - 1; j >= 0; j--) {
            result[j] = stack.pop();
        }
        return result;
    }

    /**
     * 冒泡排序
     *
     * @param intervals
     */
    public void sortIntervalsByBubbleSort(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int[] tmp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = tmp;
                }
            }
        }
    }

    public void sortIntervalsByMergeSort(int[][] intervals) {

    }

    public void sortByRecursive(int[][] intervals, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >> 1;
        sortByRecursive(intervals, start, mid - 1);
        sortByRecursive(intervals, mid, end);

    }

    public void sortByMerge(int[][] intervals, int start, int mid, int end) {

    }
}
