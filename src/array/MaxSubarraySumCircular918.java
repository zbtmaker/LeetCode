package array;

/**
 * Created by Administrator on 2019\3\1 0001.
 */
public class MaxSubarraySumCircular918 {
    public static void main(String[] args) {
        int[] A = new int[]{5, -3, 5};
        int max = new MaxSubarraySumCircular918().maxSubarraySumCircular(A);
        System.out.println(max);
    }

    /**
     * 这里我们实现一个循环的数组，这里是上面maxSubArray53的一个变种，将数组变为循环了。此时
     * 因为循环，所以我们将数组长度变为原来的两倍。所以循环结束条件之一为i<nums.length;
     * 测试案例 I ： 3,-1,2,-1。这个时候start = 0，但是end会走到4，但是这个时候需要退出循环，当 end > A.length 且 end == start的时候
     * 表示这个时候所有元素都加上了，这个时候就不需要再继续了。
     * 测试案例II ： 3,-1,-5,2,-1。这个时候取得最大值时start = 3，end = 5。
     *
     * @param A
     * @return
     */
    public int maxSubarraySumCircular(int[] A) {
        int i = 0;
        int sum = 0;
        int len = A.length;
        int max = A[0];
        int start = 0;
        while (i < 2 * len && start < A.length) {
            max = Math.max(max, A[i % len]);
            sum += A[i % len];
            max = Math.max(max, sum);
            if (sum <= 0) {
                sum = 0;
                start = i + 1;
            }
            i++;
            if(i % len == start){
                break;
            }

        }
        return max;
    }
    /**
     * 实在不行，我们就直接brute-force就行了
     */
}
