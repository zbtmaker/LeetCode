package backtracking;

/**
 * Created by Administrator on 2019\2\2 0002.
 * 回溯算法使用的还是利用多叉树的思想，从上往下，然后从下往上恢复上一层的情况，其实这个就是广度优先
 * 搜索树方式，这种方式需要有一个集合来记录每一个节点的访问情况，每个节点只允许访问一次。
 */
public class Exist79 {

    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int[][] visited,
                          int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i > -1 && i < board.length &&
                j > -1 && j < board[0].length) {
            if (visited[i][j] == 0 && board[i][j] == word.charAt(index)) {
                visited[i][j] = 1;
                if (exist(board, word, visited, i - 1, j, index + 1)) {
                    return true;
                }
                if (exist(board, word, visited, i + 1, j, index + 1)) {
                    return true;
                }
                if (exist(board, word, visited, i, j - 1, index + 1)) {
                    return true;
                }
                if (exist(board, word, visited, i, j + 1, index + 1)) {
                    return true;
                }
                visited[i][j] = 0;
            }
        }
        return false;
    }
}
