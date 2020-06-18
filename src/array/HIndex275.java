package array;

/**
 * @author baitao zou
 * date 2020/06/16
 */
public class HIndex275 {
    /**
     * 当文章的影响因子是有序的情况下，我们需要找到max{citations[i] <= len - i,i=1、2...citations.length}.
     * 可以采用二分法的方式来实现，此时算法的时间复杂度为O(logN),空间复杂度为O(1)。
     * 如果采用二分法算法，那么就需要确定二分的规则，这里我们分三种情况讨论，
     * 1、如果citations数组所有元素都是0，表示所有文章的引用数量为0，因此该作者的影响因子为0；
     * 2、如果citations中有一个索引i, 其中citations[i] == len - i。那么这个时候我们知道，citations[i+1]一定有
     * citations[i+1] > len - i - 1;
     * 我们使用反证法来证明，我们假设存在一个i,citations[i] == len - i,且存在citations[i+1] >= len - i - 1;
     * 因为citations[i] <= citations[i+1], 根据citations[i+1] >= citations[i] = len - i;
     * a.首先考虑citations[i+1] == citations[i]，那么citations[i+1] > len - i - 1的。
     * b.考虑citations[i+1] > citations[i]= len - i,那么citations[i+1] > len - i -1的。
     * 综合上面的a、b可以得出结论为citations[i+1] > len - i - 1;
     * 因此如果citations[i] = len - i，此时可以退出整个循环，从而得到了该作者的影响因子
     * 3、如果发现整个二分过程都没有找到citations[i] = len - i 的值，那么数组中可能会存在citations[i] < len - i的
     * 值，此时citations[i]是其一个影响因子值，但不是最大的那个影响因子值。为什么会这么说呢？我们假设citations[m] < len - i,是
     * 最后一个满足条件的citations[i] < len - i的。因为不存在citations[i] = len - i，所以citations[m + 1] >len - i。那么还
     * 存在一个影响因子就是len - i ,又因为citations[m] < len - i，所以我们从这个条件中能够找到的最大影响因子就是len - i.
     * <p>
     * 从上面我们的分析过程可以知道，如果citations[mid] < len - i;那么我们就应该找一个更大的影响因子，最后二分的结果是left > right,退出循环。
     * 如果citations[mid] > len - i,那么这个时候不满足影响因子的条件，因此需要right = mid - 1;如果citations[mid] = len - i,此时直接返回影响因子
     * 如果在循环过程中没有找到最大的影响因子，那么就按照我们上面讨论的第三点来计算。整个过程证明了我们的循环为什么能够得到一个最优解。
     *
     * @param citations 影响因子集合
     * @return 最大的影响因子
     */
    public int hIndex(int[] citations) {
        if (citations.length == 0 || citations[citations.length - 1] == 0) {
            return 0;
        }
        int len = citations.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (citations[mid] < len - mid) {
                left = mid + 1;
            } else if (citations[mid] > len - mid) {
                right = mid - 1;
            } else {
                return citations[mid];
            }

        }
        return len - left;
    }
}
