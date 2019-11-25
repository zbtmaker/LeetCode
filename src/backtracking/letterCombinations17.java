package backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\2 0002.
 */
public class letterCombinations17 {
    @Test
    public void test(){
        String digits = "23";
        new letterCombinations17().letterCombinations(digits);
    }
    public List<String> letterCombinations(String digits){
        if(digits == null || digits.length() <1){
            return null;
        }
        List<String> list = new ArrayList<String>();
        String[] strings = new String[digits.length()];
        for(int i = 0;i<digits.length();i++){
            strings[i] = charTowords(digits.charAt(i)-'0');
        }
        for(int i = 0;i<strings[0].length();i++){
            StringBuilder sb = new StringBuilder();
            sb.append(strings[0].charAt(i));
            letterCombinations(strings,list,sb,1);
        }
        return list;
    }
    private void letterCombinations(String[] strings,List<String> list,
                                    StringBuilder sb,int index){
        if(index == strings.length){
            System.out.println(sb.toString());
            list.add(sb.toString());
            return;
        }
        for(int i = 0;i<strings[index].length();i++){
            sb.append(strings[index].charAt(i));
            letterCombinations(strings,list,sb,index+1);
            sb.deleteCharAt(index);
        }
    }
    public String charTowords(int i){
        String s;
        switch(i){
            case 2: s = "abc";break;
            case 3: s = "def";break;
            case 4: s = "ghi";break;
            case 5: s = "jkl";break;
            case 6: s = "mno";break;
            case 7: s = "pqrs";break;
            case 8: s = "tuv";break;
            case 9: s = "wxyz";break;
            default: return null;
        }
        return s;
    }
}
