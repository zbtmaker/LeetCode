package dp;

/**
 * Created by Administrator on 2019\3\19 0019.
 */
public class maximalSquare221 {
    public static void main(String[] args){
        char[][] matrix = new char[][]{
                {'0','0','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'},
                {'0','1','1','1'},
                {'0','1','1','1'},
                };
        int area = new maximalSquare221().maximalSquare(matrix);
        System.out.println(area);
    }

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        int[][] rec = new int[row+1][col+1];
        for(int i = 1;i <= row;i++){
            for(int j = 1;j <= col;j++){
                if(matrix[i-1][j-1] == '0' ){
                    rec[i][j] = 0;
                }else{
                    int count = 0;
                    int num = (int)(Math.sqrt(rec[i-1][j-1]));
                    for(int k = 1;k<=num;k++){
                        if(matrix[i-1][j-k-1] == '1' && matrix[i-k-1][j-1] == '1'){
                            count ++;
                        }else{
                            break;
                        }
                    }
                    rec[i][j] = ((matrix[i-1][j-1]- '0') + count)*((matrix[i-1][j-1] - '0') + count);
                }
                max = Math.max(rec[i][j],max);
            }

        }
        return max;
    }
}
