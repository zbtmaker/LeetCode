package dp;

/**
 * Created by Administrator on 2019\1\26 0026.
 */
public class UniquePathsWithObstacles63 {
    /**
     * 此题目和UniquePath62不同的点就是道路中间会有障碍，一旦碰到障碍，那么这个地方的
     * 路径数就是0。而且在初始化时不能像UniquePath62那样，需要考虑障碍物
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[][] dp = new int[row][col];
        dp[0][0] = obstacleGrid[0][0] ^ 1;
        for(int i = 1; i < col; i++){
            if(obstacleGrid[0][i] == 0){
                dp[0][i] = dp[0][i - 1];
            }
        }
        for(int j = 1; j < row; j++){
            if(obstacleGrid[j][0] == 0 )
                dp[j][0] = dp[j-1][0];
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
