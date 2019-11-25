package string;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\23 0023.
 */
public class longestPalindrome5 {
    public static void main(String[] args){
        String str = "babadada";
        System.out.println(longestPalindrome(str));
    }
    public static String longestPalindrome(String s) {
        if(s.length()<1){
            return "";
        }
        s = preManacher(s);
        int[] radius = manacher(s);
        int max = 0;
        int index = -1;

        for(int i = 0;i<radius.length;i++){
            if(max < radius[i]){
                max = radius[i];
                index = i;
            }
        }

        return s.substring(index- max + 1,index + max - 1).replaceAll("#","");
    }
    public static int[] manacher(String str){
        //str = preManacher(str);
        char[] chs = str.toCharArray();
        int[] radius = new int[chs.length];
        Arrays.fill(radius,1);
        int R = -1;
        int center = -1;
        for(int i =0;i<chs.length;i++){
            if(i > R || i+radius[2*center-i] - 1 == R){
                int temp = i>R ? i:center;
                int count = radius[2*temp-i];
                int left = i - radius[2*temp-i];
                int right = i + radius[2*temp-i];
                while(left>= 0 && right< chs.length && chs[left] ==  chs[right]){
                    count ++;
                    left --;
                    right ++;
                }
                radius[i] = count;
                if(R<right-1){
                    center = i;
                    R = right-1;
                }
            }else if(i + radius[2*center-i]-1>R){
                radius[i] = R - i + 1;
            }else{
                radius[i] = radius[2*center - i];
            }
        }
        return radius;
    }
    public static String preManacher(String str){
        StringBuilder sb = new StringBuilder(str.length()>>1+1);

        for(int i = 0;i<str.length();i++){
            sb.append('#');
            sb.append(str.charAt(i));
        }
        sb.append('#');
        return sb.toString();
    }
}
