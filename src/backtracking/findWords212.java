package backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\3 0003.
 */
public class findWords212 {
    @Test
    public void test(){
        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},
                {'i','h','k','r'},{'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};
        List<String> list = findWords(board,words);
        for(String s: list){
            System.out.println(s);
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<String>();
        for(int i = 0;i<words.length;i++){
            if(exist(board,words[i])){
                list.add(words[i]);
            }
        }
        return list;
    }
    private boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(exist(board,word,visited, i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean exist(char[][] board,String word,int[][] visited,
                          int i,int j,int index) {
        if(index  == word.length()){
            return true;
        }
        if(i > -1 && i < board.length &&
                j > -1 && j < board[0].length){
            if(visited[i][j] == 0 && board[i][j] == word.charAt(index)){
                visited[i][j] = 1;
                if(exist(board,word,visited, i - 1,j,index + 1)){
                    return true;
                }
                if(exist(board,word,visited, i + 1,j,index + 1)){
                    return true;
                }
                if(exist(board,word,visited, i,j - 1,index + 1)){
                    return true;
                }
                if(exist(board,word,visited, i,j + 1,index + 1)){
                    return true;
                }
                visited[i][j] = 0;
            }
        }
        return false;
    }
}
