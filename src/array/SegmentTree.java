package array;


/**
 * @author Baitao Zou
 * date 2021/02/12
 */
public class SegmentTree {

    int start;
    int end;
    int sum;
    SegmentTree left;

    SegmentTree right;

    SegmentTree(int start, int end, int sum) {
        this(start, end, sum, null, null);
    }

    SegmentTree(int start, int end, int sum, SegmentTree left, SegmentTree right) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.left = left;
        this.right = right;
    }
}
