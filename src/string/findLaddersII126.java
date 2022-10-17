package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\22 0022.
 */
public class FindLaddersII126 {
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        Collections.sort(wordList);
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
       // wordList.add("cog");
        List<List<String>> lists = new FindLaddersII126().findLadders(beginWord,endWord,wordList);
        for(List<String> list : lists){
            System.out.println(list);
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        boolean[] flag = new boolean[wordList.size()];

        LinkedList<String> list = new LinkedList<>();
        list.add(beginWord);

        List<List<String>> result = recurFindLadders(wordList,flag,endWord,list);


        if(!result.isEmpty()){
            for(List<String> array : result){
                array.add(0,beginWord);
            }
        }

        return result;
    }
    private List<List<String>> recurFindLadders(List<String> wordList,boolean[] flag,String endWord,
                                                  List<String> list){
        if(list.size() == 0){
            return null;
        }
        List<List<String>> result = new LinkedList<>();
        List<String> nextList = new LinkedList<>();
        for(int i = 0;i<list.size();i++){
            String str0 = list.get(i);
            for(int j = 0;j<wordList.size();j++){
                String str1 = wordList.get(j);
                if(!flag[j] && str0.equals(str1)){
                    flag[j] = true;
                }else if(!flag[j] && isLadder(str0,str1)){
                    if(str1.equals(endWord)){
                        List<String> stringList = new LinkedList<>();
                        stringList.add(str1);
                        result.add(stringList);
                        return result;
                    }else{
                        flag[j] = true;
                        nextList.add(str1);
                    }
                }
            }
        }
        List<List<String>> arrays = recurFindLadders(wordList,flag,endWord,nextList);

        for(String s : nextList){
            for(List<String> array : arrays){
                String str1 = array.get(0);
                if(isLadder(s,str1)){
                    List<String> tmpList = new LinkedList<>(array);
                    tmpList.add(0,s);
                    result.add(tmpList);
                }
            }
        }
        return result;
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
