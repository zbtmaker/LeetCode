package math;

/**
 * Created by Administrator on 2019\3\30 0030.
 */
public class totalHammingDistance477 {
    public static void main(String[] args){
        int[] nums = new int[]{4, 14, 2};
        int total = new totalHammingDistance477().totalHammingDistance(nums);
        System.out.println(total);
    }
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for(int i = 0;i < nums.length - 1;i++){
            for(int j = i + 1;j<nums.length;j++){
                int num = nums[i] ^ nums[j];
                total += hammingWeight(num);
            }
        }
        return total;
    }
    private int hammingWeight(int n) {
        int count = 0;
        int b = 1;
        int i = 1;
        while(i<=32){
            if((n & b) != 0){
                count++;
            }
            i++;
            b = b<<1;
        }
        return count;
    }
}
