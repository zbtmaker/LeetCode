package array;

/**
 * @author Baitao Zou
 * date 2021/02/12
 */
public class NumArray307 {

    private SegmentTree root;

    public NumArray307(int[] nums) {
        this.root = build(nums, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        update(this.root, index, val);
    }

    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }

    private SegmentTree build(int[] nums, int start, int end) {
        if (start == end) {
            return new SegmentTree(start, end, nums[start]);
        }
        int mid = (start + end) >> 1;
        SegmentTree left = build(nums, start, mid);
        SegmentTree right = build(nums, mid + 1, end);
        return new SegmentTree(start, end, left.sum + right.sum, left, right);
    }

    private void update(SegmentTree root, int index, int val) {
        if (root.start == index && root.end == index) {
            root.sum = val;
            return;
        }
        int mid = (root.start + root.end) >> 1;
        if (mid >= index) {
            update(root.left, index, val);
        } else {
            update(root.right, index, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    private int sumRange(SegmentTree root, int left, int right) {
        if (root.start == left && root.end == right) {
            return root.sum;
        }
        int mid = (root.start + root.end) >> 1;
        if (right <= mid) {
            return sumRange(root.left, left, right);
        } else if (left > mid) {
            return sumRange(root.right, left, right);
        } else {
            return sumRange(root.left, left, mid) + sumRange(root.right, mid + 1, right);
        }
    }
}
