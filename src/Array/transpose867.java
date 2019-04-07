package Array;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\1\17 0017.
 */
public class transpose867 {
    public static void main(String[] args){
        int[][] A = new int[][]{{1,2,3},{4,5,6}};
        A = transpose(A);
        for(int i = 0;i<A.length;i++){
            System.out.println(Arrays.toString(A[i]));
        }
    }
    public static int[][] transpose(int[][] A){
        if(A.length == A[0].length){
           for(int i = 0;i<A.length;i++){
               for(int j = i+1;j<A.length;j++){
                   int temp = A[i][j];
                   A[i][j] = A[j][i];
                   A[j][i] = temp;
               }
           }
        }else{
            int[][] T = new int[A[0].length][A.length];
            for(int i = 0;i<A.length;i++){
                for(int j = 0;j<A[0].length;j++){
                    T[j][i] = A[i][j];
                }
            }
            A = T;
        }
        return A;
    }
}
