package hash;


import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\29 0029.
 * 这个题目目前采用的是双层循环来解决，那么就需要双指针
 */
public class dailyTemperatures739 {
    @Test
    public void test(){
        int[] raise = new dailyTemperatures739().dailyTemperatures(
                new int[]{73,74,75,71,69,72,76,73});
        System.out.println(Arrays.toString(raise));
    }
    public int[] dailyTemperatures(int[] T) {
        int[] raise = new int[T.length];
        for(int i = 0;i<T.length;i++){
            for(int j = i + 1;j<T.length;j++){
                if(T[j] > T[i]){
                    raise[i] = j - i;
                    break;
                }
            }
        }
        return raise;
    }

}
