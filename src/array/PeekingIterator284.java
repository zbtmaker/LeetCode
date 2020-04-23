package array;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
 * 链接：https://leetcode-cn.com/problems/peeking-iterator
 *
 * @author baitao zou
 * date 2020/04/11
 */
public class PeekingIterator284 implements Iterator<Integer> {


    private ArrayList list;
    private int index;

    /**
     * 借助现有的List集合实现顶端迭代器，使用一个O(N)的时间复杂度和O(N)的空间复杂度来实现，
     * @param iterator
     */
    public PeekingIterator284(Iterator<Integer> iterator) {
        index = 0;
        list = new ArrayList();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return (Integer) list.get(index);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (index >= list.size()) {
            throw new IndexOutOfBoundsException("超出范围");
        }
        index++;
        return (Integer) list.get(index - 1);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}
