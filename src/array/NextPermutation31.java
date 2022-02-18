package array;

/**
 * @author zoubaitao
 * date 2019/1/10
 */
public class NextPermutation31 {

    /**
     * 测试案例I ： 1234
     * 1234     1243    1324    1342    1423    1432
     * 2134     2143    2314    2341    2413    2431
     * 3124     3142    3214    3241    3412    3421
     * 4123     4132    4213    4231    4312    4321
     * <p>
     * 测试例子 A : 1234 -> 1243
     * 测试例子 C : 3241 -> 3412
     * 测试例子 B : 2341 -> 2413
     * <p>
     * 测试案例 II : 1115 此例子也全部通过
     * 从上面的测试例子中就可以看出，当我们在第i个位置比i-1位置的值大时，这个时候我们就应该
     * 从第i个位置往后开始找，找到那个大于nums[i-1]的集合中最小的值，然后进行交换，交换以后
     * 将nums从第i个位置到nums.length进行一个升序排列，这样就得到了nextPermutation。
     * （2341 -> 2413，从这个例子就可以看出，此时4比3大，但是后面也没有比1大的值，所以将
     * 4和3进行交换以后得到2431，然后将31进行排序，就得到了2413。
     * 分析：
     * 1、从上面的描述来看，就是给定一个数组nums，下标范围是0,..n,如果nums[n] < nums[n-1] < ..< nums[i] >nums[i - 1],
     * 但是nums[i] > nums[i - 1]， 此时就是说，后面从i~n下标范围内已经是一个最大序列了，但是因为nums[i-1] < nums[i],
     * 那说明下一个序列就是要从i～n中找一个min{nums[n], nums[n-1]... nums[i]}对应的下标，我们假设是nums[k]，这个
     * nums[k]恰好刚刚大于nums[i-1]，但是比i～n范围内其他所有的数据都要小。
     * 2、此时把索引i-1位置的值设置为nums[k], 因为有nums[n]但是在i + 1, .. n 这个区间立面有比nums[i]大的数，而且可能还不
     * 只一个，那么此时，下一个值就是要找打比nums[i]大的最小值，假设是nums[k]。交换nums[k]和nums[i-1]，然后将i ~ n位置所有
     * 数据反转之后得到最终结果。
     *
     * @param nums 数字
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len = nums.length;

        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int k = i + 1;
                for (; k < len; k++) {
                    if (nums[i - 1] >= nums[k]) {
                        break;
                    }
                }
                swap(nums, i - 1, k - 1);
                reverse(nums, i, len - 1);
                return;
            }
        }
        reverse(nums, 0, len - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
