package array;

/**
 * Created by Administrator on 2019\1\10 0010.
 */
public class SortArrayByParity905 {

    /**
     * 这个题目其实可以理解为一个荷兰国旗简化版题目，其实就是要把所有的数据分成
     * 两组，前面的是偶数，后面的数据是奇数。这个时候，我们需要用两个指针就能解决
     * 这个问题。指针i指向数组的前半部分，指针j指向数组的后半部分。如果i指向的是一个
     * 偶数，那么i++，同理，如果指针j指向的是奇数，那么j--。只有当i指向一个奇数，且
     * j指向一个偶数时，此时需要执行交换操作，交换完成之后i++, j--。
     *
     * @param nums 数组
     * @return 排序好的数组
     */
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if ((nums[i] & 1) == 0) {
                i++;
            } else if ((nums[j] & 1) == 1) {
                j--;
            } else {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
