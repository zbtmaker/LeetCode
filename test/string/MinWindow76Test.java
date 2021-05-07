package string;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/01/31
 */
public class MinWindow76Test extends TestCase {
    private MinWindow76 window = new MinWindow76();

    public void test1() {
        String minStr = window.minWindow("ADOBECODEBANC", "ABC");
        Assert.assertEquals(minStr, "BANC");
    }

    public void test2() {
        String minStr = window.minWindow("aa", "aa");
        Assert.assertEquals(minStr, "aa");
    }

    public void test3() {
        String minStr = window.minWindow("aab", "aab");
        Assert.assertEquals(minStr, "aab");
    }
}
