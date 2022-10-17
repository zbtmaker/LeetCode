package string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\18 0018.
 */
public class FindLadders126 {
    public static void main(String[] args){
        String beginWord = "red";
        String endWord = "tax";
        List<String> wordList = new ArrayList<>();
        wordList.add("ted");
        wordList.add("tex");
        wordList.add("red");
        wordList.add("tax");
        wordList.add("tad");
        wordList.add("den");
        wordList.add("rex");
        wordList.add("pee");
        List<List<String>> lists = new FindLadders126().findLadders(beginWord,endWord,wordList);
        for(List<String> list : lists){
            System.out.println(list);
        }
    }

    /**
     * 毫无例外的超出了时间，我之前使用了BFS的方式实现了这个问题，但是对于BFS应该如何有效地记录
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        boolean[] flag = new boolean[wordList.size()];
        List<List<String>> results = new LinkedList<>();
        LinkedList<String> list = new LinkedList<>();
        list.add(beginWord);
        int[] min = new int[]{Integer.MAX_VALUE};
        recurFindLadders(wordList,flag,beginWord,endWord,list,results,min);
        return results;
    }
    private void recurFindLadders(List<String> wordList,boolean[] flag,String word,String endWord,LinkedList<String> list,List<List<String>> results,int[] min){
        if(word.equals(endWord)){
            if(list.size() == min[0]){
                results.add(new LinkedList<>(list));
            }else if(list.size() < min[0]){
                min[0] = list.size();
                results.clear();
                results.add(new LinkedList<>(list));
            }
            return;
        }
        for(int i = 0;i < wordList.size();i ++){
            String str = wordList.get(i);
            if(!flag[i] && isLadder(word,str)){
                flag[i] = true;
                list.add(str);
                recurFindLadders( wordList,flag,str, endWord,list,results,min);
                flag[i] = false;
                list.removeLast();
            }
        }

    }
    private boolean isLadder(String str1,String str2){
        if(str1.equals(str2)){
            return false;
        }
        int len = Math.min(str1.length(),str2.length());
        int dist = 0;
        for(int i = 0;i < len;i ++){
            if(str1.charAt(i) != str2.charAt(i)){
                dist++;
            }
            if(dist > 1){
                return false;
            }
        }
        return true;
    }


}
