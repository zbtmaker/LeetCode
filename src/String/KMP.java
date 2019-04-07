package String;

/**
 * Created by Administrator on 2019\3\22 0022.
 */
public class KMP {
    public static void main(String[] args){
        String haystack = "";
        String needle = "";
        KMP kmp = new KMP();
        System.out.println(kmp.strStr(haystack,needle));
    }
    /**
     * 从haystack中找到needle出现的第一个位置，我们这里使用KMP的思想来解决
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int lenh = haystack.length();
        int lenn = needle.length();
        if(lenn == 0){
            return 0;
        }

        int[] next = getNext(needle);

        int i = 0;
        int j = 0;

        while(i < lenh && j < lenn){
            if(haystack.charAt(i) == needle.charAt(j)){
                i ++;
                j ++;
            }else if(j == 0){
                i ++;
            }
            else{
                j = next[j -1];
            }
        }
        return j == lenn ? i - j : -1;
    }

    /**
     * 在KMP当中，其实就是Next数组才是最难求的，例子：ababac
     * 第一种情况:当s.charAt(i) == s.charAt(next[i - 1]);此时
     *           next[i] = next[i - 1] + 1;
     * 第二种情况:当s.charAt(i)  == s.charAt(next[i - 1]);此时
     *           这时候该么办？？此时我们定义一个j = next[i - 1],然后 j = next[j - 1];
     *           如果再不相等，那么继续如此操作就可以了
     * @param s
     * @return
     */
    private int[] getNext(String s){
        int len = s.length();
        int[] next = new int[len];
        next[0] = 0;
        int i = 1;
        while(i < len){
            char ch = s.charAt(i);
            if(ch == s.charAt(next[i - 1])){
                next[i] = next[i - 1] + 1;
            }else{
                int j = next[i - 1];
                while(j > 0 && ch != s.charAt(j)){
                    j = next[j -1];
                }
                if(j == 0){
                    if(ch != s.charAt(j)){
                        next[i] = 0;
                    }else{
                        next[i] = next[j] + 1;
                    }
                }else{
                    next[i] = next[j] + 1;
                }

            }
            i++;
        }
        return next;
    }
}
