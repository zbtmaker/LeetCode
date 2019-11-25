package backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019\1\29 0029.
 */
public class combinationSumIII216 {
    @Test
    public void test(){
        List<List<Integer>> lists = new combinationSumIII216().combinationSum3(2,17);
        for(List list:lists){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int count = 0;
        int sum = 0;
        for(int i = 1;i<n-1;i++){
            if(i>9){
                break;
            }
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            arrayList.add(i);
            sum += i;
            count ++;
            combinationSum3(k,n,count,sum,i+1,lists,arrayList);
            sum = 0;
            count = 0;
        }
        return lists;
    }
    public void combinationSum3(int k,int n,int count,int sum,int index,
                                List<List<Integer>> lists,List<Integer> arrayList){
        if(sum == n && count == k){
            lists.add(new ArrayList<Integer>(arrayList));
            return;
        }else if( sum > n || count >k){
            return;
        }else{
            for(int i = index;i<=n;i++){
                if(i>9){
                    break;
                }
                sum += i;
                count ++;
                arrayList.add(i);
                combinationSum3(k,n,count,sum,i+1,lists,arrayList);
                arrayList.remove(arrayList.size()-1);
                sum -= i;
                count --;
            }
        }
    }
}
