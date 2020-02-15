package dp;

/**
 * Created by Administrator on 2019\1\28 0028.
 */
public class MaxProduct152 {

    /**
     * 暴力算法：time complexity O(N^3), space complexity O(1)
     * 记忆法：time complexity O(N^2), space complexity O(N)
     * 双指针法：time complexity O(N), space complexity O(1)
     * @param nums 目标数组
     * @return 子数组乘积最大值
     */
    public int maxProduct(int[] nums) {
//        return maxProductByMemorizatioin(nums);
        return maxProductByDoublePointer(nums);
    }

    /**
     * 首先我用暴力的的方式解决这个问题，时间复杂度为O(N^3)的，空间复杂度为O(1),那下一步是不是就应该来优化这个算法了
     *
     * @param nums 数组
     * @return 子数组乘积最大值
     */
    private int maxProductByBruteForce(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int mul = nums[j];
                for (int k = j + 1; k <= i; k++) {
                    mul *= nums[k];
                }
                max = Math.max(max, mul);
            }
        }
        return max;
    }

    /**
     * 上面我们使用的暴力方式会涉及到一些重复计算，因此我们可以优化一下。我们用一个数组
     * aux来记录前面i个数的乘积，其中aux[i]=nums[0]*nums[1]*nums[i],如此以来就有
     * 下面的关系：aux[i] = aux[i-1] * nums[i]。此时的采用一个数组记录前面子数组的
     * 乘积，防止第三层循环。将时间复杂度变为O(N^2)，但是空间复杂度变为O(N)。但是这种方式
     * 还是会超时。
     *
     * @param nums 目标数组
     * @return 最大乘积子数组
     */
    private int maxProductByMemorizatioin(int[] nums) {
        int[] aux = new int[nums.length + 1];
        aux[0] = 1;
        int max = nums[0];
        int zeroIndex = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            max = Math.max(max, nums[i - 1]);
            if (nums[i - 1] == 0) {
                zeroIndex = i;
                aux[i] = 1;
                continue;
            }
            for (int j = zeroIndex; j < i; j++) {
                int mul = nums[i - 1] * aux[i - 1] / aux[j];
                if (j == zeroIndex) {
                    aux[i] = mul;
                }
                max = Math.max(max, mul);
            }
        }
        return max;
    }

    /**
     * 其实这个题目用动态规划的思想来解决这个问题，就是大的数组的最大值与添加一个元素之后构成一个
     * 大的数组的，也就是我之前曾经研究过的matroid属性差不多。举一个例子
     * testcase1: nums=[1,-2,4,-4,3,-3]
     * 1、subnums1=[1],此时数组的最大值为1，最大值集合为{1},最小值也为1,集合为{1}；
     * 2、subnums2={subnums1,-2}={1,-2},此时拿最大值还应该是1，最大值集合为空集，应该是-2,最小值集合{-2}。因为tmpMax>0,tmpMin>0,所以最大值集合为{},最小值集合为{1,-2};
     * 3、subnums3={subnums2,4}={1,-2,4},此时加入一个正数，对于最大值集合和最小值集合都有好处，此时不用去急着将元素添加到最大值集合，还要进行比较，很明显，这个题目可以添加。
     * 最大值集合为{4},最小值集合为{1,-2,4}
     * 4、subnums4={subnums3,-4}={1,-2,4,-4},此时新加入进来的是一个负数，此时最大值为32，最小值为-16。此时添加一个负数，因为，tmpMax > 0，而tmpMin < 0;这个时候就需要更
     * 换一下两个集合，最大值集合{1,-2,4,-4}，最小值集合{4,-4}.
     * 5、subnums5={subnums4,3}={1,2,4,-4,3},添加一个正数，直接乘，最大值为96，最小值为-48。此时将3元素直接添加到最大值集合中{1,-2,4,-4},最小值集合{4,-4,3}
     * 6、submuns6 = {subnums5,-3},添加进来一个负数，最大值为144，最小值为288。此时最大值集合和最小值集合应该是乘完以后交换两个集合，也就是最大值集合{4,-4,3,-3},最小值集合为{1,-2,4,-4}
     *
     * testcase2:nums=[-1, -2, -3]
     * 1、subnums1 = {nums[0]} = {-1}, maxSet = {-1}, minSet = {-1}, 此时tmpMax = -1, tmpMin = -1.
     * 2、subnums2 = subnums1 U {nums[1]} = {-1, -2}, maxSet= {-1, -2}, minSet={-2},此时tmpMax = 2, tmpMin = -2;
     * 3、subnums3 = subnums2 U {nums[2]} = {-1, -2, -3},maxSet = {-2, -3}, minSet{-1, -2, -3},此时tmpMax = 6, tmpMin = -6;
     *
     * testcase3:nums=[-2, -1, -2]
     * 1、subnums1 = {nums[0]} = {-2}
     * 1、subnums2 = subnums1 U {nums[1]} = {-2, -1}, maxSet = {-2, -1}, minSet = {}, 此时tmpMax = 2, tmpMin = 1;
     * 3、subnums3 = subnums2 U {nums[2]} = {-2, -1, -2}, maxSet = {}, minSet = {-2, -1, -2},此时tmpMax = 1, tmpMin = -4.
     *
     * 算法总结如下
     * 1、nums[i] > 0，
     *    a.如果tmpMax > 0 && tmpMin > 0, 此时直接添加到最大值和最小值集合中, 因为添加进去会使最大值最大，也会是最小值最小
     *    b.如果tmpMax < 0 && tmpMin < 0, 此时最小值集合minSet U {nums[i]}, 因为添加进去会使最小值集合的最小值变得更小，但是最大值集合就需要跟新了，此时最大值集合maxSet={nums[i]}
     *    c.如果tmpMax > 0 && tmpMin < 0, 此时直接将nums[i]添加到minSet,maxSet中. 和a的情况是一样的.
     *    d.如果tmpMax = 0 && tmpMin = 0, 此时最大值和minSet和maxSet就需要同时更新为{nums[i]}.
     * 2、nums[i] < 0,
     *    a.如果tmpMax > 0 && tmpMin > 0, 此时minSet = minSet U {nums[i]}, tmpMin = tmpMin * nums[i]; maxSet = {}, tmpMax = 1.
     *    b.如果tmpMax < 0 && tmpMin < 0, 此时maxSet = maxSet U {nums[i]}, 相应的tmpMax = tmpMax * nums[i]; 对于minSet需要进行判断，因为tmpMin < 0, nums[i] < 0,
     *      如果tmpMin < nums[i], 此时minSet = {}, tmpMin = 1; 如果tmpMin > nums[i], 那么此时minSet = {nums[i]}, tmpMin = nums[i];
     *    c.如果tmpMax > 0 && tmpMin < 0, 此时tmpSet = maxSet ,maxSet = minSet U {nums[i]}, minSet = tmpSet U {nums[i]}
     *    d.如果tmpMax = 0 && tmpMin = 0, 此时最大值和minSet和maxSet就需要同时更新为{nums[i]}.
     * 3、如果是0，此时需要将MinSet = {0}, maxSet={0},tmpMin = 0, tmpMax = 0.
     * 4、
     *
     * @param nums 目标数组
     * @return 子数组最大乘积
     */
    private int maxProductByDoublePointer(int[] nums) {
        int tmpMax = nums[0];
        int tmpMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (tmpMax > 0) {
                    tmpMax *= nums[i];
                    tmpMin *= nums[i];
                } else if (tmpMax < 0 && tmpMin < 0) {
                    tmpMax = nums[i];
                    tmpMin *= nums[i];
                } else {
                    tmpMax = nums[i];
                    tmpMin = nums[i];
                }
                max = Math.max(max, tmpMax);
            } else if (nums[i] < 0) {
                if (tmpMax > 0 && tmpMin > 0) {
                    tmpMax = 1;
                    tmpMin = tmpMin * nums[i];
                } else if (tmpMax < 0 && tmpMin < 0) {
                    if (tmpMin < nums[i]) {
                        tmpMin = 1;
                    } else {
                        tmpMin = nums[i];
                    }
                    tmpMin = Math.min(nums[i], tmpMin);
                    tmpMax *= nums[i];
                    max = Math.max(max, tmpMax);
                } else if (tmpMax > 0 && tmpMin < 0) {
                    int tmp = tmpMax * nums[i];
                    tmpMax = tmpMin * nums[i];
                    tmpMin = tmp;
                    max = Math.max(max, tmpMax);
                } else {
                    tmpMax = nums[i];
                    tmpMin = nums[i];
                    max = Math.max(max, tmpMax);
                }
            } else {
                max = Math.max(max, 0);
                tmpMin = 0;
                tmpMax = 0;
            }
        }
        return max;
    }
}
