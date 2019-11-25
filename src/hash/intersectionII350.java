package hash;

import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2019\1\30 0030.
 */
public class intersectionII350 {
    @Test
    public void test(){
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] intersect = new intersectionII350().intersect(nums1,nums2);
        System.out.println(Arrays.toString(intersect));
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();

        List<Integer> arrayList = new ArrayList<Integer>();

        put(map1,nums1);
        put(map2,nums2);
        for(Map.Entry<Integer,Integer> entry:map1.entrySet()){
            if(map2.containsKey(entry.getKey())){
                /*int value1 = entry.getValue();
                int value2 = map2.get(entry.getKey());
                int count = Math.min(value1,value2);*/
                int count = Math.min(entry.getValue(),map2.get(entry.getKey()));
                for(int i = 0;i<count;i++){
                    arrayList.add(entry.getKey());
                }
            }
        }
        int[] intersect = new int[arrayList.size()];
        for(int i = 0;i<arrayList.size();i++){
            intersect[i] = arrayList.get(i);
        }

        return intersect;
    }
    private void put(Map<Integer,Integer> map,int[] nums){
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
    }

}
