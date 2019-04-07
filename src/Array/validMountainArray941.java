package Array;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\19 0019.
 */
public class validMountainArray941 {
    public static void main(String[] args){
        int[] A = new int[]{3,7,6,4,3,0,1,0};
        System.out.println(validMountainArray(A));


    }
    public static boolean validMountainArray(int[] A){
        if(A.length<3){
            return false;
        }
        boolean flag = false;
        boolean[] left = new boolean[A.length];
        boolean[] right = new boolean[A.length];
        left[0] = true;
        right[A.length-1] = true;
        for(int i = 1;i<A.length-1;i++){
            if(A[i]>A[i-1] && left[i-1]){
                left[i] = true;
            }else{
                left[i] = false;
            }

            if(A[A.length-1-i]>A[A.length-i] && right[A.length-i]){
                right[A.length-1-i] = true;
            }else{
                right[A.length-1-i] = false;
            }
        }
        for(int i = 1;i<A.length-1;i++){
            if(left[i] && right[i]){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
