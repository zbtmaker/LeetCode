package string;

import org.junit.Test;


import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\22 0022.
 * Manacher 算法主要是为了解决字符串中的回文串判断问题
 * 一、首先介绍回文半径和回文最右边界：
 * （1）其中我们用一个回文半径数组记录每一个字符的回文半径
 * （2）回文右边界和回文中心，回文中心表示第一次到达回文右边界的中心
 * 二、主要分为两种大情况，第一种大情况
 * （I）当前字符在回文右边界的右边，此时暴力方法来扩回文
 * （II）当前字符i在回文右边界的内部，此时可以将情况分为三种情况（其中i'表示与回文中心对称的点）
 *      （a） 如果i'的回文半径在回文左边界的内部，此时i的回文半径与i'的回文半径相等
 *      （b） 如果i'的回文半径在回文左边界的外部，此时i的回文半径与i'的回文半径相等
 *      （c） 如果i'的回文半径与回文左边界重合，此时i的回文半径需要使用暴力进行扩展
 * 三、变量说明
 * R：表示最右回文右边界
 * radius：记录每个字符的回文半径，初始化为1
 * cur：用于记录最大回文右边界的中心
 * count：用于记录每一个字符的回文半径
 * 四、版本说明
 * VersionI 是按照四种情况分别讨论
 * VersionII 是在VersionI的改进版本，将两种情况(I)和(II-c)进行合并，将(II-a)和(II-b)进行合并
 */
public class Manacher {
    @Test
    public void test1(){
        String str = "cbbd";
        new Manacher().manacherII(str);
    }
    public int[] manacherI(String str){
        str = preManacher(str);
        char[] chs = str.toCharArray();
        int[] radius = new int[chs.length];
        Arrays.fill(radius,1);
        int R = -1;
        int center = -1;
        for(int i =0;i<chs.length;i++){
            int count = radius[i];
            if(i>R){
                int left = i-1;
                int right = i+1;
                while(left>= 0 && right< chs.length && chs[left] ==  chs[right]){
                    count ++;
                    left --;
                    right ++;
                }
                radius[i] = count;
                center = i;
                R = (right - 1)> R? (right -1):R;
            }else{
                if(i+radius[2*center-i] - 1 == R){
                    count = radius[2*center-i];
                    int left = i - radius[2*center-i];
                    int right = i + radius[2*center-i];
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
        }
        for(int i = 0;i<radius.length;i++){
            System.out.println(radius[i]);
        }
        return radius;
    }
    public int[] manacherII(String str){
        str = preManacher(str);
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
        for(int i = 0;i<radius.length;i++){
            System.out.println(radius[i]);
        }
        return radius;
    }
    public String preManacher(String str){
        StringBuilder sb = new StringBuilder(str.length()>>1+1);

        for(int i = 0;i<str.length();i++){
            sb.append('#');
            sb.append(str.charAt(i));
        }
        sb.append('#');
        return sb.toString();
    }
}
