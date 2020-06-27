package design;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class LFUCache460Test extends TestCase {

   /* public void test() {
        LinkedHashMap<Integer, Integer> lruMap = new LinkedHashMap<>();
        for(int i = 0;i<100;i++){
            lruMap.put(i,i);
        }

        for(Iterator<Map.Entry<Integer,Integer>> iterator = lruMap.entrySet().iterator();iterator.hasNext();){
            Map.Entry<Integer,Integer> entry = iterator.next();
            System.out.println("key = " + entry.getKey());
            System.out.println("val = " + entry.getValue()) ;
            break;
        }
    }*/

    public void test1() {
        LFUCache460 lfu = new LFUCache460(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        Assert.assertEquals(lfu.get(1),1);
        lfu.put(3,3);
        Assert.assertEquals(lfu.get(2),-1);
        Assert.assertEquals(lfu.get(3),3);
        lfu.put(4,4);
        Assert.assertEquals(lfu.get(1),-1);
        Assert.assertEquals(lfu.get(4),4);
    }

    public void test2(){
        LFUCache460 lfu = new LFUCache460(2);
        lfu.put(3,1);
        lfu.put(2,1);
        lfu.put(2,2);
        lfu.put(4,4);
        Assert.assertEquals(lfu.get(2),2);
    }

    public void test3(){
        LFUCache460 lfu = new LFUCache460(0);
        lfu.put(0,0);
        lfu.get(0);
    }
}
