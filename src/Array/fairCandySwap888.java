package Array;

/**
 * Created by Administrator on 2019\1\19 0019.
 */
public class fairCandySwap888 {
    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        for(int i = 0;i<A.length;i++){
            sumA += A[i];
        }

        int sumB = 0;
        for(int j = 0;j<B.length;j++){
            sumB += B[j];
        }

        int average = sumA > sumB ? sumA-sumB : sumB-sumA;
        return null;
    }
}
