package math;

/**
 * Created by Administrator on 2019\3\19 0019.
 */
public class reverse7 {
    public static void main(String[] args){
        int result = new reverse7().reverse(1534236469);
        System.out.println(result);
    }
    public int reverse(int x) {
        long a = x;
        a = Math.abs(a);
        String s = a + "";
        char[] chs = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
            i++;
            j--;
        }
        long mul = 1;
        long result = 0;
        for(int k = chs.length-1;k>-1;k--){
            result = result + (chs[k] -'0')*mul;
            mul *= 10;
        }
        if(x < 0){
            result = -result;
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }else{
            return (int)result;
        }
    }
}
