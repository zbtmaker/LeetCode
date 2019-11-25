package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCloneGraph133 {

    @Test
    public void testDepthFirstSearch(){
        CloneGraph133.Node node1 = new CloneGraph133.Node();
        node1.val = 1;
        List<CloneGraph133.Node> nodeList1 = new ArrayList<>();
        node1.neighbors = nodeList1;

        CloneGraph133.Node node2 = new CloneGraph133.Node();
        node2.val = 2;
        List<CloneGraph133.Node> nodeList2 = new ArrayList<>();
        node2.neighbors = nodeList2;

        CloneGraph133.Node node3 = new CloneGraph133.Node();
        node3.val = 3;
        List<CloneGraph133.Node> nodeList3 = new ArrayList<>();
        node3.neighbors = nodeList3;

        CloneGraph133.Node node4 = new CloneGraph133.Node();
        node4.val = 4;
        List<CloneGraph133.Node> nodeList4 = new ArrayList<>();
        node4.neighbors = nodeList4;

        nodeList1.add(node2);
        nodeList1.add(node4);

        nodeList2.add(node1);
        nodeList2.add(node3);

        nodeList3.add(node2);
        nodeList3.add(node4);

        nodeList4.add(node3);
        nodeList4.add(node1);

        CloneGraph133 cloneGraph133 = new CloneGraph133();
        cloneGraph133.depthFirstSearch(node1);

    }
    @Test
    public void testBreadthFirstSearch(){
        CloneGraph133.Node node1 = new CloneGraph133.Node();
        node1.val = 1;
        List<CloneGraph133.Node> nodeList1 = new ArrayList<>();
        node1.neighbors = nodeList1;

        CloneGraph133.Node node2 = new CloneGraph133.Node();
        node2.val = 2;
        List<CloneGraph133.Node> nodeList2 = new ArrayList<>();
        node2.neighbors = nodeList2;

        CloneGraph133.Node node3 = new CloneGraph133.Node();
        node3.val = 3;
        List<CloneGraph133.Node> nodeList3 = new ArrayList<>();
        node3.neighbors = nodeList3;

        CloneGraph133.Node node4 = new CloneGraph133.Node();
        node4.val = 4;
        List<CloneGraph133.Node> nodeList4 = new ArrayList<>();
        node4.neighbors = nodeList4;

        nodeList1.add(node2);
        nodeList1.add(node4);

        nodeList2.add(node1);
        nodeList2.add(node3);

        nodeList3.add(node2);
        nodeList3.add(node4);

        nodeList4.add(node3);
        nodeList4.add(node1);

        CloneGraph133 cloneGraph133 = new CloneGraph133();
        cloneGraph133.breadthFirstSearch(node1);

    }
}
