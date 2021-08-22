package list;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/25
 */
public class IsPalindrome234Test extends TestCase {
    private final IsPalindrome234 palindrome = new IsPalindrome234();

    public void test1() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 2});
        boolean result = palindrome.isPalindrome(head);
        Assert.assertFalse(result);
    }

    public void test2() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 2, 1});
        boolean result = palindrome.isPalindrome(head);
        Assert.assertTrue(result);
    }

    public void test3() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1});
        boolean result = palindrome.isPalindrome(head);
        Assert.assertTrue(result);
    }


    public void test5() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 2, 1, 2, 1});
        boolean result = palindrome.isPalindrome(head);
        Assert.assertTrue(result);
    }

    public void test6() {
        ListNode head = CommonUtil.convertArrToListNode(new int[]{1, 2, 1, 1, 1});
        boolean result = palindrome.isPalindrome(head);
        Assert.assertFalse(result);
    }
}
