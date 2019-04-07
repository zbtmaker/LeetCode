package String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2019\3\18 0018.
 */
public class ladderLength127 {
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        //wordList.add("cog");
        int minLen = new ladderLength127().ladderLengthIII(beginWord,endWord,wordList);
        System.out.println(minLen);
    }

    /**
     * 发现用回溯的方法得不到最终的结果，因此我们想到使用图算法中的BFS算法，这个其实可以转换成一个图，从一个图的起始节点出发，
     * 看是否能够到达最终的节点。因此我们使用BFS算法，可以在至多O(N)的算法中得到最终的结果
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] flag = new boolean[wordList.size()];
        List<List<String>> results = new LinkedList<>();
        LinkedList<String> list = new LinkedList<>();
        list.add(beginWord);
        int[] min = new int[]{Integer.MAX_VALUE};
        recurFindLadders(wordList,flag,beginWord,endWord,list,results,min);
        return min[0] == Integer.MAX_VALUE ? 0 : min[0];
    }
    private void recurFindLadders(List<String> wordList,boolean[] flag,String word,String endWord,LinkedList<String> list,List<List<String>> results,int[] min){
        if(word.equals(endWord)){
            if(list.size() < min[0]){
                min[0] = list.size();
            }
            return;
        }
        for(int i = 0;i < wordList.size();i ++){
            String str = wordList.get(i);
            if(!flag[i] && isLadder(word,str)){
                flag[i] = true;
                list.add(str);
                recurFindLadders( wordList,flag,str,endWord,list,results,min);
                flag[i] = false;
                list.removeLast();
            }
        }

    }
    private boolean isLadder(String str1,String str2){
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

    /**
     * 这里我采用的是BFS的方式，其实我当时在医院的时候有想到这种方式，但是我还是采取了最笨的方式--回溯思想来枚举
     * 所有可能性，也就必然会造就
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLengthII(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> list = new LinkedList<>();
        list.add(beginWord);
        int count = 1;
        int depth = 1;
        while(list.size() != 0){

            int tmpCount = 0;
            List<String> array = new ArrayList<>(wordList);
            for(int i = 0;i<count;i++){
                String str0 = list.removeLast();

                for(int j = 0;j < wordList.size();j++){
                    String str1 = wordList.get(j);
                    if(isLadder(str0,str1)){
                        if(str1.equals(endWord)){
                            return ++depth;
                        }else{
                            list.addFirst(str1);
                            array.remove(str1);
                            tmpCount ++;
                        }
                    }
                }
            }
            depth ++;
            count = tmpCount;
            wordList = array;
        }
        return 0;

    }

    public int ladderLengthIII(String beginWord, String endWord, List<String> wordList) {

        LinkedList<String> list = new LinkedList<>();
        list.add(beginWord);
        int count = 1;
        int depth = 1;
        boolean[] flag = new boolean[wordList.size()];
        while(list.size() != 0){
            int tmpCount = 0;
            for(int i = 0;i<count;i++){
                String str0 = list.removeLast();
                for(int j = 0;j < wordList.size();j++){
                    String str1 = wordList.get(j);
                    if(!flag[j] && isLadder(str0,str1)){
                        if(str1.equals(endWord)){
                            return ++depth;
                        }else{
                            list.addFirst(str1);
                            flag[j] = true;
                            tmpCount ++;
                        }
                    }
                }
            }
            depth ++;
            count = tmpCount;
        }
        return 0;

    }
}
