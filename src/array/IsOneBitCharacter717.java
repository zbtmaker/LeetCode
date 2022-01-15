package array;

/**
 * Created by Administrator on 2019\1\18 0018.
 */
public class IsOneBitCharacter717 {

    public boolean isOneBitCharacter(int[] bits) {
        boolean flag = false;
        int i = 0;
        while (i < bits.length) {
            if (i == bits.length - 1) {
                flag = true;
                i++;
            } else if (bits[i] == 1) {
                i += 2;
            } else {
                i++;
            }
        }
        return flag;
    }
}
