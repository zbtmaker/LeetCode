package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\3 0003.
 */
public class solveNQueens51 {
    public static void main(String[] args){
        List<List<String>> lists = new solveNQueens51().solveNQueens(5);
        for(List<String> list : lists){
            System.out.println(list);
        }
    }

    /**
     * 实现八皇后，这里的方案主要是实现某一种结果，下面我们实现所有的结果
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new LinkedList<>();
        if(n<=0){
            return lists;
        }
        char[][] chs = initialChs(n);
        /*recurSolveQueens(chs,0);
        fillList(lists,chs);*/
        recurSolveQueensII(chs,0,lists);
        return lists;
    }

    private boolean recurSolveQueens(char[][] chs,int curRow){
        if(curRow == chs.length){
            return true;
        }
        for(int i = 0;i<chs[curRow].length;i++){
            chs[curRow][i] = 'Q';
            if(isValid(chs,curRow,i) && recurSolveQueens(chs,curRow + 1)){
                return true;
            }
            chs[curRow][i] = '.';
        }
        return false;
    }

    /**
     * 这是进阶版，可以得到所有的解决方案
     * @param chs
     * @param curRow
     * @param lists
     */
    private void recurSolveQueensII(char[][] chs,int curRow,List<List<String>> lists){
        if(curRow == chs.length){
            fillList(lists,chs);
            return;
        }
        for(int i = 0;i<chs[curRow].length;i++){
            chs[curRow][i] = 'Q';
            if(isValid(chs,curRow,i)){
                recurSolveQueensII(chs,curRow + 1,lists);
            }
            chs[curRow][i] = '.';
        }

    }
    private boolean isValid(char[][] chs,int curRow,int curCol){
        //判断左上角是否有效
        int tmpRow = curRow-1;
        int tmpCol = curCol-1;
        while(tmpRow > -1 && tmpCol>-1){
            if(chs[tmpRow][tmpCol] == 'Q'){
                return false;
            }
            tmpRow --;
            tmpCol --;
        }
        //判断右上角是否有效
        tmpRow = curRow-1;
        tmpCol = curCol+1;
        while(tmpRow > -1 && tmpCol<chs[curRow].length){
            if(chs[tmpRow][tmpCol] == 'Q'){
                return false;
            }
            tmpRow --;
            tmpCol ++;
        }
        //判断同一列是否有效
        tmpRow = curRow - 1;
        while(tmpRow > -1){
            if(chs[tmpRow][curCol] == 'Q'){
                return false;
            }
            tmpRow --;
        }
        return true;
    }

    private void fillList(List<List<String>> lists,char[][] chs){
        List<String> list = new LinkedList<>();
        for(int i = 0;i<chs.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j =0;j< chs[0].length;j++){
                sb.append(chs[i][j]);
            }
            list.add(sb.toString());
        }
        lists.add(list);
    }

    private char[][] initialChs(int n){
        char[][] chs = new char[n][n];
        for(int i = 0;i<chs.length;i++){
            Arrays.fill(chs[i],'.');
        }
        return chs;
    }
}
