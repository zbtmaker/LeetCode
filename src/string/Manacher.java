package string;

/**
 * Created by Administrator on 2019\1\22 0022.
 * Manacher 算法主要是为了解决字符串中的回文串判断问题
 * 一、首先介绍回文半径和回文最右边界：
 * （1）其中我们用一个回文半径数组记录每一个字符的回文半径
 * （2）回文右边界和回文中心，回文中心表示第一次到达回文右边界的中心
 * 二、主要分为两种大情况，第一种大情况
 * （I）当前字符在回文右边界的右边，此时暴力方法来扩回文
 * （II）当前字符i在回文右边界的内部，此时可以将情况分为三种情况（其中i'表示与回文中心对称的点）
 * （a） 如果i'的回文半径在回文左边界的内部，此时i的回文半径与i'的回文半径相等
 * （b） 如果i'的回文半径在回文左边界的外部，此时i的回文半径与i'的回文半径相等
 * （c） 如果i'的回文半径与回文左边界重合，此时i的回文半径需要使用暴力进行扩展
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
    /**
     * 我们对于每一个给定的字符串，第一步做的事情就是预处理，在字符串的头部和尾部都添加一个"#"字符，同时每个字符串
     * 中间也应该添加一个字符"#"。例如字符串"aba"，预处理之后就变成了"#a#b#a#"
     * 我们用三个指针来维护当前位置的最长的回文字符串，L-回文左边界，R-回文右边界，C-下一个回文的中心位置。如果一个
     * 用指针i表示当前位置。如果当前位置的回文右边界超出了之前的回文有边界，那么需要更新C（下一个回文的中心位置）。
     * I、如果当前位置不在[L,R]范围内，那么采用朴素的方式判断以当前位置为核心的
     *
     * @param s
     * @return
     */
    public static int[] manacher(String s) {
        StringBuilder sb = preManacher(s);
        return manacher(sb);
    }

    public static int[] manacher(StringBuilder sb) {
        int size = sb.length();
        int[] radius = new int[sb.length()];
        int R = -1;
        int center = -1;
        for (int i = 0; i < size; i++) {
            radius[i] = 1;
            // 指针i不在上一个回文范围内，此时采用朴素的方式计算当前位置为核心的回文
            // 如果i的镜像位置2*center-i的半径Radius[2*center - i] - 1 + i 的位置刚好处在上一个回文的边界位置,
            // 同样也是采用朴素的方式计算当前位置的回文半径
            if (i > R || i + radius[2 * center - i] - 1 == R) {
                int temp = i > R ? i : center;
                int count = radius[2 * temp - i];
                int left = i - radius[2 * temp - i];
                int right = i + radius[2 * temp - i];
                while (left >= 0 && right < size && sb.charAt(left) == sb.charAt(right)) {
                    count++;
                    left--;
                    right++;
                }
                radius[i] = count;
                if (R < right - 1) {
                    center = i;
                    R = right - 1;
                }
            } else if (i + radius[2 * center - i] - 1 > R) {
                // 如果当前指针在上一个回文半径内部，但是i的镜像位置的回文半径超出了L，那么i位置的回文半径必定是i~R区间的的长度
                // 这里我们可以使用反证法，假如i位置的回文半径也超出了R，那么前一个回文有边界将不再是R，而是另外一个参数，因为
                // 根据对称特性可以得知。因此就可以得到i位置的回文半径。
                radius[i] = R - i + 1;
            } else {
                // 如果当前指针在上一个回文半径内部，且当前位置i+radius[2*center-i] - 1 < R，那么就不需要重复计算当前位置
                // 的回文半径，这个是因为镜像位置都是对称的，所以不需要计算了。
                radius[i] = radius[2 * center - i];
            }
        }
        return radius;
    }

    public static StringBuilder preManacher(String str) {
        StringBuilder sb = new StringBuilder(str.length() >> 1 + 1);
        for (int i = 0; i < str.length(); i++) {
            sb.append('#');
            sb.append(str.charAt(i));
        }
        sb.append('#');
        return sb;
    }
}
