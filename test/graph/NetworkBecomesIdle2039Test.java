package graph;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zoubaitao
 * date 2022/03/20
 */
public class NetworkBecomesIdle2039Test extends TestCase {

    private final NetworkBecomesIdle2039 network = new NetworkBecomesIdle2039();

    public void test1() {
        int idle = network.networkBecomesIdle(new int[][]{{0, 1}, {1, 2}}, new int[]{0, 2, 1});
        Assert.assertEquals(idle, 8);
    }

    public void test2() {
        int idle = network.networkBecomesIdle(new int[][]{{0, 1}, {0, 2}, {1, 2}}, new int[]{0, 10, 10});
        Assert.assertEquals(idle, 3);
    }

    public void test3() {
        int idle = network.networkBecomesIdle(new int[][]{{0, 1}, {1, 2}}, new int[]{0, 2, 2});
        Assert.assertEquals(idle, 7);
    }

    public void test4() {
        int idle = network.networkBecomesIdle(new int[][]{{0, 1}, {1, 2}}, new int[]{0, 2, 3});
        Assert.assertEquals(idle, 8);
    }

    public void test5() {
        int idle = network.networkBecomesIdle(new int[][]{{0, 1}, {1, 2}}, new int[]{0, 2, 4});
        Assert.assertEquals(idle, 5);
    }

    public void test6() {
        int idle = network.networkBecomesIdle(new int[][]{{0, 1}, {1, 2}, {2, 3}}, new int[]{0, 2, 4, 2});
        Assert.assertEquals(idle, 11);
    }

    public void test7() {
        int idle = network.networkBecomesIdle(new int[][]{{0, 1}, {1, 2}, {2, 3}}, new int[]{0, 2, 4, 1});
        Assert.assertEquals(idle, 12);
    }

    public void test8() {
        int idle = network.networkBecomesIdle(new int[][]{{0, 1}, {1, 2}, {2, 3}}, new int[]{0, 2, 4, 3});
        Assert.assertEquals(idle, 10);
    }


    public void test9() {
        int idle = network.networkBecomesIdle(new int[][]{{0, 1}, {1, 2}, {2, 3}}, new int[]{0, 2, 4, 4});
        Assert.assertEquals(idle, 11);
    }

    public void test10() {
        int idle = network.networkBecomesIdle(new int[][]{{0, 1}, {1, 2}, {2, 3}}, new int[]{0, 2, 4, 5});
        Assert.assertEquals(idle, 12);
    }

    public void test11() {
        int idle = network.networkBecomesIdle(new int[][]{{0, 1}, {1, 2}, {2, 3}}, new int[]{0, 2, 4, 6});
        Assert.assertEquals(idle, 7);
    }

    public void test12() {
        int[][] edges = convertStrToMatrix("[[34,90],[82,5],[184,178],[92,32],[125,98],[149,134],[120,154],[37,129],[30,180],[161,2],[116,20],[42,12],[62,73],[96,162],[174,31],[124,101],[43,82],[87,59],[127,137],[103,7],[58,14],[119,133],[1,15],[84,113],[164,122],[128,104],[141,36],[81,166],[170,182],[89,30],[85,84],[109,1],[28,70],[83,102],[117,60],[31,169],[159,76],[146,67],[151,58],[23,34],[148,184],[179,19],[123,115],[70,21],[78,33],[99,26],[155,71],[104,100],[16,151],[72,147],[95,124],[13,138],[133,53],[60,116],[173,63],[29,56],[80,120],[17,43],[55,110],[6,119],[154,143],[51,172],[14,39],[112,38],[39,32],[35,132],[98,159],[160,107],[73,65],[183,27],[177,78],[136,46],[18,75],[27,91],[71,163],[100,77],[122,51],[178,45],[52,55],[59,160],[12,114],[38,42],[113,4],[163,167],[171,131],[167,183],[7,37],[102,54],[91,156],[40,92],[139,74],[142,145],[147,62],[0,128],[66,165],[111,175],[107,16],[22,80],[92,53],[94,86],[153,24],[74,3],[165,108],[176,130],[181,177],[67,95],[144,117],[15,135],[57,93],[145,8],[8,48],[26,127],[36,171],[126,40],[168,157],[108,121],[56,109],[65,88],[169,35],[130,181],[110,9],[2,22],[137,87],[152,118],[182,174],[53,32],[79,10],[114,47],[63,161],[0,94],[0,32],[76,150],[131,112],[129,105],[121,168],[118,111],[68,83],[69,61],[5,173],[172,149],[20,179],[162,57],[21,158],[166,11],[105,139],[93,44],[97,79],[106,23],[47,123],[46,49],[77,50],[157,153],[138,126],[0,69],[88,97],[24,68],[156,176],[92,39],[48,41],[158,170],[86,146],[61,142],[54,125],[19,148],[175,52],[44,85],[9,103],[135,144],[33,152],[90,66],[140,6],[101,28],[143,136],[75,96],[41,155],[53,39],[115,140],[150,13],[134,72],[180,164],[64,81],[45,106],[49,141],[50,89],[4,99],[11,25],[10,64],[25,17],[3,18],[132,29]]");
        int[] patience = new int[]{0, 5, 4, 6, 8, 6, 10, 3, 11, 1, 9, 1, 9, 13, 9, 9, 12, 3, 6, 7, 2, 5, 1, 4, 7, 4, 18, 10, 7, 9, 16, 1, 24, 1, 5, 15, 5, 8, 11, 2, 27, 4, 10, 1, 3, 4, 3, 8, 1, 10, 12, 21, 3, 2, 17, 1, 1, 1, 5, 3, 4, 29, 11, 2, 4, 2, 9, 9, 12, 9, 2, 10, 9, 7, 5, 7, 9, 3, 10, 2, 7, 4, 8, 3, 12, 4, 16, 6, 4, 22, 6, 13, 20, 1, 2, 8, 1, 2, 5, 16, 29, 16, 5, 1, 27, 2, 5, 22, 1, 6, 4, 5, 7, 5, 15, 5, 4, 5, 4, 6, 8, 5, 8, 24, 23, 17, 7, 8, 3, 1, 7, 5, 2, 17, 4, 5, 11, 9, 16, 1, 12, 13, 26, 1, 7, 4, 18, 1, 7, 12, 19, 12, 1, 10, 3, 3, 14, 8, 15, 19, 22, 1, 4, 22, 14, 1, 4, 1, 11, 11, 13, 2, 2, 1, 1, 7, 8, 2, 2, 1, 15, 3, 4, 19, 1};
        int idle = network.networkBecomesIdle(edges, patience);
        Assert.assertEquals(idle,123);
    }

    public static int[][] convertStrToMatrix(String str) {
        str = str.substring(1, str.length() - 1);
        String[] strArr = str.split("],");
        int[][] res = new int[strArr.length][2];
        for (int i = 0; i < strArr.length; i++) {
            String s = strArr[i];
            if (i == strArr.length - 1) {
                s = s.substring(1, s.length() - 1);
            } else {
                s = s.substring(1);
            }
            String[] arr = s.split(",");
            res[i][0] = Integer.parseInt(arr[0]);
            res[i][1] = Integer.parseInt(arr[1]);
        }
        return res;
    }
}
