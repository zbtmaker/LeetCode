package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019\1\10 0010.
 */
public class getRow119 {
    public static void main(String[] args){
        int rowIndex = 3;
        List<Integer> list = getRow(rowIndex);
        System.out.println(Arrays.toString(list.toArray()));
    }
    public static  List<Integer> getRow(int rowIndex){
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = null;
        if(rowIndex == 0){
            return list1;
        }
        list1.add(1);
        for(int i = 1;i<rowIndex+1;i++){
            list2 = new ArrayList<Integer>();
            for(int j = 0;j<i+1;j++){
                if (j == 0 || j == i) {
                    list2.add(1);
                }else{
                    list2.add(list1.get(j)+list1.get(j-1));
                }
            }
            list1 = list2;
        }
        return list2;
    }
}
