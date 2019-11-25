package hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\1\29 0029.
 */
public class findRestaurant599 {
    @Test
    public void test(){
        String[] s1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] s2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] strings = new findRestaurant599().findRestaurant(s1,s2);
        System.out.println(Arrays.toString(strings));
    }
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        put(map,list1);
        int min = Integer.MAX_VALUE;
        int[] nums = new int[list2.length];
        Arrays.fill(nums,Integer.MAX_VALUE);
        for(int i = 0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                nums[i] = map.get(list2[i]) + i;
                min = min > nums[i] ? nums[i] : min;
            }
        }
        ArrayList<String> arrayList = new ArrayList();
        for(int i = 0;i<list2.length;i++){
            if(nums[i] == min && min != Integer.MAX_VALUE){
                arrayList.add(list2[i]);
            }
        }
        String[] strings = new String[arrayList.size()];
        for(int i = 0;i<strings.length;i++){
            strings[i] = arrayList.get(i);
        }
        return strings;
    }
    private void put(Map<String,Integer> map,String[] lists){
        for(int i = 0;i<lists.length;i++){
            if(map.containsKey(lists[i])){
                continue;
            }else{
                map.put(lists[i],i);
            }
        }
    }
}
