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
     * <p>1、形如XYX的形式，此时我们需要在计算的时候先判断Y这个字符左边的长度和右边的长度，然后我们需要记录
     * XYX这个模式的长度，我们用一个map记录以X开头的包含或者不包含Y的长度，这样如果我们在这个字符串后面能够
     * 遇到一个X替换XYX中的Y，那么我们就能够计算出这个XYX替换之后的长度。
     * <p>
     * 2、对于中断之后应该怎么处理，变成了另外一个问题，比方说aaaba、aaabb、aaabc、aaabab，
     * 我们需要记录上一位置字符串Y出现的位置(lastDifIndex)。 用一个字符串初始状态lastDifIndex = -1标识连续字符串中
     * 未出现不同的字符串，使用right标识窗口的右边界，left指针指向窗口的左边界。
     * <p>a、当在一连串的字符串中发现一个不同的字符时，如果此时lastDifIndx = -1, 表明这个字符是这个连续字符串相同的字符中
     * 出现的第一个不同的字符，那么此时更新lastDifIndex为当前位置的索引。
     * <p>b、如果lastDifIndex != -1，那表明连续字符串中出现了两次不同的字符串，此时right指针指向的字符第二次出现字符，如果
     * right指针指向的字符char[left]和lastDifIndex指针指向的位置字符char[lastDifIndex]相同，如果此时lastDifIndex + 2 = right指针
     * 那么此时就需要更新left指针为lastDifIndex指针，同时此时出现的第一个不同的字符就是lastDifIndex和right指针两个指针中间的那个位置，也就是
     * 此时我们需要更新lastDifIndex = lastDifIndex + 1。如果lastDifIndex + 2 != right，那么此时就需要更新left指针为right指针指向的位置，
     * 同时更新lastDifIndex = -1。
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
                    } else {
                        if (cur == text.charAt(lastDifIndex)) {
                            if (lastDifIndex + 1 == right) {
                                left = lastDifIndex;
                                lastDifIndex = -1;
                            } else {
                                left = lastDifIndex;
                                lastDifIndex = left + 1;
                            }
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
