package Unkown;

/**
 * Created by Administrator on 2019\3\30 0030.
 */
public class hammingDistance461 {
    public static void main(String[] args){
        int count = new hammingDistance461().hammingDistance(1,4);
        System.out.println(count);
    }
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        return hammingWeight(num);
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
