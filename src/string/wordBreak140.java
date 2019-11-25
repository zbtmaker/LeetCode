package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019\3\19 0019.
 */
public class wordBreak140 {
    public static void main(String[] args){
        String s = "catsanddog";
        List<String> list = new LinkedList<>();

        list.add("cat");

        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");

        List<String> result = new wordBreak140().wordBreak(s,list);
        System.out.println(result);
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> lists = new LinkedList<>();
        LinkedList<String> list = new LinkedList<>();
        Map<String,Integer> map = putMap(wordDict);
        recurWordBreak(s,0,wordDict,map,lists,list);
        List<String> result = new LinkedList<>();
        for(List<String> tmp : lists){
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<tmp.size();i++){
                if(i == tmp.size()-1){
                    sb.append(tmp.get(i));
                }else{
                    sb.append(tmp.get(i) + " ");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
    private void recurWordBreak(String s,int index,List<String> wordDict,Map<String,Integer> map,
                                   List<List<String>> results,LinkedList<String> list){
        if(index == s.length()){
            results.add(new LinkedList<>(list));
        }
        for(int i = index;i<s.length();i++){
            String subStr = s.substring(index,i+1);
            if(map.containsKey(subStr)){
                list.add(subStr);
                recurWordBreak(s,i+1,wordDict,map,results,list);
                list.removeLast();
            }
        }
    }
    /**
     * 将wordDict中的String放入到HashMap当中，便于查找
     * @param wordDict
     * @return
     */
    private Map<String,Integer> putMap(List<String> wordDict){
        Map<String,Integer> map = new HashMap<>();
        for(String str : wordDict){
            if(map.containsKey(str)){
                map.put(str,map.get(str) + 1);
            }else{
                map.put(str,1);
            }
        }
        return map;
    }
}
