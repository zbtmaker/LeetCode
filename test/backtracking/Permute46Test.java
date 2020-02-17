package backtracking;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/02/17
 */
public class Permute46Test {

    private Permute46 permute46 = new Permute46();

    @Test
    public void test1() {
        List<List<Integer>> result = permute46.permute(new int[]{1, 2, 3, 4});
        printList(result);
    }

    @Test
    public void test2(){
        List<List<Integer>> result = permute46.permute(new int[]{1, 2, 3});
        printList(result);
    }

    @Test
    public void test3(){
        List<List<Integer>> result = permute46.permute(new int[]{1, 2});
        printList(result);
    }

    @Test
    public void test4(){
        List<List<Integer>> result = permute46.permute(new int[]{1});
        printList(result);
    }

    @Test
    public void test5(){
        List<List<Integer>> result = permute46.permute(new int[]{});
        printList(result);
    }

    @Test
    public void test6(){
        List<List<Integer>> result = permute46.permute(null);
        printList(result);
    }

    @Test
    public void test7(){
        List<List<Integer>> result = permute46.permute(new int[]{1,2,3,4,5});
        printList(result);
    }
    private void printList(List<List<Integer>> result) {
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
