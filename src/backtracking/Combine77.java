package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019\1\22 0022.
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combine77 {
    public static void main(String[] args){
        int n = 4;
        int k = 3;
        combine(n,k);
    }
    public static List<List<Integer>> combine(int n,int k){
        int count = 0;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 1;i<=n-k+1;i++){
            ArrayList<Integer> array = new ArrayList<Integer>();
            array.add(i);
            ++ count;
            combine(n, k, i+1, count, list,array);
            -- count;
        }
        return list;
    }
    public static void combine(int n,int k,int index,int count,
                               List<List<Integer>> list,List<Integer> array){
        if(count==k){
            list.add(new ArrayList<Integer>(array));
            System.out.println(Arrays.toString(array.toArray()));
            return;
        }else{
            for(int j = index;j<=n;j++){
                array.add(j);
                count ++;
                combine(n, k, j+1, count, list,array);
                array.remove(array.size()-1);
                count --;
            }
        }
    }
}
