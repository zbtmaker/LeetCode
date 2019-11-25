package hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\1\31 0031.
 */
public class lengthOfLongestSubstring3 {
    @Test
    public void test(){

        int max = new lengthOfLongestSubstring3().lengthOfLongestSubstring("aab");
        System.out.println(max);
        /*Map<Character,Integer> map = new HashMap<>();
        string s = "a b c";
        for(int i = 0;i<s.length();i++){
           map.put(s.charAt(i),i);
        }*/
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<1){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        int start = 0 ;
        int max = 1;
        map.put(s.charAt(0),0);
        int i = 1;
        for(;i<s.length();i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start){
                max = i - start > max ? i - start : max;
                start = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i),i);
            }else{

                map.put(s.charAt(i),i);
            }
        }

        return max = i - start > max ? i - start : max;
    }
}
