package list;

import junit.framework.TestCase;
import org.junit.Assert;

public class SwapPairsTest extends TestCase {

    private final SwapPairs24 swap = new SwapPairs24();

    public void test1() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 2, 3, 4});
        Assert.assertArrayEquals(CommonUtil.convertListNodeToArr(swap.swapPairs(head)), new int[]{2, 1, 4, 3});
    }

    public void test2() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 2, 3});
        Assert.assertArrayEquals(CommonUtil.convertListNodeToArr(swap.swapPairs(head)), new int[]{2, 1, 3});
    }

    public void test3() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{});
        Assert.assertArrayEquals(CommonUtil.convertListNodeToArr(swap.swapPairs(head)), new int[]{});
    }

    public void test4(){
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1});
        Assert.assertArrayEquals(CommonUtil.convertListNodeToArr(swap.swapPairs(head)), new int[]{1});
    }
}
