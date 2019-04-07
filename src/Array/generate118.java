package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019\1\10 0010.
 */
public class generate118 {
    public static void main(String[] args){
        int numRows = 5;
        List<List<Integer>> list  = generate(5);
        for(int i = 0;i<numRows;i++){
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }


    }
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> lists = new ArrayList<List<Integer>>(numRows);

        ArrayList<Integer> arr0 = new ArrayList<Integer>(1);
        arr0.add(1);
        lists.add(arr0);

        for(int i = 1;i<numRows;i++){
            ArrayList<Integer> arr = new ArrayList<Integer>(i+1);
            for(int j = 0;j<i+1;j++){
                if(j == 0 || j == i){
                    arr.add(1);
                }else{
                    arr.add(lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
                }
            }
            lists.add(arr);
        }
        return lists;
    }

}
