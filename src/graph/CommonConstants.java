package graph;

/**
 * @author zoubaitao
 * date 2021/09/06
 */
public class CommonConstants {

    /**
     * 未曾访问的状态
     */
    public static final Integer WITHE = 0;

    /**
     * 访问了节点，但是周围的其他节点还未被访问
     */
    public static final Integer GRAY = 1;

    /**
     * 访问了节点且访问了周围相连的所有其他节点
     */
    public static final Integer BLACK = 2;

    public static final Integer NON_PARENT = -1;
}
