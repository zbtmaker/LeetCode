package string;

/**
 * @author zoubaitao
 * date 2022/04/03
 */
public class ReverseStr541 {

    /**
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     * 每2k个字符作为一组，取余剩下的长度判断是否满足大于k
     *
     * @param s 字符串
     * @param k 分组翻转
     * @return 字符串
     */
    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        int mod = len % (2 * k), res = len / (2 * k);
        int i = 0, left;
        for (; i < res; i++) {
            left = i * 2 * k;
            reverse(chs, i * 2 * k, left + k - 1);
        }
        left = i * 2 * k;
        if (mod >= k) {
            reverse(chs, left, left + k - 1);
        } else {
            reverse(chs, left, len - 1);
        }
        return String.valueOf(chs);
    }

    private void reverse(char[] chs, int left, int right) {
        while (left < right) {
            char tmp = chs[left];
            chs[left] = chs[right];
            chs[right] = tmp;
            left++;
            right--;
        }
    }
}
