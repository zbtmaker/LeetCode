package greedy;

/**
 * Created by Administrator on 2019\3\8 0008.
 */
public class GasStation134 {
    public static void main(String[] args){
        int[] gas = new int[]{1};
        int[] cost = new int[]{3};
        int index = new GasStation134().canCompleteCircuit(gas,cost);
        System.out.println(index);
    }

    /**
     * 我这里都没有用到Greedy Algorithm，其实用了一个暴力的双层循环，所以时间复杂度为O(N^2)，后面我将进一步改善代码，使用
     * greedy Algorithm应该能够得到一个O(N)的算法。
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for(int i = 0;i<len;i++){
            int sum = 0;
            boolean flag = true;
            for(int j = i;j<i+len;j++){
                sum += gas[j % len];
                sum -= cost[j % len];
                if(sum <0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
}
