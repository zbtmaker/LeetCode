package backtracking;

/**
 * Created by Administrator on 2019\3\21 0021.
 */
public class LongestIncreasingPath329 {
    public static void main(String[] args){
        int[][] matrix = new int[][]{{3,4,5},
                {3,2,6},
                {2,2,1}};
        int longest = new LongestIncreasingPath329().longestIncreasingPath(matrix);
        System.out.println(longest);
    }

    /**
     * 使用回溯的方式会造成运行时间超时，那么我们就应该换一种思路来解决，在使用回溯的
     * 思路的时候，一个节点
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] maxPath = new int[]{0};
        int path = 0;
        boolean[][] sign = new boolean[row][col];
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                sign[i][j] = true;
                path ++;
                recurLongestPath(matrix,sign,i,j,path,maxPath);
                sign[i][j] = false;
                path --;
            }
        }
        return maxPath[0];
    }
    private void recurLongestPath(int[][] matrix,boolean[][] sign,int i,int j,int path,int[] maxPath){
        if(path > maxPath[0]){
            maxPath[0] = path;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        if(i-1 > -1 && !sign[i-1][j] && matrix[i][j] < matrix[i-1][j]){
            sign[i-1][j] = true;
            path ++;
            recurLongestPath(matrix,sign,i - 1,j,path,maxPath);
            sign[i-1][j] = false;
            path --;
        }
        if(i+1 < row && !sign[i+1][j] && matrix[i][j] < matrix[i+1][j]){
            sign[i+1][j] = true;
            path ++;
            recurLongestPath(matrix,sign,i + 1,j,path,maxPath);
            sign[i+1][j] = false;
            path --;
        }
        if(j-1 > -1 && !sign[i][j-1] && matrix[i][j] < matrix[i][j-1]){
            sign[i][j-1] = true;
            path ++;
            recurLongestPath(matrix,sign,i,j - 1,path,maxPath);
            sign[i][j-1] = false;
            path --;
        }
        if(j + 1 < col && !sign[i][j+1] && matrix[i][j] < matrix[i][j+1]){
            sign[i][j+1] = true;
            path ++;
            recurLongestPath(matrix,sign,i,j + 1,path,maxPath);
            sign[i][j+1] = false;
            path --;
        }

    }

    /**
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPathII(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] maxPath = new int[]{0};
        int[][] path = new int[row][col];
        boolean[][] sign = new boolean[row][col];
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                sign[i][j] = true;
                //path[i][j] = recurLongestPathII(matrix,sign,i,j,0,path,maxPath);
            }
        }
        return maxPath[0];
    }
    /*
    private int recurLongestPathII(int[][] matrix,boolean sign,int i,int j,int count,int[][]path,int[]maxPath){
        int row = matrix.length;
        int col = matrix[0].length;
        if(i-1 > -1 && !sign[i-1][j] && matrix[i][j] < matrix[i-1][j]){
            sign[i-1][j] = true;

            path[i][j -1]recurLongestPathII(matrix,sign,i - 1,j,path,maxPath);
            sign[i-1][j] = false;
            path --;
        }
        if(i+1 < row && !sign[i+1][j] && matrix[i][j] < matrix[i+1][j]){
            sign[i+1][j] = true;
            path ++;
            recurLongestPathII(matrix,sign,i + 1,j,path,maxPath);
            sign[i+1][j] = false;
            path --;
        }
        if(j-1 > -1 && !sign[i][j-1] && matrix[i][j] < matrix[i][j-1]){
            sign[i][j-1] = true;
            path ++;
            recurLongestPathII(matrix,sign,i,j - 1,path,maxPath);
            sign[i][j-1] = false;
            path --;
        }
        if(j + 1 < col && !sign[i][j+1] && matrix[i][j] < matrix[i][j+1]){
            sign[i][j+1] = true;
            path ++;
            recurLongestPath(matrix,sign,i,j + 1,path,maxPath);
            sign[i][j+1] = false;
            path --;
        }
        return 0;
    }*/
}
