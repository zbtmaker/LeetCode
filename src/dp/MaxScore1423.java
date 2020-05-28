package dp;

/**
 * @author baitao zou
 * date 2020/05/26
 */
public class MaxScore1423 {
    public int maxScore(int[] cardPoints, int k) {
        return maxScoreByDoubleArrayDynamicProgramming(cardPoints, k);
    }


    private int maxScoreBacktracking(int[] cardPoints, int k) {
        if (k >= cardPoints.length) {
            return sumArr(cardPoints);
        }
        return recurMaxScore(cardPoints, k, 0, cardPoints.length - 1);
    }

    private int sumArr(int[] cardPoints) {
        int sum = 0;
        for (int point : cardPoints) {
            sum += point;
        }
        return sum;
    }

    /**
     * 其实我们可以用一个递归的方式来解决这个问题，那么递归的范式是什么呢？我们每次能够选择的就是
     * 头尾两个数字，而且只能取k次。用len = catdPoints.length,用F(0,len-1, k)表示我能够取k
     * 次的时候能够获得的最大值。
     * a.但是我们如果我们取了第0位，下次我们只能够选择1，len-1,此时能够选择的次数变为了k-1次。
     * b.如果选取了len-1位，下次我们能够选择的范围就是0，len-2，此时剩余能够选择的次数位k-1次。
     * 我们用公式来描述上面的两个选择:
     * F(0,len-1,k) = max(F(1,len-1,k-1)+cardPoints[0],F(0,len-2,k-2)+cardPoints[len-1])
     *
     * @param cardPoints
     * @param k
     * @return
     */
    private int recurMaxScore(int[] cardPoints, int k, int left, int right) {
        if (k == 0 || left > right) {
            return 0;
        }
        return Math.max(recurMaxScore(cardPoints, k - 1, left + 1, right) + cardPoints[left],
                recurMaxScore(cardPoints, k - 1, left, right - 1) + cardPoints[right]);
    }

    /**
     * 既然我们发现在取数的过程中得到的递推关系式为
     * F(0, len-1, k) = max(F(1, len-1, k-1)+cardPoints[0], F(0, len-2, k-2)+cardPoints[len-1])
     * 其实我们可以先不看取的次数k,那么我们就可以将上面的公式简化为下面的公式
     * F(0, len-1) = max(F(1, len-1)+cardPoints[0], F(0, len-2)+cardPoints[len-1])
     * 因此我们可以用数组将之前计算的结果保存起来，保存起来以后我们就可以减少一些重复的计算。这个就是经典的Memorization。
     * 我们需要用一个二维数组F[i][j]表示从第i位到第j位能够取到的最大分数，这个二维数组我们不需要
     * <p>
     * 上面的思路没错，但是没有抓住问题的关键点,其实我们最终需要的就是左边选几张卡牌，右边选几张卡牌。假设我们最终要取的卡牌数是
     * K张，那么我们的选择是依次如下(0,k),(1,k-1),(2,k-2)....(k,0)。所以这里我们可以用一个双层的循环实现，但是我们可以用两个
     * 数组来leftSum保存左边选取的元素个数和rightSum保存右边选取的卡牌数量，其中leftSum[i]表示左边选取了i张卡牌，那么右边选取
     * 的卡牌数量为rightSum[k-i]张。rightSum从右往左开始累加卡牌的值，而leftSum从右往左加卡牌的值。
     * 应该是下面的代码。
     *
     * @return 最大卡牌值
     */
    private int maxScoreByDoubleArrayDynamicProgramming(int[] cardPoints, int k) {
        if (cardPoints == null || cardPoints.length == 0 || k <= 0) {
            return 0;
        }
        int len = cardPoints.length;
        int[] leftSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            leftSum[i] = leftSum[i - 1] + cardPoints[i - 1];
        }
        if (k >= len) {
            return leftSum[len];
        }
        int[] rightSum = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + cardPoints[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            max = Math.max(leftSum[i] + rightSum[len - (k - i)], max);
        }
        return max;
    }

}
