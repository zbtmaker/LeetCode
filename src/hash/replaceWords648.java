package hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019\1\31 0031.
 */
public class replaceWords648 {
    @Test
    public void test(){
        /*string s = "abcbd";
        System.out.println(s.substring(0,6));*/
        List<String> list = new ArrayList<String>();
        list.add("cat");
        list.add("bat");
        list.add("rat");
        String sentence = "the cattel was rattled by the battery";
        String s = new replaceWords648().replaceWords(list,sentence);
        System.out.println(s);
    }
    public String replaceWords(List<String> dict, String sentence) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 0;i<dict.size();i++){
            map.put(dict.get(i),dict.get(i).length());
        }
        String[] s = sentence.split(" ");
        StringBuilder sb = new StringBuilder((s.length << 1) -1);
        for(int i = 0;i<s.length;i++){
            for(int j = 0;j<s[i].length();j++){
                if(map.containsKey(s[i].substring(0,j+1))){
                    s[i] = s[i].substring(0,j+1);
                    break;
                }
            }
            if(i<s.length -1){
                sb.append(s[i]).append(" ");
            }else{
                sb.append(s[i]);
            }

        }


        return sb.toString();
    }
}
