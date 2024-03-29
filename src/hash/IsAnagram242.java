package hash;

/**
 * Created by Administrator on 2019\1\29 0029.
 */
public class IsAnagram242 {

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
