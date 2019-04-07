package String;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\8 0008.
 */
public class PalindromePartitioningII132 {
    public static void main(String[] args){
        String s = "aab";
        int min= new PalindromePartitioningII132().minCut(s);

        System.out.println(min);

    }

    /**
     * 使用回溯的方法会导致超出时间限制，那么这个时候可以选择的方式有动态规划
     * 以及Manacher算法+区间合并方法
     * @param s
     * @return
     */
    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        List<String> list = new LinkedList<>();
        int[] min = new int[]{s.length()-1};
        recurPartition(s,0,list,min);
        return min[0];
    }
    private void recurPartition(String s, int index, List<String> list,int[] min){
        if(index >= s.length()){
            int count = list.size()-1;
            if(count<min[0]){
                min[0] = count;
            }
            return;
        }
        list.add(s.substring(index,index+1));
        recurPartition(s,index + 1,list,min);
        list.remove(list.size()-1);
        for(int i = index + 1;i<s.length();i++){
            String substr =  s.substring(index,i+1);
            if(isPalindrome(substr)){
                list.add(substr);
                recurPartition(s,i + 1,list,min);
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
