package array;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\10 0010.
 */
public class flipAndInvertImage832 {
    public static void main(String[] args){
        int[][] A = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        flipAndInvertImage(A);
        for(int i = 0;i<A.length;i++){
            System.out.println(Arrays.toString(A[i]));
        }

    }

    public static void flipAndInvertImage(int[][] A){
        for(int i = 0;i<A.length;i++){
            flipAdnInvertArray(A[i]);
        }
    }
    public static void flipAdnInvertArray(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            swap(arr,i,j);
            arr[i] = arr[i] ^ 1;
            arr[j] = arr[j] ^ 1;
            i++;j--;
        }
        if(arr.length%2 == 1){
            int mid = arr.length >> 1;
            arr[mid] = arr[mid] ^ 1;
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
