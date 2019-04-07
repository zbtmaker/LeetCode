package DP;

import Array.MaximumProductSubarray152;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\19 0019.
 */
public class maximalRectangle85 {
    /*public static void main(String[] args){
        char[][] matrix = new char[][]{{'0','1','1','0','1'},
                {'1','1','0','1','0'},
                {'0','1','1','1','0'},
                {'1','1','1','1','0'},
                {'1','1','1','1','1'},
                {'0','0','0','0','0'}};

        int area = new maximalRectangle85().maximalRectangle(matrix);
        System.out.println(area);
    }*/
    @Test
    public void test0(){
        char[][] matrix = new char[][]{{'0','0','0'},{'0','0','0'},{'1','1','1'}};
        int area = new maximalRectangle85().maximalRectangle(matrix);
        System.out.println(area);
    }
    @Test
    public void test1(){
        char[][] matrix = new char[][]{{'0','1','1','0','1'},
                {'1','1','0','1','0'},
                {'0','1','1','1','0'},
                {'1','1','1','1','0'},
                {'1','1','1','1','1'},
                {'0','0','0','0','0'}};

        int area = new maximalRectangle85().maximalRectangle(matrix);
        System.out.println(area);
    }
    @Test
    public void test2(){
        char[][] matrix = new char[][]{{'0','1'},{'0','1'}};
        int area = new maximalRectangle85().maximalRectangle(matrix);
        System.out.println(area);
    }
    @Test
    public void test3(){
        char[][] matrix = new char[][]{{'1','1'}};
        int area = new maximalRectangle85().maximalRectangle(matrix);
        System.out.println(area);
    }
    @Test
    public void test4(){
        char[][] matrix = new char[][]{{'1'}};
        int area = new maximalRectangle85().maximalRectangle(matrix);
        System.out.println(area);
    }
    @Test
    public void test5(){
        char[][] matrix = new char[][]{{'1','0','1','0'},
                {'1','0','1','1'},
                {'1','0','1','1'},
                {'1','1','1','1'},
                };
        int area = new maximalRectangle85().maximalRectangle(matrix);
        System.out.println(area);
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        List<List<Rectangular>> lists = initial(row,col);
        for(int i = 0;i < row;i ++){
            for(int j = 0;j < col;j ++){
                Rectangular rec= lists.get(i).get(j);
                if(i == 0 && j == 0){
                    rec.xLen = (matrix[i][j] - '0');
                    rec.yLen = (matrix[i][j] - '0');
                    rec.xArea = rec.xLen;
                    rec.yArea = rec.yLen;
                    max = Math.max(rec.xArea * rec.yArea,max);
                }
                else if(i == 0){
                    if(matrix[i][j] != '0'){
                        rec.xLen = lists.get(i).get(j-1).xLen + 1;
                        rec.yLen = 1;
                        rec.xArea = rec.xLen;
                        rec.yArea = 1;
                        max = Math.max(rec.xArea,max);
                    }

                }else if(j == 0){
                    if(matrix[i][j] != '0'){
                        rec.xLen = 1;
                        rec.yLen = lists.get(i - 1).get(j).yLen + 1;
                        rec.xArea = 1;
                        rec.yArea = rec.yLen;
                        max = Math.max(rec.yArea,max);
                    }
                }
                else if(matrix[i][j] != '0'){
                    rec.xArea= Math.min(lists.get(i).get(j-1).xLen,lists.get(i-1).get(j-1).xArea) + 1;
                    rec.yArea = Math.min(lists.get(i-1).get(j).yLen,lists.get(i-1).get(j-1).yArea) + 1;
                    rec.xLen = lists.get(i).get(j-1).xLen + 1;
                    rec.yLen = lists.get(i-1).get(j).yLen + 1;
                    max = Math.max(rec.xArea * rec.yArea,max);
                    max = Math.max(max,rec.xLen);
                    max = Math.max(max,rec.yLen);
                }

            }
        }
        return max;
    }
    private static class Rectangular{
        public int xLen;
        public int yLen;
        public int xArea;
        public int yArea;
        public Rectangular(int xLen,int yLen,int xArea,int yArea){
            this.xLen = xLen;
            this.yLen = yLen;
            this.xArea = xArea;
            this.yArea = yArea;
        }
    }
    private List<List<Rectangular>> initial(int row,int col){
        List<List<Rectangular>> lists = new ArrayList<>(row);
        for(int i = 0;i < row;i ++){
            List<Rectangular> array = new ArrayList<>(col);
            for(int j = 0;j < col;j ++){
                array.add(new Rectangular(0,0,0,0));
            }
            lists.add(array);
        }
        return lists;
    }
}
