package array;

import java.util.Arrays;

/**
 * @author zoubaitao
 * date 2022/04/10
 */
public class MaxRepOptI1156 {
    /**
     * 至多交换其中两个字符，使得交换之后的单字符重复子串长度最长。也就是我们允许连续的子串中出现
     * 一个其他的字符出现在重复子串中。但是我们需要考虑其中的一些问题
     *
     * <p>
     * 如果一个窗口中出现了对于中断之后应该怎么处理，比方说aaaba、aaabb、aaabc、aaabab，我们需要记录上一位置字符串Y出现
     * 的位置(lastDifIndex)。 用一个字符串初始状态lastDifIndex = -1标识连续字符串中
     * 未出现不同的字符串，使用right标识窗口的右边界，left指针指向窗口的左边界。那么我们应该以什么样的规则来维护一个窗口
     * 呢？在left和right指针组成的窗口中，至多存在一个不同的字符，也就是在right=left时，我们能够容忍lastDifIndex != -1。
     * 如果left和right指针组成的窗口中，其中lastDifIndex != -1，而且right指针指向的字符已经和left指针指向的字符不同时，
     * 那表明我们的窗口已经出现两个不同的字符了，那么此时就应该移动left指针和lastDif指针，使得窗口内不同的字符数量≤1。我们
     * 确定好窗口的规则之后就要进行下面的移动窗口了。
     * <p>a、当在一连串的字符串中发现一个不同的字符时，如果此时lastDifIndx = -1, 表明这个字符是这个连续字符串相同的字符中
     * 出现的第一个不同的字符，那么此时更新lastDifIndex为当前位置的索引。
     * <p>b、如果此时right位置的字符和left位置的字符不相同，且lastDifIndex != -1，那表明连续字符串中出现了两次不同的字符串，此时
     * 这个窗口已经不能继续向右滑动。情况又可以分为一下几种：
     * <p>b1、如果lastDifIndex + 2 < right(形如：aaacaaab，此时lastDifIndex = 3, right = 7)，此时应该更新left指针和
     * lastDifIndex指针，此时left = lastDifIndex, lastDifIndex = right。此时移动之后就能保证我们的窗口内只有一个不同的字符。
     * <p>b2、如果lastDifIndex + 2 == right(形如：aaacab，此时lastDifIndex = 3, right = 5)，此时窗口内又两个不同的字符，
     * 那么我们要判断lastDifIndex指向的字符和right指向的字符是否相等，如果相等，那么此时left指向lastDifIndex，而lastDifIndex
     * 指向right -1。如果lastDifIndex指向的字符和right指向的字符不相等，那么此时left指针就指向right-1，而lastDifIndex指针指向
     * right。这两种情况都能使我们的窗口在left和right范围内出现≤1个不同的字符。
     * <p>b3、如果lastDifIndex + 1 ==right (形如：acb，此时lastDifIndex = 1, right = 2)，此时只需要将left指针指向lastDifIndex，
     * 而lastDifIndex指向right指针即可满足窗口定义。
     * <p>这里还有一个点就是，存在aaacaa出现在字符串中，应该如何判定一个字符串中在这个字符串左边或者右边是否还存在字符'a'呢？我们需要一个数组
     * indexArr = new int[26][2]记录第一次出现某一个字符的位置，用长度为26的二维数组其中第一位记录右边首次出现某个字符的位置，二维数组的第二位
     * 记录左边首次出现某个字符的位置。如果我们能够在数组中发现一个形如XYX的数组，那么如果在X的左侧存在一个X的字符或者在XYX的右侧存在一个X
     * 的字符，那么这个XYX字符串的长度是就是XYX的长度，否则，XYX的长度就是XY的长度-1或者YX的长度-1。
     *
     * @param text 字符串文本
     * @return 最长重复字符串子串
     */
    public int maxRepOpt1(String text) {
        int max = 1, lastDifIndex = -1, len = text.length();
        int left = 0, right = 1;
        int[][] indexArr = firstIndex(text);
        while (right < len) {
            char cur = text.charAt(right);
            if (cur != text.charAt(left)) {
                if (lastDifIndex == -1) {
                    lastDifIndex = right;
                } else {
                    int[] leftIndex = indexArr[text.charAt(left) - 'a'];
                    if (leftIndex[0] < left || leftIndex[1] > right) {
                        max = Math.max(max, right - left);
                    }
                    if (lastDifIndex + 2 < right) {
                        left = lastDifIndex + 1;
                        lastDifIndex = right;
                    } else if (lastDifIndex + 2 == right) {
                        if (cur == text.charAt(lastDifIndex)) {
                            left = lastDifIndex;
                            lastDifIndex = left + 1;
                        } else {
                            left = right - 1;
                            lastDifIndex = right;
                        }
                    } else {
                        if (cur == text.charAt(lastDifIndex)) {
                            left = lastDifIndex;
                            lastDifIndex = -1;
                        } else {
                            left = lastDifIndex;
                            lastDifIndex = left + 1;
                        }
                    }
                }
            } else {
                // 因为中间存在存在不同的元素，那么right-left + 1是原本的长度，
                // 去掉1就是中间存在的长度
                if (lastDifIndex != -1) {
                    max = Math.max(max, right - left);
                } else {
                    max = Math.max(max, right - left + 1);
                }
            }
            right++;
        }
        // 循环结束应该还有一次判定的
        int[] leftIndex = indexArr[text.charAt(left) - 'a'];
        if (leftIndex[0] < left || leftIndex[1] > right) {
            if (lastDifIndex != -1) {
                max = Math.max(max, right - left);
            } else {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }

    /**
     * 返回每个字符在text字符串中第一次出现在左边和右边的位置
     *
     * @param text 字符串
     * @return 第一次出现在左边和右边的字符擦魂
     */
    private int[][] firstIndex(String text) {
        int[][] indexArr = new int[26][2];
        for (int[] index : indexArr) {
            Arrays.fill(index, -1);
        }
        int len = text.length();
        for (int i = 0; i < len; i++) {

            char leftCh = text.charAt(i);
            int leftIndex = leftCh - 'a';
            if (indexArr[leftIndex][0] == -1) {
                indexArr[leftIndex][0] = i;
            }

            char rightCh = text.charAt(len - 1 - i);
            int rightIndex = rightCh - 'a';
            if (indexArr[rightIndex][1] == -1) {
                indexArr[rightIndex][1] = len - 1 - i;
            }
        }
        return indexArr;
    }
}
