package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\3 0003.
 */
public class GrayCode89 {
    public static void main(String[] args){
        List<Integer> list = new GrayCode89().grayCode(0);
        for(Integer s : list){
            System.out.println(s);
        }
    }

    /**
     * 解题思路：我们将数组进行初始化，数组长度就是n。因为gray code需要每相邻的两位只有一位不同
     * 所以此时我在000,001，因此从一个3位的gray code可以发现，当我们采用递归的时候，递归到最后一位
     * 首先是什么都不用做，另一种情况是将当前位进行取反。这就得到了我们的递归范式。这里不需要采用改变
     * 数组元素后恢复现场，因此会简单很多。那么这个递归什么时候停止呢？只有当递归的index（表示递归到
     * 数组的哪一位了）达到数组的边界（nums.length）时，此时我们的递归就结束了。递归结束我们需要将
     * 0/1二进制转换成整数。
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> list = new LinkedList<>();
        if(n == 0){
            list.add(0);
            return list;
        }
        int[] nums = new int[n];
        recurGrayCode(nums,0,list);
        return list;
    }

    /**
     * 这是递归的主体
     * @param nums
     * @param index
     * @param list
     */
    private void recurGrayCode(int[] nums,int index,List<Integer> list){
        if(index == nums.length){
            list.add(arrayToInt(nums));
            return;
        }
        recurGrayCode(nums,index + 1,list);

        nums[index] = (nums[index] + 1) % 2;
        recurGrayCode(nums,index + 1,list);
    }

    /**
     * nums数组中每个位上存储的是1或者0，我们采用移位的方式求得nums数组代表的二进制位
     * 最终的整数是多少
     * @param nums
     * @return
     */
    private int arrayToInt(int[] nums){
        int len = nums.length;
        int sum = 0;
        for(int i = 0;i<len;i++){
            sum += nums[i] << (len-1-i);
        }
        return sum;
    }
    /**
     * 这是一个输出字符串的递归版本用于校验我们的回溯方法是否正确，经校验，我们的结果是正确的
     * @param n
     * @return
     */
    public List<String> grayCodeII(int n) {
        List<String> list = new LinkedList<>();
        if(n == 0){
            return list;
        }
        int[] nums = new int[n];
        recurGrayCodeII(nums,0,list);
        return list;
    }
    private void recurGrayCodeII(int[] nums,int index,List<String> list){
        if(index == nums.length){
            list.add(intToString(nums));
            return;
        }
        recurGrayCodeII(nums,index + 1,list);

        nums[index] = (nums[index] + 1) % 2;
        recurGrayCodeII(nums,index + 1,list);
    }
    private String intToString(int[] nums){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<nums.length;i++){
            sb.append(nums[i]);
        }
        return sb.toString();
    }
    /**
     * 0000     0001    0011    0010
     * 0110     0111    0101    0100
     * 1100     1101    1111    1110
     * 1010     1011    1001    1000
     */
}
