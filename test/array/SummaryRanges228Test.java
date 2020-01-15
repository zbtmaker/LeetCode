package array;

import org.junit.Test;

public class SummaryRanges228Test {
    private SummaryRanges228 ranges = new SummaryRanges228();

    /**
     * 测试用例：[0, 1, 2, 4, 5, 7]
     */
    @Test
    public void test1() {
        System.out.println(ranges.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }

    /**
     * 测试用例：[0, 2, 3, 4, 6, 8, 9]
     */
    @Test
    public void test2() {
        System.out.println(ranges.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }

    /**
     * 测试用例：[0, 2]
     */
    @Test
    public void test3() {
        System.out.println(ranges.summaryRanges(new int[]{0, 2}));
    }

    /**
     * 测试用例：[0, 1]
     */
    @Test
    public void test4() {
        System.out.println(ranges.summaryRanges(new int[]{0, 1}));
    }

    /**
     * 测试用例：[0]
     */
    @Test
    public void test5() {
        System.out.println(ranges.summaryRanges(new int[]{0}));
    }

}
