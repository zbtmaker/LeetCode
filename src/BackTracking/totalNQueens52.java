package BackTracking;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\3\4 0004.
 */
public class totalNQueens52 {
    public static void main(String[] args){
        System.out.println(new totalNQueens52().totalNQueens(5));

    }
    public int totalNQueens(int n) {
        if(n<=0){
            return 0;
        }
        char[][] chs = initialChs(n);
        int[] count = new int[]{0};
        recurSolveQueens(chs,0,count);
        return count[0];
    }

    private void recurSolveQueens(char[][] chs,int curRow,int[] count){
        if(curRow == chs.length){
            count[0] = count[0] + 1;
            return;
        }
        for(int i = 0;i<chs[curRow].length;i++){
            chs[curRow][i] = 'Q';
            if(isValid(chs,curRow,i)){
                recurSolveQueens(chs,curRow + 1,count);
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

    private char[][] initialChs(int n){
        char[][] chs = new char[n][n];
        for(int i = 0;i<chs.length;i++){
            Arrays.fill(chs[i],'.');
        }
        return chs;
    }
}
