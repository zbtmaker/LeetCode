package array;

import java.util.Stack;

/**
 * @author baitao zou
 * date 2020/01/30
 */
public class Insert57 {
    /**
     * 这个题目的好处是给出了一个已经排序的数组，然后使用Merge56合并区间是一个题。
     * 这个题目的终极思想还是Stack来实现，具体思想参考Merge56。说实话，那个题目
     * 应该设置成hard级别，这个题目的难度应该是medium。
     *
     * @param intervals   目标区间
     * @param newInterval 新插入的区间
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0 && newInterval != null) {
            return new int[][]{newInterval};
        }
        if (intervals.length != 0 && (newInterval == null || newInterval.length == 0)) {
            return intervals;
        }
        Stack<int[]> stack = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < intervals.length; i++) {
            if (flag) {
                if (newInterval[0] < intervals[i][0]) {
                    if (newInterval[1] < intervals[i][0]) {
                        stack.push(newInterval);
                    } else if (newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) {
                        intervals[i][0] = newInterval[0];
                    } else {
                        intervals[i][0] = newInterval[0];
                        intervals[i][1] = newInterval[1];
                    }
                    flag = false;
                    stack.push(intervals[i]);
                } else if (newInterval[0] == intervals[i][0]) {
                    if (newInterval[1] > intervals[i][1]) {
                        intervals[i][1] = newInterval[1];
                    }
                    stack.push(intervals[i]);
                    flag = false;
                } else if (newInterval[0] > intervals[i][0] && newInterval[0] < intervals[i][1]) {
                    intervals[i][1] = Math.max(newInterval[1], intervals[i][1]);
                    stack.push(intervals[i]);
                    flag = false;
                } else if (newInterval[0] == intervals[i][1]) {
                    intervals[i][1] = newInterval[1];
                    stack.push(intervals[i]);
                    flag = false;
                } else {
                    stack.push(intervals[i]);
                }
            } else {
                int[] preIntervals = stack.peek();
                if (preIntervals[1] > intervals[i][0]) {
                    if (preIntervals[1] < intervals[i][1]) {
                        preIntervals = stack.pop();
                        preIntervals[1] = intervals[i][1];
                        stack.push(preIntervals);
                    }
                } else if (preIntervals[1] == intervals[i][0]) {
                    preIntervals = stack.pop();
                    preIntervals[1] = intervals[i][1];
                    stack.push(preIntervals);
                } else {
                    stack.push(intervals[i]);
                }
            }
        }
        if (flag) {
            stack.push(newInterval);
        }
        int[][] result = new int[stack.size()][2];
        for (int j = stack.size() - 1; j >= 0; j--) {
            result[j] = stack.pop();
        }
        return result;
    }
}
