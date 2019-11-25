package hash;

import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2019\1\29 0029.
 */
public class intersection349 {
    @Test
    public void test(){
       int[] inter =  new intersection349().intersection(new int[]{1,2,2,1},new int[]{2,2});
        System.out.println(Arrays.toString(inter));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i<nums1.length;i++){
            map.put(nums1[i],1);
        }
        int count = 0;
        for(int i = 0;i<nums2.length;i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) == 1){
                count ++;
                map.put(nums2[i],2);
            }
        }
        int[] inter= new int[count];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 2){
                inter[i] = entry.getKey();
                i++;
            }
        }
        return inter;
    }
}
