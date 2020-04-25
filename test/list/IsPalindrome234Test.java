package list;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/04/25
 */
public class IsPalindrome234Test {
    private IsPalindrome234 palindrome = new IsPalindrome234();

    @Test
    public void test1() {
        IsPalindrome234.ListNode head = new IsPalindrome234.ListNode(1);
        head.next = new IsPalindrome234.ListNode(2);
        boolean result = palindrome.isPalindrome(head);
        Assert.assertFalse(result);
    }

    @Test
    public void test2() {
        IsPalindrome234.ListNode head = new IsPalindrome234.ListNode(1);
        IsPalindrome234.ListNode second = new IsPalindrome234.ListNode(2);
        IsPalindrome234.ListNode third = new IsPalindrome234.ListNode(1);
        head.next = second;
        second.next = third;
        boolean result = palindrome.isPalindrome(head);
        Assert.assertTrue(result);
    }

    @Test
    public void test3() {
        IsPalindrome234.ListNode head = new IsPalindrome234.ListNode(1);
        boolean result = palindrome.isPalindrome(head);
        Assert.assertTrue(result);
    }

    @Test
    public void test4() {
        IsPalindrome234.ListNode head = new IsPalindrome234.ListNode(1);
        head.next = new IsPalindrome234.ListNode(1);
        boolean result = palindrome.isPalindrome(head);
        Assert.assertTrue(result);
    }

    @Test
    public void test5() {
        IsPalindrome234.ListNode head = new IsPalindrome234.ListNode(1);
        IsPalindrome234.ListNode second = new IsPalindrome234.ListNode(2);
        IsPalindrome234.ListNode third = new IsPalindrome234.ListNode(1);
        IsPalindrome234.ListNode fourth = new IsPalindrome234.ListNode(2);
        IsPalindrome234.ListNode fifth = new IsPalindrome234.ListNode(1);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        boolean result = palindrome.isPalindrome(head);
        Assert.assertTrue(result);
    }

    @Test
    public void test6() {
        IsPalindrome234.ListNode head = new IsPalindrome234.ListNode(1);
        IsPalindrome234.ListNode second = new IsPalindrome234.ListNode(2);
        IsPalindrome234.ListNode third = new IsPalindrome234.ListNode(1);
        IsPalindrome234.ListNode fourth = new IsPalindrome234.ListNode(1);
        IsPalindrome234.ListNode fifth = new IsPalindrome234.ListNode(1);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        boolean result = palindrome.isPalindrome(head);
        Assert.assertFalse(result);
    }
}
