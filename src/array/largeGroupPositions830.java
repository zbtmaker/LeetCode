package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019\1\18 0018.
 */
public class largeGroupPositions830 {
    public static void main(String[] args){
        String S = "abbbaaa";
        for(List list:largeGroupPositions(S)){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
    public static List<List<Integer>> largeGroupPositions(String S){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        ArrayList<Integer> arr = null;
        char[] ch = S.toCharArray();
        int count = 1;
        int start = 0;
        int i = 1;
        for(;i<ch.length;i++){
            if(ch[i] == ch[i-1]){
                count ++;
            }else{
                if(count>=3){
                    arr = new ArrayList<Integer>();
                    arr.add(start);
                    arr.add(i-1);
                    list.add(arr);
                }
                count = 1;
                start = i;
            }
        }
        if(count>=3){
            arr = new ArrayList<Integer>();
            arr.add(start);
            arr.add(i-1);
            list.add(arr);
        }
        return list;
    }
}
