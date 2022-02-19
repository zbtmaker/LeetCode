package array;

/**
 * @author zoubaitao
 * date 2019/1/17
 */
public class Transpose867 {

    public int[][] transpose(int[][] A) {
        int row = A.length, col = A[0].length;
        int[][] T = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                T[j][i] = A[i][j];
            }
        }
        return T;
    }
}
