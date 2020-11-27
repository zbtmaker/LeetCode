package graph;


import java.util.*;

/**
 * @author baitao zou
 * date 2020/03/15
 */
public class CalcEquation399 {

    /**
     * @param equations 已知方程式
     * @param values    方程式结果值
     * @param queries   需要查询的方程式
     * @return 等式结果值
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        return calcEquationByDFS(equations, values, queries);
    }

    /**
     * BFS 方式求解
     *
     * @param equations 已知方程式
     * @param values    方程式结果值
     * @param queries   需要查询的方程式
     * @return
     */
    private double[] calcEquationByBFS(List<List<String>> equations, double[] values, List<List<String>> queries) {
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

    public class Edge {
        String dividend;
        double result;

        private Edge(String dividend, double result) {
            this.dividend = dividend;
            this.result = result;
        }
    }

    /**
     * 通过DFS算法寻找图中的一条路径
     *
     * @param equations 等式左边数组
     * @param values    等式右边结果数组
     * @param queries   待查询等式
     * @return 等式结果数组
     */
    public double[] calcEquationByDFS(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = constructGraph(equations, values);
        int len = queries.size();
        double[] result = new double[len];
        for (int i = 0; i < len; i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            if (graph.get(start) == null || graph.get(end) == null) {
                result[i] = -1;
            } else if (end.equals(start)) {
                result[i] = 1;
            } else {
                result[i] = dfs(start, end, graph, new HashSet<>(), 1d);
            }
        }
        return result;
    }

    /**
     * @param start 起始点
     * @param end   终点
     * @param graph 邻接表
     * @param flag  遍历集合
     * @param value 上一步运算结果
     * @return -1-不存在 ｜ 运算结果
     */
    private double dfs(String start, String end, Map<String, List<Node>> graph, Set<String> flag, double value) {
        flag.add(start);
        List<Node> edges = graph.get(start);
        if (edges == null) {
            return -1d;
        }
        for (Node node : edges) {
            if (flag.contains(node.des)) {
                continue;
            }
            if (node.getDes().equals(end)) {
                return value * node.getVal();
            }
            double result = dfs(node.getDes(), end, graph, flag, value * node.getVal());
            if (result != -1) {
                return result;
            }
        }
        return -1d;
    }

    /**
     * @param equations 等式左边数组
     * @param values    等式右边结果数组
     * @return 邻接表
     */
    private Map<String, List<Node>> constructGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String divisor = equation.get(0);
            String dividend = equation.get(1);
            double value = values[i];
            List<Node> edges1 = graph.computeIfAbsent(divisor, k -> new ArrayList<>());
            edges1.add(new Node(dividend, value));

            List<Node> edges2 = graph.computeIfAbsent(dividend, k -> new ArrayList<>());
            edges2.add(new Node(divisor, 1 / value));
        }
        return graph;
    }

    public static class Node {
        private String des;
        private Double val;

        public Node(String des, Double val) {
            this.des = des;
            this.val = val;
        }

        public String getDes() {
            return this.des;
        }

        public Double getVal() {
            return this.val;
        }
    }
}
