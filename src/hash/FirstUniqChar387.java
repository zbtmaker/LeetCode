package hash;

/**
 * Created by Administrator on 2019\1\29 0029.
 */
public class FirstUniqChar387 {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(int i = 0;i<s.length();i++){
            count[s.charAt(i)-'a'] ++;
        }
        int index = -1;
        for(int j = 0;j<s.length();j++){
            if(count[s.charAt(j)-'a'] == 1 ){
                index = j;
                break;
            }
        }
        return index;
    }
}
