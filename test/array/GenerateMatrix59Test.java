package array;

import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/02/12
 */
public class GenerateMatrix59Test {
    private GenerateMatrix59 generate  = new GenerateMatrix59();

    @Test
    public void test1(){
        int[][] matrix = generate.generateMatrix(1);
        printMatrix(matrix);
    }

    @Test
    public void test2(){
        int[][] matrix = generate.generateMatrix(2);
        printMatrix(matrix);
    }

    @Test
    public void test3(){
        int[][] matrix = generate.generateMatrix(3);
        printMatrix(matrix);
    }

    @Test
    public void test4(){
        int[][] matrix = generate.generateMatrix(4);
        printMatrix(matrix);
    }

    @Test
    public void test5(){
        int[][] matrix = generate.generateMatrix(5);
        printMatrix(matrix);
    }

    @Test
    public void test6(){
        int[][] matrix = generate.generateMatrix(0);
        printMatrix(matrix);
    }

    @Test
    public void test7(){
        int[][] matrix = generate.generateMatrix(-1);
        printMatrix(matrix);
    }
    private void printMatrix(int[][] matrix) {
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix.length;j++){
                System.out.print(matrix[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
