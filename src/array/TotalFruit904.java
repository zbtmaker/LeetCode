package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zoubaitao
 * date 2022/04/16
 */
public class TotalFruit904 {
    /**
     * 这个题目就是在一个窗口内能够容忍的最多两个不同的字符数，如果超出了，那么这个窗口就需要进行移动，知道窗口
     * 内不同的字符数量≤2。这个题目是在窗口内至多出现一个不同的字符，至多出现0个字符的基础上调整了出现字符数的
     * 一个变种。
     * 同样，我们用left、right指针维护窗口，当窗口内不同字符数目≤2时，right指针继续向右滑动，当窗口内不同字符
     * 的数目>2时，此时需要移动left指针，使得窗口内不同的字符刚好≤2。我们用HashMap来统计窗口内每个字符出现的频次
     * 当一个字符在窗口内出现的频次==0时，此时我们就需要将这个字符从HashMap中移除。同时我们用max变量表示我们最多
     * 能够采摘的水果数量，max的初始值为0。最终返回max.
     *
     * @param fruits 水果种类数组
     * @return 能够采摘的最大水果数量
     */
    public int totalFruit(int[] fruits) {
        int max = 0, len = fruits.length, left = 0, right = 0;
        Map<Integer, Integer> fruitMapFreq = new HashMap<>(8);
        while (right < len) {
            int fruit = fruits[right];
            fruitMapFreq.put(fruit, fruitMapFreq.getOrDefault(fruit, 0) + 1);
            while (fruitMapFreq.size() > 2) {
                int leftFruit = fruits[left];
                int freq = fruitMapFreq.get(leftFruit) - 1;
                if (freq <= 0) {
                    fruitMapFreq.remove(leftFruit);
                } else {
                    fruitMapFreq.put(leftFruit, freq);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
