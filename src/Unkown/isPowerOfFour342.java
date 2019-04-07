package Unkown;

/**
 * Created by Administrator on 2019\3\21 0021.
 */
public class isPowerOfFour342 {
    public static void main(String[] args){
        int n = 128;
        boolean flag = new isPowerOfFour342().isPowerOfFour(n);
        System.out.println(flag);

    }
    public boolean isPowerOfFour(int n) {
        if(n <= 0){
            return false;
        }

        int count = 0;
        int shift = 1;
        int i = 1;
        int index = 0;
        while(i <= 32){
            if((n & shift)!=0){
                count ++;
                index = i;
            }
            if(count > 1){
                return false;
            }
            shift = shift << 1;
            i ++;
        }
        if(index % 2 == 0){
            return false;
        }
        return true;
    }
}
