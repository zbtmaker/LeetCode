package String;

/**
 * Created by Administrator on 2019\3\10 0010.
 */
public class lengthOfLastWord58 {
    public static void main(String[] args){
        int len = new lengthOfLastWord58().lengthOfLastWord("a");
        System.out.println(len);
    }
    public int lengthOfLastWord(String s) {
        int i = s.length()-1;
        int count = 0;
        while(i>-1){
            if(s.charAt(i) == ' '){
                return count;
            }
            count ++;
            i--;
        }
        return s.length();
    }
}
