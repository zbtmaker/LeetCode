package dp;

/**
 * Created by Administrator on 2019\1\27 0027.
 */
public class isSubsequence392 {
    public static void main(String[] args){
        System.out.println(isSubsequence("abc","ahbadc"));
    }
    public static boolean isSubsequence(String s, String t) {
        int i = 0;// a point which point to the short string
        int j = 0;// a point which point to the long string
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        if(i == s.length()){
            return true;
        }else{
            return false;
        }
    }
}
