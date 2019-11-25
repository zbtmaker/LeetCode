package dp;

import org.junit.Test;

/**
 * Created by Administrator on 2019\1\26 0026.
 * 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
 * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
 */
public class minFallingPathSum931 {
    @Test
    public void test(){
        int[][] A = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int min = new minFallingPathSum931().minFallingPathSum(A);
        System.out.println(min);
    }
    public int minFallingPathSum(int[][] A) {
        int[][] DP = new int[A.length][A.length];
        for(int k = 0;k<A[0].length;k++){
            DP[0][k] = A[0][k];
        }

        for(int i = 1;i<A.length;i++){
            for(int j = 0;j<A[0].length;j++){

                if (j == 0) {
                    DP[i][j] = Math.min(DP[i-1][j],DP[i-1][j+1])+A[i][j];
                }else if(j == A[0].length-1){
                    DP[i][j] = Math.min(DP[i-1][j],DP[i-1][j-1])+A[i][j];
                }else{
                    DP[i][j] = Math.min(Math.max(DP[i-1][j],DP[i-1][j+1]),DP[i-1][j-1])+A[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int k = 0;k<A[0].length;k++){
            min = Math.min(min,DP[A.length-1][k]);
        }
        return min;
    }
}
