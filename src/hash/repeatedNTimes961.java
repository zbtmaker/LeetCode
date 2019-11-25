package hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\1\29 0029.
 */
public class repeatedNTimes961 {
    @Test
    public void test(){
        System.out.println(new repeatedNTimes961().repeatedNTimes(new int[]{1,2,3,3}));
    }
    public int repeatedNTimes(int[] A) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int num = 0;
        for(int i = 0;i<A.length;i++){
            if(!map.containsKey(A[i])){
                map.put(A[i],1);
            }else if(map.get(A[i])+1 == (A.length>>1)){
                num = A[i];
                break;
            }else{
                map.put(A[i],map.get(A[i])+1);
            }
        }
        return num;
    }
}
