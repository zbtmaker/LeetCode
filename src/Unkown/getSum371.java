package Unkown;

/**
 * Created by Administrator on 2019\3\21 0021.
 */
public class getSum371 {
    public static void main(String[] args){
        int num = new getSum371().getSum(-2,1);
        System.out.println(num);
    }

    /**
     * 这个题目主要用的就是我们在数字电路中学到的知识，两个数在底层相加是采用
     * 二进制的与、或、非实现的。因此我们想到了使用这些逻辑操作来实现我们的数字
     * 相加减。对于任意两个二进制有
     * A  B  S  C
     * 0  0  0  0
     * 0  1  1  0
     * 1  0  1  0
     * 1  1  0  1
     * 从这里我们可以看到对于任意的一个位我们可以通过两个位的 ^ 来得到相加的本位，可以
     * 通过两个位的 & 操作得到两个位的进位操作，但是我们需要注意的是，我们在原来的位得到
     * 进位后需要向左移一位（这个过程可以用两个数字模拟一下）。我们循环的停止时间就是当我们的进位位
     * 为零以后，我们的进位位就可以实现了
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        int carry = 0;
        int basic = 0;
        while(b != 0){
            basic = a ^ b;
            carry = a & b;
            a = basic;
            b = carry << 1;
        }
        return a;
    }
}
