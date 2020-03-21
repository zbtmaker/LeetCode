package dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/03/21
 */
public class MaximalRectangle85Test {

    private MaximalRectangle85 max = new MaximalRectangle85();
    @Test
    public void test0(){
        char[][] matrix = new char[][]{{'0','0','0'}
                                      ,{'0','0','0'}
                                      ,{'1','1','1'}};
        int area = max.maximalRectangle(matrix);
        Assert.assertEquals(area,3);
    }
    @Test
    public void test1(){
        char[][] matrix = new char[][]{{'0','1','1','0','1'},
                                       {'1','1','0','1','0'},
                                       {'0','1','1','1','0'},
                                       {'1','1','1','1','0'},
                                       {'1','1','1','1','1'},
                                       {'0','0','0','0','0'}};

        int area = max.maximalRectangle(matrix);
        Assert.assertEquals(area,9);
    }
    @Test
    public void test2(){
        char[][] matrix = new char[][]{{'0','1'},{'0','1'}};
        int area = max.maximalRectangle(matrix);
        Assert.assertEquals(area,2);
    }
    @Test
    public void test3(){
        char[][] matrix = new char[][]{{'1','1'}};
        int area = max.maximalRectangle(matrix);
        Assert.assertEquals(area,2);
    }
    @Test
    public void test4(){
        char[][] matrix = new char[][]{{'1'}};
        int area = max.maximalRectangle(matrix);
        Assert.assertEquals(area,1);
    }
    @Test
    public void test5(){
        char[][] matrix = new char[][]{{'1','0','1','0'},
                                       {'1','0','1','1'},
                                       {'1','0','1','1'},
                                       {'1','1','1','1'},
        };
        int area = max.maximalRectangle(matrix);
        Assert.assertEquals(area,6);
    }
    @Test
    public void test6(){
        char[][] matrix = new char[][]{
                {'1','0','1','1','1'},
                {'0','1','0','1','0'},
                {'1','1','0','1','1'},
                {'1','1','0','1','1'},
                {'0','1','1','1','1'}
        };
        int area = max.maximalRectangle(matrix);
        Assert.assertEquals(area,6);
    }
}
