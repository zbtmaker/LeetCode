package String;

/**
 * Created by Administrator on 2019\3\9 0009.
 */
public class ValidPalindrome125 {
    public static void main(String[] args){
        String str ="0p";
        boolean flag = new ValidPalindrome125().isPalindrome(str);
        System.out.println(flag);
    }
    /**
     * 双指针以及快熟排序中的partition方法。注意题干中的所说的
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int len = s.length();
        int i = 0;
        int j = len-1;

        while(i<=j){
            while(i<len &&
                    !((s.charAt(i) >= 'a' &&  s.charAt(i)<='z') ||
                            (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ||
                            (s.charAt(i) >= '0' && s.charAt(i) <= '9'))){
                i++;
            }
            while(j>-1 &&
                    !((s.charAt(j) >= 'a' &&  s.charAt(j)<='z') ||
                            (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z')||
                            (s.charAt(j) >= '0' && s.charAt(j) <= '9'))){
                j--;
            }
            if(i<j){
                char left = s.charAt(i);
                if(left<='Z'){
                    left = (char)(left + 32);
                }
                char right = s.charAt(j);
                if(right <= 'Z'){
                    right = (char)(right + 32);
                }
                if(left != right){
                    return false;
                }
            }
            i ++;
            j --;

        }
        return true;
    }
    /**
     * 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     */
}
