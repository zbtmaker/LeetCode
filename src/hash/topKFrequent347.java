package hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019\1\29 0029.
 */
public class topKFrequent347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]));
            }else{
                map.put(nums[i],1);
            }
        }
        Node[] nodes = new Node[map.size()];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            nodes[i] = new Node(entry.getValue(),entry.getKey());
        }

        return null;
    }
    class Node{
        private int key;
        private int val;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
}
