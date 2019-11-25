package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\1\27 0027.
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少，并输出这个组合。
 * 解题思路：
 * 第一步就是确定一个集合让这个集合中的元素是（比如 1, 4, 9, 16, ...）但是这个集合中最后一个元素一定要小于给定的n
 * 组合的问题主要是要需要将组合输出，所以需要回溯的方法确定组成这个集合的元素。
 *
 */
public class numSquaresI279 {
    @Test
    public void test(){
        int count = new numSquaresI279().numSquares(13);
        System.out.println(count);
    }
    public int numSquares(int n) {
        ArrayList<Integer> candidates = new ArrayList<Integer>();
        int i = 1;
        while(true){
            if (i * i <= n) {
                candidates.add(i*i);

            }else{
                break;
            }
            i ++;
        }
        return combinationSum(candidates,n) ;

    }
    public int combinationSum(List<Integer> candidates, int target) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0;i<candidates.size();i++){
            sum += candidates.get(i);
            count ++;
            min = combinationSum(candidates,target,sum,i,min,count);
            sum = 0;
            count = 0;
        }
        return min;
    }
    private int combinationSum(List<Integer> candidates, int target,
                                  int sum, int index,int min,int count) {
        if(sum == target){
            return Math.min(min,count);
        }else if(sum > target) {
            return min;
        }else{
            for(int i = index;i<candidates.size();i++){
                sum += candidates.get(i);
                count ++;
                min = combinationSum(candidates,target,sum,i,min,count);
                count --;
                sum -= candidates.get(i);
            }
        }
        return min;
    }

}
