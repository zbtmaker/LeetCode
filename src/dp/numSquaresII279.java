package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\1\28 0028.
 * （一）题目：给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于n。
 * 你需要让组成和的完全平方数的个数最少。
 * （二）解题思路：这里我们先将元素集合确定了，然后就想硬币交换问题一样，集合中的元素就相当于
 * 硬币交换问题中的硬币（第一种硬币交换问题），此时可用一个辅助的数组来确定
 *
 */
public class numSquaresII279 {
    @Test
    public void test(){
        int count = new numSquaresII279().numSquares(4);
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
        return coinChange(candidates,n);
    }
    private int coinChange(List<Integer> candidates, int amount) {
        int[] DP = new int[amount+1];
        for(int i = 1;i<DP.length;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j<candidates.size();j++){
                if(candidates.get(j)>i){
                    break;
                }
                if(DP[i-candidates.get(j)]>=0){
                    min = Math.min(min,DP[i-candidates.get(j)]);
                }

            }
            if(min != Integer.MAX_VALUE){
                DP[i] = min + 1;
            }else{
                DP[i] = -1;
            }

        }
        return DP[amount];
    }
}
