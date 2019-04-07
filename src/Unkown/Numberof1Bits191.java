package Unkown;

/**
 * Created by Administrator on 2019\3\9 0009.
 */
public class Numberof1Bits191 {
    public static void main(String[] args){
        int n = -1;
        int count = new Numberof1Bits191().hammingWeight(n);
        System.out.println(count);
    }

    /**
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
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
