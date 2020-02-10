package array;

import java.util.Map;

/**
 * @author baitao zou
 * date 2020/02/10
 */
public class SingleNumber137 {
    public int singleNumber(int[] nums) {
        /*return singleNumberByHashMap(nums);*/
        return singleNumberByLogicCircuit(nums);
    }

    /**
     * 这个题目和SingleNumber136一样使用
     *
     * @param nums 目标数组
     * @return 只出现一次的数字
     */
    private int singleNumberByHashMap(int[] nums) {
        Map<Integer, Integer> map = ArrayUtils.count(nums);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 解析：我们的目标是使得三个数的运算结果为 0。你会发现三进制不计进位的加法恰好符合
     * 我们的要求：三个1相加结果为0。因此我们需要设计一个三进制的计数器。
     * 我们用a、b两位来表示状态，其中a、b的初始状态为0、0;与之相应的就是num中的元素就是
     * 输入，所以我们可以看到下面的状态转换表这里我们需要指的是二进制的每一位都需要进行
     * 下面的转换。
     * num  a   b   a1  b1
     * 1    0   0   0   1
     * 1    0   1   1   0
     * 1    1   0   0   0
     * 0    0   0   0   0
     * 0    0   1   0   1
     * 0    1   0   1   0
     *
     * 那么我们就可以得到变换之后的a的表达式，我们使用逻辑电路中的卡诺图来得到a1的表达式
     * num\ab  00   01  11  10
     * 0       0    1   x   0
     * 1       0    0   x   1
     * 因此我们可以得到a1 = ~num(~ab+ab) + num(ab+a~b) = ~numb+numa;
     *
     * 同理我们也可以得到b1的卡诺图
     * num\ab   00  01  11  10
     * 0        0   1   x   0
     * 1        1   0   x   0
     * 因此我们就可以得到b1= ~num(~ab+ab) + num~a~b=~numb+num~a~b
     * @param nums 目标数组
     * @return 只出现一次的数字
     */
    private int singleNumberByLogicCircuit(int[] nums) {
        int a = 0;
        int b = 0;
        int tmp;
        for (int num : nums) {
            tmp = (~num & a) | (num & b);
            b = (~a & ~b & num) | (b & ~num);
            a = tmp;
        }
        return b;
    }
}
