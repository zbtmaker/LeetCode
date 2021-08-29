package graph;

/**
 * 带源节点、目的节点、权重的边
 *
 * @author zoubaitao
 * date 2021/08/29
 */
public class Edge<T,U> {
    /**
     * 源节点
     */
    T src;

    /**
     * 目的节点
     */
    T des;

    /**
     * 距离
     */
    U dis;


    public Edge(T src, T des, U dis) {
        this.src = src;
        this.des = des;
        this.dis = dis;
    }

    public Edge(T des, U dis) {
        this.des = des;
        this.dis = dis;
    }
}
