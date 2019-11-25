package array;

import java.util.Arrays;

/**
 * Created by Administrator on 2019\2\26 0026.
 */
public class sumEvenAfterQueries985 {
    public static void main(String[] args){
        /*[-10,2,-4,5,-3,3]
        [[-4,2],[9,0],[-8,1],[5,4],[1,4],[9,0]]*/
        int[] A = new int[]{-10,2,-4,5,-3,3};
        int[][] queries = new int[][]{{-4,2},{9,0},{-8,1},{5,4},{1,4},{9,0}};
        int[] result = sumEvenAfterQueries(A,queries);
        System.out.println(Arrays.toString(result));
    }
    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        int[] result = new int[queries.length];
        for(int i = 0;i<A.length;i++){
            if(A[i] % 2 == 0){
                sum += A[i];
            }
        }
        for(int j = 0;j<queries.length;j++){
            int tempQ = A[queries[j][1]] + queries[j][0];
            int flagQ = tempQ % 2;
            int flagA = A[queries[j][1]]  % 2;
            if( flagA !=0 && flagQ !=0 ){
                result[j] = sum;
            }else if(flagA != 0 && flagQ == 0){
                sum += tempQ;
                result[j] = sum;
            }else if(flagA == 0 && flagQ !=0){
                sum -= A[queries[j][1]];
                result[j] = sum;
            }else{
                sum += queries[j][0];
                result[j] = sum;
            }

            A[queries[j][1]] = A[queries[j][1]] + queries[j][0];

        }
        return result;
    }
}
