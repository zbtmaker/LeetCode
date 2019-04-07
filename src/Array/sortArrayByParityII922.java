package Array;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\17 0017.
 */
public class sortArrayByParityII922 {
    public static void main(String[] args){
        int[] nums = new int[]{2,3,1,1,4,0,0,4,3,3};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));
    }
    public static int[] sortArrayByParityII(int[] A){
        int i = 0;
        int j = 1;
        while(i<A.length && j<A.length){
           while(A[i] % 2 == 0){
                i += 2;
                if(i>=A.length){
                    break;
                }
            }
            while(A[j] % 2 == 1){
                j += 2;
                if(j>=A.length){
                    break;
                }
            }
            if(i<A.length && j<A.length){
                swap(A,i,j);
            }
        }
        return A;
    }
    public static void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
