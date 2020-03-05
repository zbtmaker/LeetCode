package array;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * <p>
 * 这种题目解题思想就是图中的topological sort 算法就可以解决，
 * 链接：https://oi-wiki.org/graph/topo/
 *
 * @author baitao zou
 * date 2020/02/26
 */
public class CanFinish207 {

    /**
     * we can use the
     * test case: prerequisites = [1,0]
     *
     * @param numCourses    课堂数量
     * @param prerequisites 必修课
     * @return true-可以完成 ｜ false-不能完成
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return true;
    }


    /**
     * [1, 0]
     * id = [0, 1]
     * j = 1; prerequisites[1][0] = 1, prerequisites[1][1] = 0; id[1] = 1, id[0] = 0; id[0] = 1; id = [1,1];
     *
     */
}
