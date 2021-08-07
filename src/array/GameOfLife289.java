package array;

/**
 * @author baitao zou
 * date 2020/04/03
 */
public class GameOfLife289 {

    public void gameOfLife(int[][] board) {

    }

    /**
     * 通过辅助数组来做这个题，时间复杂度为O(N^2),space complexity O(N^2)
     *
     * @param board 细胞板
     */
    public void gameOfLifeByAux(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(i == 0){

                }
            }
        }
    }
}
