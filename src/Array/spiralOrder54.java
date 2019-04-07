package Array;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\7 0007.
 */
public class spiralOrder54 {
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = new spiralOrder54().spiralOrder(matrix);
        System.out.println(list);
    }

    /**
     * 此题需要考虑四种情况：

     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int index = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        while(index < row-1){
            //上行输出
            for(int i = index;i<col - index;i++){
                list.add(matrix[index][i]);
            }
            //左侧列输出
            for(int j = index + 1;j<row - index -1;j++){
                list.add(matrix[j][col - index -1]);
            }
            //下行输出
            for(int k = col - 1 - index;k>index-1;k--){
                list.add(matrix[row - 1 - index][k]);
            }
            //右侧列输出
            for(int l = row - 2 - index;l>index;l --){
                list.add(matrix[l][index]);
            }
            index ++;
        }

        return list;

    }

    /**
     * 测试案例I :
     * 1 2
     * 3 4
     * 5 6
     *
     * 测试案例 II :
     * 1 2 3
     * 4 5 6
     *
     * 测试案例 III :
     * 1
     *
     * 测试案例 IV
     * 1 2 3
     * 4 5 6
     * 7 8 9
     */
}
