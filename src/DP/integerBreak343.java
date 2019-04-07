package DP;

import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2019\1\24 0024.
 * (一)题目：给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积
 * (二)思路：此题其实和combinationSum那个题很相似，就是给定一个数n,我们需要做的就是构造一个长为n-1的candidate数组，
 *          数组中的元素为1~n-1,
 */
public class integerBreak343 {
    @Test
    public void test(){
        int max = new integerBreak343().integerBreak(10);
        System.out.println(max);
    }
    public int integerBreak(int n) {
        int[] candidates = new int[n-1];
        for(int i = 0;i<n-1;i++){
            candidates[i] = i+1;
        }
        int target = n;
        return combinationSum(candidates,target);
    }
    public int combinationSum(int[] candidates, int target) {
        int max = 0;
        int sum = 0;
        int product = 1;
        for(int i = 0;i<candidates.length;i++){
            sum += candidates[i];
            product *= candidates[i];
            max = combinationSum(candidates,target,sum,i,product,max);
            product = 1;
            sum = 0;
        }
        return max;
    }
    private int  combinationSum(int[] candidates, int target,
                                int sum, int index,int product, int max) {
        if(sum == target){
            max = max < product? product : max;
            return max;
        }else if(sum > target) {
            return max;
        }else{
            for(int i = index;i<candidates.length;i++){
                sum += candidates[i];
                product *= candidates[i];
                max = combinationSum(candidates,target,sum,i,product,max);
                product /= candidates[i];
                sum -= candidates[i];
            }
        }
        return max;
    }
    /*public int combinationSum(int[] candidates, int target) {
        int max = 0;
        int sum = 0;
        int product = 1;
        for(int i = 0;i<candidates.length;i++){
            ArrayList<Integer> array = new ArrayList<Integer>();
            sum += candidates[i];
            product *= candidates[i];
            array.add(candidates[i]);
            max = combinationSum(candidates,target,sum,i,product,max,array);
            product = 1;
            sum = 0;
        }
        return max;
    }
    private int  combinationSum(int[] candidates, int target,
                                int sum, int index,int product,
                                int max,ArrayList<Integer> array) {
        if(sum == target){
            max = max < product? product : max;
            System.out.println(Arrays.toString(array.toArray()));
             return max;
        }else if(sum > target) {
            return max;
        }else{
            for(int i = index;i<candidates.length;i++){
                sum += candidates[i];
                product *= candidates[i];
                array.add(candidates[i]);
                max = combinationSum(candidates,target,sum,i,product,max,array);
                array.remove(array.size()-1);
                product /= candidates[i];
                sum -= candidates[i];
            }
        }
        return max;
    }*/
}
