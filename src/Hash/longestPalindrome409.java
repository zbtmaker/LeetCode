package Hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\1\29 0029.
 */
public class longestPalindrome409 {
    @Test
    public void test(){
        int len = new longestPalindrome409().longestPalindrome("aaa");
        System.out.println(len);
    }
    public int longestPalindrome(String s) {
        int len = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() % 2 == 1){
                len += entry.getValue()-1;
            }else{
                len += entry.getValue();
            }
        }
        if(len < s.length()){
            len ++;
        }
        return len;
    }
}
