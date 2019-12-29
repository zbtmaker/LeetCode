package dp;


import org.junit.Test;

import static org.junit.Assert.*;

public class IncreasingTripletTest {

    @Test
    public void test1(){
        int[] nums = new int[]{1,5,4,2,3};
        boolean result = new IncreasingTriplet().increasingTriplet(nums);
        System.out.println(result);
    }

}
