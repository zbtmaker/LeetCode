package graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/03/10
 */
public class CanVisitAllRooms841Test {

    private CanVisitAllRooms841 visit = new CanVisitAllRooms841();

    @Test
    public void test1() {
        List<List<Integer>> rooms = new LinkedList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new ArrayList<>());
        boolean flag = visit.canVisitAllRooms(rooms);
        Assert.assertTrue(flag);
    }

    @Test
    public void test2() {
        List<List<Integer>> rooms = new LinkedList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));
        boolean flag = visit.canVisitAllRooms(rooms);
        Assert.assertFalse(flag);
    }
}
