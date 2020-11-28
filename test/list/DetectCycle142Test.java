package list;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/11/28
 */
public class DetectCycle142Test extends TestCase {

    private DetectCycle142 detectCycle = new DetectCycle142();

    public void test1() {
        DetectCycle142.ListNode node0 = new DetectCycle142.ListNode(3);
        DetectCycle142.ListNode node1 = new DetectCycle142.ListNode(2);
        DetectCycle142.ListNode node2 = new DetectCycle142.ListNode(0);
        DetectCycle142.ListNode node3 = new DetectCycle142.ListNode(-4);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        DetectCycle142.ListNode cycle = detectCycle.detectCycle(node0);
        Assert.assertSame(node1, cycle);
    }

}
