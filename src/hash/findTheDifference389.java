package hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\1\29 0029.
 */
public class findTheDifference389 {
    @Test
    public void test(){
        char ch = new findTheDifference389().findTheDifference("ab","abc");
        System.out.println(ch);
    }
    public char findTheDifference(String s,String t){
        char diff = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }

        }
        for(int j = 0;j<t.length();j++){
            if(!map.containsKey(t.charAt(j))){
               diff = t.charAt(j);
                break;
            }else{
                map.put(t.charAt(j),map.get(t.charAt(j))+1);
            }
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() % 2 == 1){
                diff = entry.getKey();
                break;
            }
        }
        return diff;
    }
}
