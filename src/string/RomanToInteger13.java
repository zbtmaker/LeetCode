package string;

/**
 * Created by Administrator on 2019\3\9 0009.
 */
public class RomanToInteger13 {
    public static void main(String[] args){
        String s = "LVIII";
        int sum = new RomanToInteger13().romanToInt(s);
        System.out.println(sum);
    }
    public int romanToInt(String s) {
        int i = s.length()-1;
        int sum = 0;
        int last = 0;
        int cur = 0;
        while(i>-1){
            if(i > 0 && (last =func(s.charAt(i-1)))<(cur=func(s.charAt(i)))){
                sum += cur - last;
                i -= 2;
            }else if(i > 0 && last >= cur){
                sum += cur;
                i --;
            }else{
                sum += func(s.charAt(i));
                i --;
            }
        }
        return sum;
    }
    private int func(char ch){
        switch(ch){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default: return 0;
        }
    }
}
