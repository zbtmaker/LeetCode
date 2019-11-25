package array;

/**
 * Created by Administrator on 2019\1\21 0021.
 * 题目描述：给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。这里需要的是连续的公共子串
 */
public class findLength718 {
    public static void main(String[] args){
        int[] A = new int[]{1,2,3,2,1};
        int[] B = new int[]{};
        System.out.println(findLength(A,B));
    }
    public static  int findLength(int[] A,int[] B){
        int[][] D = new int[A.length+1][B.length+1];
        int max = 0;
        for(int i = 0; i <A.length;i++){
            for(int j = 0; j <B.length;j++){
                if(A[i] == B[j]){
                    D[i+1][j+1] = D[i][j]+1;
                    max = max < D[i+1][j+1] ? D[i+1][j+1] : max;
                }
            }
        }
        return max;
    }
}
