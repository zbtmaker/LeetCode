package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\1\11 0011.
 */
public class numJewelsInStones771 {
    public static  void main (String[] args){
        int  i = 1;
        System.out.println(new numJewelsInStones771().numJewelsInStones("a","AAAbbbb"));
    }
    public int numJewelsInStones(String J,String S){
        int count = 0;
        Map<Character,Character> map = new HashMap<Character,Character>();
        for(int i = 0;i<J.length();i++){
            map.put(J.charAt(i),J.charAt(i));
        }
        for(int j = 0;j<S.length();j++){
            if(map.containsKey(S.charAt(j))){
                count ++;
            }
        }
        return count;
    }
}
