package graph;

import java.util.*;

/**
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
 * <p>
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 *
 * @author baitao zou
 * date 2020/03/06
 */
public class FindItinerary332 {

    /**
     * the start airport
     */
    private static final String FROM = "JFK";

    /**
     * To solve this problem, we should understand the what condition to terminate the dfs.
     * It must be the size of the final path equals the number tickets plus one.(path.size == tickets.size + 1)
     *
     * @param tickets
     * @return
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> path = new LinkedList<>();
        path.add(FROM);
        Map<String, List<String>> adj = constructAdj(tickets);
        Map<String, Set<Integer>> record = new HashMap<>();
        dfs(FROM, adj, record, path, tickets.size() + 1);
        return path;
    }

    /**
     * construct a adjacent list
     *
     * @param tickets
     * @return
     */
    private Map<String, List<String>> constructAdj(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0) {
            return new HashMap<>();
        }
        Map<String, List<String>> adj = new HashMap<>();
        List<String> list;
        String from;
        for (List<String> edge : tickets) {
            from = edge.get(0);
            list = (list = adj.get(from)) == null ? new LinkedList<>() : list;
            list.add(edge.get(1));
            adj.put(from, list);
        }
        return adj;
    }


    /**
     * the difficult of this problem is how to record the edge has visited in the adjacent list of each edge.
     *
     * @param from   the start place
     * @param adj    the adjacent collection which contains the adjacent list of each vertex
     * @param record
     * @param path   record the  path
     * @param len    the number of tickets.
     * @return true - means a correct path which has traverse all tickets | false - not
     */
    private boolean dfs(String from, Map<String, List<String>> adj, Map<String, Set<Integer>> record, LinkedList<String> path, int len) {
        if (path.size() == len) {
            return true;
        }
        List<String> adjList = adj.get(from);
        if (adjList == null) {
            return false;
        }
        Set<Integer> set = record.get(from);
        if (set == null) {

            set = new HashSet<>();
            record.put(from, set);
            adjList.sort(String::compareTo);
        }
        for (int i = 0; i < adjList.size(); i++) {
            if (set.contains(i)) {
                continue;
            }
            set.add(i);
            String edge = adjList.get(i);
            path.add(edge);
            if (dfs(edge, adj, record, path, len)) {
                return true;
            }
            set.remove(i);
            path.removeLast();
        }
        return false;
    }
}
