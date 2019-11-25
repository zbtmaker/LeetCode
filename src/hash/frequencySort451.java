package hash;

import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2019\1\29 0029.
 */
public class frequencySort451 {
    @Test
    public void test(){
        String s = new frequencySort451().frequencySort("Aabb");
        System.out.println(s);

    }
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        ArrayList<Node> arrayList = new ArrayList<>(map.size());

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            arrayList.add(new Node(entry.getValue(),entry.getKey()));
        }
        Collections.sort(arrayList,new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.key<o2.key){
                    return 1;
                }else if(o1.key == o2.key){
                    return 0;
                }else{
                    return -1;
                }
            }
        });
        StringBuilder sb = new StringBuilder(s.length());
        for(Node node : arrayList){
            for(int i = 0;i<node.key;i++){
                sb.append(node.val);
            }
        }
        return sb.toString();

    }
    class Node {
        private int key;
        private char val;
        public Node(int key,char val){
            this.key = key;
            this.val = val;
        }
    }

}
