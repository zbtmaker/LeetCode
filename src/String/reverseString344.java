package String;

import org.junit.Test;

/**
 * Created by Administrator on 2019\2\8 0008.
 */
public class reverseString344 {
    @Test
    public void test(){
        char[] s = new char[]{'h','e','l','l','o'};
        new reverseString344().reverseString(s);
        System.out.println(s);
    }
    public void reverseString(char[] s) {
        int right = 0;
        int left = s.length - 1;
        while(right<left){
            swap(s,right++,left--);
        }
    }
    private void swap(char[] s, int i,int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
