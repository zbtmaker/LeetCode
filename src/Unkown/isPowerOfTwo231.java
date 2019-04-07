package Unkown;

/**
 * Created by Administrator on 2019\3\20 0020.
 */
public class isPowerOfTwo231 {
    public static void main(String[] args){
        /*int n = 16;
        boolean flag = new isPowerOfTwo231().isPowerOfTwo(n);
        System.out.println(flag);*/
        long x = Integer.MIN_VALUE;
    }
    /**
     * 这里我们的问题主要是考虑了负数，但是我们知道对于任意一个数，如果为负数，那么肯定
     * 不是2的次幂，同时，对于0，也不是2的次幂，因此在程序的最前边执行的时候就需要排除
     * 这些情况。那么对于任意一个正整数是否是2的次幂，那么应该如何来判断呢？我们借助numberOf1Bits191
     * 的思路来解决这个问题，对于一个数如果要是2的次幂，那么其对应的二进制位只能有一个位是1，其他为必须
     * 是零，因此我们只要统计当前数字二进制的1的个数就可以了，
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }

        int count = 0;
        int shift = 1;
        int i = 1;
        while(i <= 32){
            if((n & shift)!=0){
                count ++;
            }
            if(count > 1){
                return false;
            }
            shift = shift << 1;
            i ++;
        }
        return true;
    }
}
