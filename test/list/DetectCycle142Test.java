package list;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author baitao zou
 * date 2020/11/28
 */
public class DetectCycle142Test extends TestCase {

    private final DetectCycle142 detectCycle = new DetectCycle142();

    public void test1() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{3, 2, 0, -4});
        ListNode cycle = detectCycle.detectCycle(head);
    }

}
