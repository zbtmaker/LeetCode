package array;

/**
 * @author zoubaitao
 * date 2022/04/13
 */
public class CharacterReplacement424 {
    /**
     * 这里需要返回替换后最长的字符串长度，我们用left和right指针维护一个窗口。用一个Map存储每一个
     * 字符出现的频次。如果窗口内不同字符串的长度大于k, 那么此时就需要移动left指针使得窗口内的字符串
     * 能够满足字符串，在移动left指针的同时需要修改已经除窗口的字符串的频次。一旦窗口内字符串的频次能够
     * 满足条件，则停止移动left指针，继续移动right指针。
     * <p>
     * 问题来了，我们应该如何判定窗口不满足条件了呢，其实就是我们每次在移动right指针的时候，都会往Map里面
     * 新增一个entry或者，某一个entry的value会自增1。如果我们统计map中除了value最大的哪个entry不用计算在内，
     * 其余每个entry的value值之和就是最大能够替换的值。我们可以通过一些case来分析一下:
     * <p>1、 当k = 2，AAABBC，此时当right指针移动到C的时候，left指针指向索引0处，很显然此时[left, right]
     * 组成的窗口已经无法满足题目的要求了，因为right指针一定要在下一个窗口内，而目前窗口的左侧left指针指向字符'A'
     * 处，那么
     *
     * @param s 字符串
     * @param k 最多可替换的字符数
     * @return 替换后最长的字符串长度
     */
    public int characterReplacement(String s, int k) {
        return 0;
    }
}
