package list;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author baitao zou
 * date 2020/05/31
 */
public class MyLinkedList707Test extends TestCase {

    public void test1() {
        MyLinkedList707 list = new MyLinkedList707();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        Assert.assertEquals(list.get(1), 2);
        list.deleteAtIndex(1);
        Assert.assertEquals(list.get(1), 3);
    }

    public void test2() {
        MyLinkedList707 list = new MyLinkedList707();
        list.addAtHead(1);
        list.deleteAtIndex(0);
    }

    public void test3() {
        MyLinkedList707 list = new MyLinkedList707();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3, 0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        Assert.assertEquals(list.get(4), 4);
        list.addAtHead(4);
        list.addAtIndex(5, 0);
        list.addAtHead(6);
    }

    public void test4() {
        MyLinkedList707 list = new MyLinkedList707();
        list.addAtIndex(0,10);
        list.addAtIndex(0,20);
        list.addAtIndex(1,30);
        Assert.assertEquals(list.get(0),20);
    }
}
