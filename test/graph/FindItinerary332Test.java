package graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/03/06
 */
public class FindItinerary332Test {

    private FindItinerary332 find = new FindItinerary332();

    @Test
    public void test1() {
        List<List<String>> tickets = new ArrayList<>();
        List<String> t1 = new ArrayList<>();
        t1.add("MUC");
        t1.add("LHR");
        tickets.add(t1);

        List<String> t2 = new ArrayList<>();
        t2.add("JFK");
        t2.add("MUC");
        tickets.add(t2);

        List<String> t3 = new ArrayList<>();
        t3.add("SFO");
        t3.add("SJC");
        tickets.add(t3);

        List<String> t4 = new ArrayList<>();
        t4.add("LHR");
        t4.add("SFO");
        tickets.add(t4);

        List<String> path = find.findItinerary(tickets);
        Assert.assertArrayEquals(path.toArray(new String[0]), new String[]{"JFK", "MUC", "LHR", "SFO", "SJC"});
    }

    @Test
    public void test3() {
        List<List<String>> tickets = new ArrayList<>();
        List<String> t1 = new ArrayList<>();
        t1.add("JFK");
        t1.add("SFO");
        tickets.add(t1);

        List<String> t2 = new ArrayList<>();
        t2.add("JFK");
        t2.add("ATL");
        tickets.add(t2);

        List<String> t3 = new ArrayList<>();
        t3.add("SFO");
        t3.add("ATL");
        tickets.add(t3);

        List<String> t4 = new ArrayList<>();
        t4.add("ATL");
        t4.add("JFK");
        tickets.add(t4);

        List<String> t5 = new ArrayList<>();
        t5.add("ATL");
        t5.add("SFO");
        tickets.add(t5);
        List<String> path = find.findItinerary(tickets);
        Assert.assertArrayEquals(path.toArray(new String[0]), new String[]{"JFK", "ATL", "JFK", "SFO", "ATL", "SFO"});
    }

    /**
     * JFK->{KUL,NRT}
     * NRT->{JFK}
     */
    @Test
    public void test4() {
        List<List<String>> tickets = new ArrayList<>();
        List<String> t1 = new ArrayList<>();
        t1.add("JFK");
        t1.add("KUL");
        tickets.add(t1);

        List<String> t2 = new ArrayList<>();
        t2.add("JFK");
        t2.add("NRT");
        tickets.add(t2);

        List<String> t3 = new ArrayList<>();
        t3.add("NRT");
        t3.add("JFK");
        tickets.add(t3);

        List<String> path = find.findItinerary(tickets);
        Assert.assertArrayEquals(path.toArray(new String[0]), new String[]{"JFK", "NRT", "JFK", "KUL"});
    }

    @Test
    public void test5() {
        List<List<String>> tickets = new ArrayList<>();
        List<String> t1 = new ArrayList<>();
        t1.add("EZE");
        t1.add("AXA");
        tickets.add(t1);

        List<String> t2 = new ArrayList<>();
        t2.add("TIA");
        t2.add("ANU");
        tickets.add(t2);

        List<String> t3 = new ArrayList<>();
        t3.add("ANU");
        t3.add("JFK");
        tickets.add(t3);

        List<String> t5 = new ArrayList<>();
        t5.add("JFK");
        t5.add("ANU");
        tickets.add(t5);

        List<String> t6 = new ArrayList<>();
        t6.add("ANU");
        t6.add("EZE");
        tickets.add(t6);

        List<String> t7 = new ArrayList<>();
        t7.add("TIA");
        t7.add("ANU");
        tickets.add(t7);

        List<String> t8 = new ArrayList<>();
        t8.add("AXA");
        t8.add("TIA");
        tickets.add(t8);

        List<String> t9 = new ArrayList<>();
        t9.add("TIA");
        t9.add("JFK");
        tickets.add(t9);

        List<String> t10 = new ArrayList<>();
        t10.add("ANU");
        t10.add("TIA");
        tickets.add(t10);

        List<String> t11 = new ArrayList<>();
        t11.add("JFK");
        t11.add("TIA");
        tickets.add(t11);

        List<String> path = find.findItinerary(tickets);
        Assert.assertArrayEquals(path.toArray(new String[0]), new String[]{"JFK", "ANU", "EZE", "AXA", "TIA", "ANU", "JFK", "TIA", "ANU", "TIA", "JFK"});
    }
}
