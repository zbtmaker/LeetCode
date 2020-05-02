package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baitao zou
 * date 2020/05/01
 */
public class PalindromePairs336Test {

    private PalindromePairs336 palindrome = new PalindromePairs336();

    @Test
    public void test1() {
        List<List<Integer>> list = palindrome.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
        for(List<Integer> arr : list){
            System.out.println(Arrays.toString(arr.toArray(new Integer[0])));
        }
    }
}
