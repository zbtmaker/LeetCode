package hash;

import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2019\2\1 0001.
 */
public class findRepeatedDnaSequences187 {
    @Test
    public void test(){

        String s ="AAAAAAAAAAAAAAA";
        List<String> lists= new findRepeatedDnaSequences187().findRepeatedDnaSequences(s);
        System.out.println(Arrays.toString(lists.toArray()));
    }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> arrayList = new ArrayList<>();
        Map<String,Integer> map = new HashMap<String,Integer>();
        int i = 0;
        int j = 9;
        while(j<s.length()){
            if(map.get(s.substring(i,j+1)) == null){
                map.put(s.substring(i,j+1),1);
            }else if(map.get(s.substring(i,j+1)) == 1){
                arrayList.add(s.substring(i,j+1));
                map.put(s.substring(i,j+1),map.get(s.substring(i,j+1)) + 1);
            }
            i++;
            j++;
        }
        return arrayList;

    }
}
