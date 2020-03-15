package graph;


import java.util.*;

/**
 * @author baitao zou
 * date 2020/03/15
 */
public class CalcEquation399 {


    public class Edge {
        String dividend;
        double result;

        private Edge(String dividend, double result) {
            this.dividend = dividend;
            this.result = result;
        }
    }

    /**
     * @param equations 已知方程式
     * @param values    方程式结果值
     * @param queries   需要查询的方程式
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if (queries == null || queries.size() == 0) {
            return new double[0];
        }

        double[] result = new double[queries.size()];
        Map<String, List<Edge>> graph = constructUndirectedWeightedGraph(equations, values);
        int i = 0;
        for (List<String> query : queries) {
            String dividend = query.get(0);
            String divisor = query.get(1);
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                result[i] = -1;
            } else if (dividend.equals(divisor)) {
                result[i] = 1;
            } else {
                result[i] = bfsFindPath(divisor, dividend, graph);
            }
            i++;
        }
        return result;
    }

    /**
     * 初始化一条无向有权图
     *
     * @param equations 边
     * @param values    权重
     * @return 有向图
     */
    private Map<String, List<Edge>> constructUndirectedWeightedGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Edge>> graph = new HashMap<>();
        List<String> list;
        List<Edge> set1;
        List<Edge> set2;
        Edge edge1;
        Edge edge2;
        double value;
        for (int i = 0; i < equations.size(); i++) {
            list = equations.get(i);
            String dividend = list.get(0);
            String divisor = list.get(1);
            value = values[i];

            edge1 = new Edge(dividend, value);
            set1 = graph.computeIfAbsent(divisor, k -> new LinkedList<>());
            set1.add(edge1);

            edge2 = new Edge(divisor, 1.0 / value);
            set2 = graph.computeIfAbsent(dividend, k -> new LinkedList<>());
            set2.add(edge2);
        }
        return graph;
    }

    /**
     * @param from  起始点
     * @param end   结束点
     * @param graph 无向有权图
     * @return
     */
    private double bfsFindPath(String from, String end, Map<String, List<Edge>> graph) {
        Map<String, Edge> path = new HashMap();
        Set<String> marked = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(from);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            List<Edge> edges = graph.get(str);
            for (Edge edge : edges) {
                if (!marked.contains(edge.dividend)) {
                    queue.add(edge.dividend);
                    path.put(edge.dividend, new Edge(str, edge.result));
                    if (edge.dividend.equals(end)) {
                        return calc(from, end, path);
                    }
                }
            }
            marked.add(str);
        }
        return -1;
    }

    /**
     * 计算路径值
     *
     * @param from 起始点
     * @param end  结束点
     * @param path 路径
     * @return
     */
    private double calc(String from, String end, Map<String, Edge> path) {
        String tmp = end;
        double result = 1.0;
        while (!tmp.equals(from)) {
            Edge edge = path.get(tmp);
            result *= edge.result;
            tmp = edge.dividend;
        }
        return result;
    }
}
