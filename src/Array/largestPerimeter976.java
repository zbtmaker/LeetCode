package Array;

/**
 * Created by Administrator on 2019\1\17 0017.
 */
public class largestPerimeter976 {
    public static void main(String[] args){
        int[] A = new int[]{1,2,1};
        System.out.println(largestPerimeter(A));
    }
    public static int largestPerimeter(int[] A){
        int max = 0;
        for(int i = 0;i<A.length;i++){
            for(int j = i+1;j<A.length;j++){
                for(int k = j+1;k<A.length;k++){
                    if((A[i]+A[j]>A[k]) && (A[i]+A[k]>A[j]) && (A[j]+A[k]>A[i])){
                        int perimeter = A[i]+A[j]+A[k];
                        if(perimeter > max){
                            max = perimeter;
                        }
                    }
                }
            }
        }
        return max;
    }
}
