package String;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\3\29 0029.
 */
public class maxProduct318 {
    @Test
    public void test(){
        maxProduct318 maxPro = new maxProduct318();
        String[] words = new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        int max = maxPro.maxProduct(words);
        System.out.println(max);
    }
    public int maxProduct(String[] words) {
        int max = 0;
        for(int i = 0;i < words.length - 1;i++){
            Map<Character,Character> map = new HashMap<>();
            int len1 = words[i].length();
            for(int k = 0;k < len1;k ++){
                char ch = words[i].charAt(k);
                if(!map.containsKey(ch)){
                    map.put(ch,' ');
                }
            }
            for(int j = i + 1;j < words.length;j++){
                max = isomerism(map,words[j],len1,max);
            }
        }
        return max;
    }
    private int isomerism(Map<Character,Character> map,String word2,int len1,int max){
        int len2 = word2.length();
        for(int i = 0;i < len2;i ++){
            if(map.containsKey(word2.charAt(i))){
                return max;
            }
        }
        return Math.max(max,len1*len2);
    }
}
