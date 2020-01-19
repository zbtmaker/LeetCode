package array;

/**
 * @author baitao zou
 * date 2020/01/19
 */
public class SumRange303 {
    private int[] sum;

    public SumRange303(int[] nums) {
        if (nums == null) {
            return;
        }
        sum = new int[nums.length + 1];

        for (int i = 1; i < nums.length + 1; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
    }

    /**
     * 因为这个题要运算多次，如果我们采用每次都进行循环的话，那么时间复杂度将会是O(M*N)的。
     * 既然我们输入一个数组，后面需要运算多次，那么我们为什么不在对象初始化的时候就将所有
     * 元素的和求出来。这里我们用一个数组来保存0~i元素的和，这样我们在求sumRange(i,j)的
     * 时候就可以用sum[j + 1] - sum[i],这里sum数组的长度为nums数组长度nums.length+1。
     * 其中sum[0]=0;这样我的复杂度就由O(M*N)变成O(M+N)了。
     *
     * @param i 起始位置
     * @param j 结束位置
     * @return 总和
     */
    public int sumRange(int i, int j) {
        if (i < 0 || j < 0 || i >= sum.length - 1 || j >= sum.length - 1) {
            throw new IndexOutOfBoundsException();
        }
        return sum[j + 1] - sum[i];
    }

}
