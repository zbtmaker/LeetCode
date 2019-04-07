package Array;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\10 0010.
 */
public class sortArrayByParity905 {
    public static void main(String[] args){
        int[] A = new int[]{3,1,2,4};
        sortArrayByParity(A);
        System.out.println(Arrays.toString(A));
    }
    public static int[] sortArrayByParity(int[] A){
        int i =0 ;
        int j = A.length-1;
        while(i<j){
            if(A[i]%2 == 0){
                i++;
            }
            else if(A[j]%2 == 1){
                j--;
            }else{
                swap(A,i,j);
                i++;
                j--;
            }
        }
        return A;
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
