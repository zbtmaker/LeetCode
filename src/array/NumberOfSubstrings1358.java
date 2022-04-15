package array;

/**
 * @author zoubaitao
 * date 2022/04/15
 */
public class NumberOfSubstrings1358 {
    /**
     * 我们用left和right指针维护一个窗口，如果窗口内字符'a','b','c'都又出现过一次，如果我们[left，right]指针这三个字符
     * 出现的频次都大于等于1，那么此时就表明窗口是一个有效的窗口，那么从left位置开始[0, left -1]区间长度为left，
     * 右区间的长度[right + 1, len-1]为len - 1 - (right + 1) + 1 = len - right - 1。
     * <p>I、当[left, right]窗口单独向左延伸可以得到left个包含'a'、'b'、'c'的字符串；
     * <p>II、单独向右延伸可以得到len - right - 1个包含'a'、'b'、'c'的字符串；
     * <p>III、如果窗口同时向左向右可以得到(1 + ... + left) * (1 + ... + len - right - 1)个包含'a'、'b'、'c'的字符串的字符串；
     * <p>IV、同时窗口[left, right]也是一个包含'a'、'b'、'c'的字符串；
     * <p>所以最终的结果为1 + left + len - right + 1 + (1+ ...+left) * (1 + ... + len - right - 1)。
     * <p>
     * 但是这里还有一些特殊的点，就是我们需要记录上一次同时包含a'、'b'、'c'的窗口的right指针位置，因为我们在实际计算的时候，向
     * 右边延伸并不能延伸到0，只能延伸到上一个窗口的右边界，这样才不会重复计算字符数。我们用lastRight指针表示上一个满足条件的窗口
     * 的有边界，那么我们额上面的I的长度就需要进行调整如下
     * <p>I、当[left,right]窗口单独想左延伸时的长度计算为left - 1 - (lastRight + 1) + 1 = left - lastRight - 1。</p>
     * <p>III、窗口同时向左向右延伸可以得到的长度为(1 + ...  + left - lastRight - 1) * (1 + ... + len - right - 1)。
     * 所以最终的结果可以修改为 1 + left - lastRight - 1 + len - right - 1 + (1 + ...  + left - lastRight - 1) * (1 + ... + len - right - 1)
     * <p> 这里还有一个问题就是当窗口[left,right]能够覆盖字符a'、'b'、'c'，此时移动left指针的时候，为了不重复计算，此时lastRight指针应该指向left移动之前的位置，
     * 这一点在代码中也有体现。
     * @param s 字符串
     * @return 所有包含字符'a'、'b'、'c'字符串数目
     */
    public int numberOfSubstrings(String s) {
        int res = 0, len = s.length(), left = 0, right = 0, lastRight = -1;
        int[] arr = new int[3];
        while (right < len) {
            char ch = s.charAt(right);
            arr[ch - 'a'] = arr[ch - 'a'] + 1;
            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                int index = s.charAt(left) - 'a';
                arr[index] = arr[index] - 1;
                int leftLen = left - 1 - (lastRight + 1) + 1;
                int rightLen = len - 1 - (right + 1) + 1;
                res += 1 + leftLen + rightLen + leftLen / 2 * (1 + leftLen) * rightLen / 2 * (1 + rightLen);
                lastRight = left;
                left++;
            }
            right++;
        }
        return res;
    }
}
