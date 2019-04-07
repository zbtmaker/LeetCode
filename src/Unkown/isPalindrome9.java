package Unkown;

/**
 * Created by Administrator on 2019\3\7 0007.
 */
public class isPalindrome9 {
    public static void main(String[] args){
        boolean flag = new isPalindrome9().isPalindrome(100);
        System.out.println(flag);
    }
    public boolean isPalindrome(int x) {
        if(x < 0 ){
            return false;
        }
        String s = x + "";
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }
}
