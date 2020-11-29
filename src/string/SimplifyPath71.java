package string;

import java.util.Stack;

/**
 * LeetCode71：https://leetcode-cn.com/problems/simplify-path/
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 * @author baitao zou
 * date 2020/07/03
 */
public class SimplifyPath71 {

    private final static String SLASH = "/";

    private final static String EMPTY = "";

    private final static String CURRENT_PATH = ".";

    private final static String TOP_PATH = "..";

    /**
     * 这里的想法其实来源于Spring源码中的StringUtils类中的解析路径的方法，但是他们的源码使用的是LinkedList，
     * 我们这里采用Stack的方式实现，我们这里采用三步走方式，第一步是借助String的原生方法split方法按照"/"方式分割，
     * 分割之后得到的就是各个路径，但是会出现""和"."的路径以及路径"..",对于路径数组中的""和"."不需要入栈，而对于
     * ".."，需要回到上一级路径，所以需要将栈中的路径出栈表示回到上一层路径。最后将栈中剩余的路径每一个路径前面添加
     * "/"用StringBuilder拼接起来就可以了。
     *
     * @param path 原始路径
     * @return 简化后的路径
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split(SLASH);
        for (String str : paths) {
            if (str.equals(EMPTY) || str.equals(CURRENT_PATH)) {
                continue;
            }
            if (str.equals(TOP_PATH)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }

        }
        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            if (!str.equals(CURRENT_PATH)) {
                sb.append(SLASH).append(str);
            }
        }
        return sb.length() == 0 ? SLASH : sb.toString();
    }
}
