package DP;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\26 0026.
 */
public class uniquePathsWithObstacles63 {
    public static void main(String[] args){
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int path = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(path);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] path = new int[row+1][col+1];
        path[1][0] = 1;

        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(obstacleGrid[i][j] == 1){
                    path[i+1][j+1] = 0;
                }else{
                    path[i+1][j+1] = path[i+1][j] + path[i][j+1];
                }
            }
        }
        return path[row][col];
    }
}
