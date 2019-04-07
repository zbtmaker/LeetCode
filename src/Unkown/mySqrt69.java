package Unkown;

/**
 * Created by Administrator on 2019\3\20 0020.
 */
public class mySqrt69 {
    public static void main(String[] args){
        int x = 4;
        int result = new mySqrt69().mySqrt(x);
        System.out.println(result);
        System.out.println(Math.sqrt(x));
    }
    /**
     * 这个题目同样也是披着数学外衣的二分法问题，但是这个二分法问题是一个变种，为什么呢，因为
     * 如果我们如果找不到这个数的平方，那么我们就要返回比这个数平方根恰好小的数。对于一个正常的
     * 二分法，如果是这个数的平方，那么我们直接返回，如果不是则返回false。但是对于求一个数的平方根
     * 我们举一个例子，例如13，这个数的平方根是要大于3小于4的，此时我们最终的left = 4，right = 3的
     * 因此我们如果在循环里面能够发现这个数是一个数的平方，那么我们就在循环内部返回，如果不是任意一个
     * 整数的平方，那么我们最终返回right这个值。其实这种思路早就在整数转罗马数字中用到过，这一次只不过
     * 是将数学的外衣剥掉，只剩下二分法赤裸着。此外，需要注意的是，题目给定我们的是非负整数，因此我们的
     * left应该是从0开始的。
     * 他们竟然还有更优秀的算法，就是数学知识的欠缺了，其中最无耻的就是题目规定不能使用Math.sqrt，
     * 但是还是有人用了。
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while(left <= right){
            long middle = (left + right)>>1;
            long mul = middle * middle;
            if(mul > x){
                right = middle - 1;
            }else if(mul < x){
                left = middle + 1;
            }else{
                return (int)middle;
            }
        }
        return (int)right;
    }
}
