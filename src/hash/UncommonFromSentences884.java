package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\1\31 0031.
 */
public class UncommonFromSentences884 {

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
