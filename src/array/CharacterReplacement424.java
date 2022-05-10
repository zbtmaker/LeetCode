package array;

/**
 * @author zoubaitao
 * date 2022/04/13
 */
public class CharacterReplacement424 {
    /**
     * 这里需要返回替换后最长的字符串长度，我们用left和right指针维护一个窗口。用一个Map存储每一个
     * 字符出现的频次。我们仍然不能把left指针或者right指针作为main字符，就认为这个main字符出现的次数
     * 就是出现最多的频次，我们应该维护一个结构，在移动right和left指针的时候，时刻来更新窗口内出现字符
     * 最多次数的那个字符。
     *
     * @param s 字符串
     * @param k 最多可替换的字符数
     * @return 替换后最长的字符串长度
     */
    public int characterReplacement(String s, int k) {
        int res = 0, len = s.length(), left = 0, right = 0;
        int[] arr = new int[26];
        int max = 0;
        while (right < len) {
            char rightCh = s.charAt(right);
            int rightIndex = rightCh - 'A';
            arr[rightIndex] = arr[rightIndex] + 1;
            max = Math.max(max, arr[rightIndex]);
            while (right - left + 1 - max > k) {
                int leftIndex = s.charAt(left) - 'A';
                arr[leftIndex] = arr[leftIndex] - 1;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
