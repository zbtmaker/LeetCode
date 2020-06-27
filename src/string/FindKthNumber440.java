package string;

/**
 * @author Baitao Zou
 * date 2020/06/27
 */
public class FindKthNumber440 {
    /**
     * 采用DFS算法实现，但是时间复杂度有些高，那么我们有没有更好的方式
     * @param n
     * @param k
     * @return 第K小的数组
     */
    public int findKthNumber(int n, int k) {
        if(k > n){
            return 1;
        }
        int[] result = new int[]{1};
        int[] count = new int[]{0};
        for(int i = 1;i<=9;i++){
            if(dfsGenerator(i,count,n,k, result)){
                break;
            }
        }
        return result[0];
    }
    private boolean dfsGenerator(int cur, int[] count ,int n, int k,int[] result){
        if(cur > n) {
            return false;
        }
        count[0]++;
        if(count[0] == k){
            result[0] = cur;
            return true;
        }
        boolean flag = false;
        for(int m = 0;m <= 9;m++){
            int tmp = cur * 10 + m;
            if(dfsGenerator(tmp,count,n,k,result)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
