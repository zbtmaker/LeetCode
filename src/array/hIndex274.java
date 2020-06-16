package array;


/**
 * LeetCode274:https://leetcode-cn.com/problems/h-index
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数 不超过 h 次。）
 * 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
 *
 * @author Baitao Zou
 * date 2020/06/16
 */
public class HIndex274 {

    /**
     * 根据题目的意思，然后根据官方题解给出的提示，采用统计排序的思想。我们采用三步走的思想解决问题，
     * 我们用一个辅助数组，数组的索引表示影响因子出现的次数。
     * 第一步是找到这个用户最大的影响因子，然后构建一个数组，第二步从尾部大于等于影响因子的统计每篇文章影响因子出现的次数。
     * 第三步然后从数组的尾部开始判断索引i位置的大于该影响因子的文章数量这个时候就能得到作者的影响因子了。
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int value : citations) {
            max = Math.max(value, max);
        }
        if (max == 0) {
            return 0;
        }
        int[] count = new int[max + 1];
        for (int citation : citations) {
            count[citation]++;
        }

        for (int i = count.length - 1; i > 0; i--) {
            count[i - 1] += count[i];
        }
        int maxIndex = -1;
        for (int i = count.length - 1; i > 0; i--) {
            if (count[i] >= i) {
                maxIndex = Math.max(maxIndex, i);
            }
        }
        return maxIndex;
    }
}
