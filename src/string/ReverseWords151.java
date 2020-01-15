package string;

/**
 * Created by Administrator on 2019\2\26 0026.
 */
public class ReverseWords151 {
    public String reverseWords(String s) {

        return null;
    }

    private static char[] reverseString(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] chs = s.toCharArray();
        while (i < j) {
            char tmp = s.charAt(i);
            chs[i] = chs[j];
            chs[j] = tmp;
            i ++;
            j --;
        }
        return chs;
    }
    public static void main(String[] args){
        String s = "1234";
        char[] chs = reverseString(s);
        System.out.println(chs);
    }
}
