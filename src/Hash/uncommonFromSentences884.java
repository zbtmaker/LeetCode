package Hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\1\31 0031.
 */
public class uncommonFromSentences884 {
    @Test
    public void test(){
        String s1 = "apple apple";
        String s2 = "banana";
        String[] s = new uncommonFromSentences884().uncommonFromSentences(s1,s2);
        System.out.println(Arrays.toString(s));
    }
    public String[] uncommonFromSentences(String A, String B) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        String[] s1 = A.split(" ");
        String[] s2 = B.split(" ");

        put(map,s1);
        put(map,s2);


        ArrayList<String> arrayList = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                arrayList.add(entry.getKey());
            }
        }
        String[] s = new String[arrayList.size()];
        for(int i = 0;i<arrayList.size();i++){
            s[i] = arrayList.get(i);
        }
        return s;
    }
    public void put(Map<String,Integer> map,String[] s){
        for(int i = 0;i<s.length;i++){
            if(map.containsKey(s[i])){
                map.put(s[i],map.get(s[i])+1);
            }else{
                map.put(s[i],1);
            }
        }
    }
}
