package array;

/**
 * @author baitao zou
 * date 2020/10/28
 */
public class Trap42 {
    public int trap(int[] height) {
        /*return countTrapByRow(height);*/
        /*return countTrapByColumn(height);*/
        return countTrapByDynamic(height);
    }

    /**
     * 按行计算的方式需要
     * 1、统计最高的行
     * 2、对每一层{1,...max},进行遍历，这里我们求每一行能够积累的水。假如我们要求m层的能够积累的水，
     * 那么我们一定要在左边找到一个高度大于等于m的。我们用tmp参数类存储积累的水，如果左边有个大于等于m的柱子，
     * 那么此时我们用flag=true来标识，而一旦再次碰到了高度height[i] > m ,此时就可以因为left有一个height[left] >=m
     * 此时tmp置零操作，重新积累
     * 3、时间复杂度O(mn),空间复杂度O(1)
     *
     * @param height 高度数组
     * @return
     */
    private int countTrapByRow(int[] height) {
        int result = 0;
        int max = maxHeight(height);
        for (int i = 1; i <= max; i++) {
            int tmp = 0;
            boolean flag = false;
            for (int value : height) {
                if (flag && value < i) {
                    tmp++;
                }
                if (value >= i) {
                    flag = true;
                    result += tmp;
                    tmp = 0;
                }
            }
        }
        return result;
    }

    /**
     * 求数组中最大元素
     *
     * @param height 高度数组
     * @return 最大高度
     */
    private int maxHeight(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i : height) {
            max = Math.max(i, max);
        }
        return max;
    }

    /**
     * 其实如果我们要通过按列的方式来求解，那么就需要根据每一列最高值和最低值，
     *
     * @param height
     * @return
     */
    private int countTrapByColumn(int[] height) {
        int len = height.length;
        int result = 0;
        for (int i = 1; i < len - 1; i++) {
            int leftMax = maxHeight(height, 0, i - 1);
            int rightMax = maxHeight(height, i + 1, len - 1);
            int minMax = Math.min(leftMax, rightMax);
            if (minMax >= height[i]) {
                result += minMax - height[i];
            }
        }
        return result;
    }

    private int maxHeight(int[] height, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(height[i], max);
        }
        return max;
    }

    /**
     * 动态规划是在按列求解的基础上优化时间复杂度而来，其实就是采用空间存储换时间的方式实现。
     * 这里就是采用两个数组来存储曾经计算过的值。
     *
     * @param height
     * @return
     */
    private int countTrapByDynamic(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int len = height.length;

        int[] maxLeftArr = new int[len];
        maxLeftArr[0] = height[0];

        int[] maxRightArr = new int[len];
        maxRightArr[len - 1] = height[len - 1];
        for (int i = 1; i < len - 1; i++) {
            maxLeftArr[i] = Math.max(maxLeftArr[i - 1], height[i - 1]);
            maxRightArr[len - i - 1] = Math.max(maxRightArr[len - i], height[len - i]);
        }
        int result = 0;
        for (int i = 1; i < len - 1; i++) {
            int minMax = Math.min(maxLeftArr[i], maxRightArr[i]);
            if (minMax > height[i]) {
                result += minMax - height[i];
            }
        }
        return result;
    }
}
