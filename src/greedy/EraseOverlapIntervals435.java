package greedy;

/**
 * @author baitao zou
 * date 2020/05/04
 */
public class EraseOverlapIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        sortIntervalsByBubbleSort(intervals);
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
        }
        return count;
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
}
