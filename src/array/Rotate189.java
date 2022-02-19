package array;

/**
 * Created by Administrator on 2019\3\4 0004.
 */
public class Rotate189 {
    /**
     * 其实对于数组头尾循环的方式，经常采用的方式就是将数组长度变为当前的2倍，同时利用mod运算来解决
     * 这里我们没有使用2倍数组的方式，但是我们需要将最后一位nums.length - 1 和
     * (nums.length % nums.length = 0) 进行向前移。循环边界是1 -> nums.length
     *
     * @param nums 数组
     * @param k    翻转位数
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        byRotate(nums, k);
    }

    public void byLoop(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int last = nums[0];
            for (int j = 1; j <= nums.length; j++) {
                int temp = nums[j % nums.length];
                nums[j % nums.length] = last;
                last = temp;
            }
        }
    }

    /**
     * 使用一个全新的数组来接受旋转后的数据，然后再使用复制的方式
     * 将数字复制回原数组
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     *
     * @param nums 数组
     * @param k    翻转位数
     */
    public void byCopy(int[] nums, int k) {
        int len = nums.length;
        int[] arr = new int[len];
        System.arraycopy(nums, len - k, arr, 0, k);
        System.arraycopy(nums, 0, arr, k, len - k);
        System.arraycopy(arr, 0, nums, 0, len);
    }

    public void byRotate(int[] nums, int k) {
        int len = nums.length;
        // 第一步先翻转全部数组
        reverse(nums, 0, len - 1);

        // 翻转0 ~ k-1
        reverse(nums, 0, k - 1);

        // 翻转k ~ len-1
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
