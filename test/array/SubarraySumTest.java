package array;


import org.junit.Test;

public class SubarraySumTest {

    @Test
    public void test1(){
        int[] nums = new int[]{1,1,1};
        int k = 2;
        int result = new SubarraySum().subarraySum(nums,k);
        System.out.println(result);
    }

    @Test
    public void test2(){
        int[] nums = new int[]{1,-1,1,3,-2};
        int k = 2;
        int result = new SubarraySum().subarraySum(nums,k);
        System.out.println(result);
    }
}
