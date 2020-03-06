package graph;

import java.util.*;

/**
 * @author baitao zou
 * date 2020/03/06
 */
public class FindItinerary332 {

    /**
     * the start airport
     */
    private static final String FROM = "JFK";

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> path = new LinkedList<>();
        Map<String, List<String>> adj = constructAdj(tickets);
        Map<String, Integer> record = new HashMap<>();
        dfs(FROM, adj, record, path);
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


    private void dfs(String from, Map<String, List<String>> adj, Map<String, Integer> record, List<String> path) {
        path.add(from);
        List<String> edge = adj.get(from);
        if (edge == null) {
            return;
        }
        Integer index = record.get(from);
        if (index == null) {
            edge.sort(String::compareTo);
            index = 0;
        }
        if (index >= edge.size()) {
            return;
        }
        record.put(from, index + 1);
        dfs(edge.get(index), adj, record, path);
    }
}
