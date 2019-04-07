package Unkown;

/**
 * Created by Administrator on 2019\3\20 0020.
 */
public class judgeSquareSum633 {
    public static void main(String[] args){
        boolean flag = new judgeSquareSum633().judgeSquareSum(2);
        System.out.println(flag);
    }
    /**
     * 和二分法不同，但是都同属于双指针问题，循环结束的条件就是left > right.
     * 会出现超时的情形，所以这个也不是最好的方法。
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        if(c == 0 || c == 1){
            return true;
        }
        long left = 0;
        long right = c >> 1;
        while(left <= right){
            long sum = left * left + right * right;
            if(sum > c){
                right --;
            }else if(sum < c){
                left ++;
            }else{
                return true;
            }
        }
        return false;
    }
}
