package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * <p>
 * 链接：https://leetcode-cn.com/problems/course-schedule
 *
 * @author Baitao Zou
 * date 2019/10/06
 */
public class CanFinish207 {
    /**
     * the course didn't visit
     */
    private static final int UNVISITED = 0;

    /**
     * the course is visiting
     */
    private static final int VISITING = 1;

    /**
     * the course has finished  visit
     */
    private static final int VISITED = 2;

    /**
     * leetcode-207: 现在你总共有 n 门课需要选，记为 0 到 n-1。
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
     * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
     * <p>
     * 链接：https://leetcode-cn.com/problems/course-schedule
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> adj = constructAdj(prerequisites);
        int[] marked = new int[numCourses];
        boolean[] flag = new boolean[]{true};
        for (int course = 0; course < numCourses; course++) {
            if (marked[course] != VISITED) {
                dfs(course, adj, marked, flag);
                if (!flag[0]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * construct a adjacent list
     *
     * @param prerequisites
     * @return
     */
    private Map<Integer, List<Integer>> constructAdj(int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return new HashMap<>();
        }
        int len = prerequisites.length;

        Map<Integer, List<Integer>> adj = new HashMap<>(len);
        List<Integer> list;
        for (int[] prerequisite : prerequisites) {
            list = (list = adj.get(prerequisite[1])) == null ? new LinkedList<>() : list;
            list.add(prerequisite[0]);
            adj.put(prerequisite[1], list);
        }
        return adj;
    }

    private void dfs(int course, Map<Integer, List<Integer>> adj, int[] marked, boolean[] flag) {
        List<Integer> courseList = adj.get(course);
        if (adj.get(course) == null) {
            marked[course] = VISITED;
            return;
        }
        marked[course] = VISITING;
        for (int tmpCourse : courseList) {
            if (marked[tmpCourse] == UNVISITED) {
                dfs(tmpCourse, adj, marked, flag);
            } else if (marked[tmpCourse] == VISITING) {
                flag[0] = false;
                return;
            }
        }
        marked[course] = VISITED;
    }

    /**
     * Leetcode-210: 现在你总共有 n 门课需要选，记为 0 到 n-1。
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
     * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
     * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
     * <p>
     * 链接：https://leetcode-cn.com/problems/course-schedule-ii
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = constructAdj(prerequisites);
        int[] marked = new int[numCourses];
        LinkedList<Integer> sort = new LinkedList<>();
        boolean[] flag = new boolean[]{true};
        for (int course = 0; course < numCourses; course++) {
            if (marked[course] == UNVISITED) {
                dfs(course, adj, marked, sort, flag);
                if (!flag[0]) {
                    return new int[0];
                }
            }
        }
        return sort.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int course, Map<Integer, List<Integer>> adj, int[] marked, LinkedList<Integer> sort, boolean[] flag) {
        List<Integer> courseList = adj.get(course);
        if (adj.get(course) == null) {
            marked[course] = VISITED;
            sort.addFirst(course);
            return;
        }
        marked[course] = VISITING;
        for (int tmpCourse : courseList) {
            if (marked[tmpCourse] == UNVISITED) {
                dfs(tmpCourse, adj, marked, sort, flag);
            } else if (marked[tmpCourse] == VISITING) {
                flag[0] = false;
                return;
            }
        }
        marked[course] = VISITED;
        sort.addFirst(course);
    }
}
