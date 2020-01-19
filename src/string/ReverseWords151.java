package string;

/**
 * Created by Administrator on 2019\2\26 0026.
 */
public class ReverseWords151 {
    public String reverseWords(String s) {
        char[] chs = s.toCharArray();
        chs = reverseString(chs, 0, chs.length - 1);
        int start = 0;
        while(start < chs.length){
            while(chs[start] == ' '){

            }
            start ++;
        }

        return null;
    }

    /**
     * @param chs 字符数组
     * @param i   起始位置
     * @param j   结束位置
     * @return 翻转后的数组
     */
    private static char[] reverseString(char[] chs, int i, int j) {
        while (i < j) {
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
        return chs;
    }
}
