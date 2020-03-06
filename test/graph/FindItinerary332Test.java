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
    public void test2() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("ATL", Arrays.asList("SFO", "JFK"));

        List<String> edge = map.get("ATL");
        System.out.println("Before Sort :");
        map.get("ATL").forEach(System.out::println);
        edge.sort(String::compareTo);
        System.out.println("After Sort :");
        map.get("ATL").forEach(System.out::println);
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
}
