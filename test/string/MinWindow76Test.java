package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/01/31
 */
public class MinWindow76Test {
   private MinWindow76 window = new MinWindow76();

   @Test
    public void test1() {
       String minStr = window.minWindow("ADOBECODEBANC","ABC");
       Assert.assertEquals(minStr, "BANC");
   }

   @Test
   public void test2() {
       String minStr = window.minWindow("aa","aa");
       Assert.assertEquals(minStr, "aa");
   }

   @Test
   public void test3() {
       String minStr = window.minWindow("aab","aab");
       Assert.assertEquals(minStr, "aab");
   }
   @Test
   public void testAnyMatch() {
       List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
       boolean flag = list.stream().anyMatch(i -> i < 0);
       Assert.assertFalse(flag);
   }
}
