package hash;

import org.junit.Test;

/**
 * Created by Administrator on 2019\1\29 0029.
 */
public class isAnagram242 {

    @Test
    public void test(){
        boolean flag = new isAnagram242().isAnagram("rat","cat");
        System.out.println(flag);
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        boolean flag = true;
        int[] countS = new int[26];
        int[] countT = new int[26];
        for(int i = 0;i<s.length();i++){
            countS[s.charAt(i)-'a'] ++;
            countT[t.charAt(i)-'a'] ++;
        }
        for(int j = 0;j<26;j++){
            if(countS[j] != countT[j]){
                flag = false;
            }
        }
        return flag;
    }
}
