package String;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\8 0008.
 */
public class PalindromePartitioning131 {
    public static void main(String[] args){
        String s = "aab";
        List<List<String>> lists = new PalindromePartitioning131().partition(s);
        for(List<String> list : lists){
            System.out.println(list);
        }

    }
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new LinkedList<>();
        List<String> list = new LinkedList<>();
        if(s == null || s.length() ==0){
            return lists;
        }
        recurPartition(s,0,list,lists);
        return lists;
    }
    private void recurPartition(String s,int index,List<String> list,List<List<String>> lists){
        if(index >= s.length()){
            lists.add(new LinkedList<>(list));
            return;
        }
        list.add(s.substring(index,index+1));
        recurPartition(s,index + 1,list,lists);
        list.remove(list.size()-1);
        for(int i = index + 1;i<s.length();i++){
            String substr =  s.substring(index,i+1);
            if(isPalindrome(substr)){
                list.add(substr);
                recurPartition(s,i + 1,list,lists);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++ ;
            j-- ;
        }
        return true;
    }
}
