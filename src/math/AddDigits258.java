package math;

/**
 * Created by Administrator on 2019\3\20 0020.
 */
public class AddDigits258 {

    public int addDigits(int num) {
        while(num > 9){
            int tmp = 0;
            do {
                tmp += num % 10;
                num = num / 10;
            } while (num != 0);
            num = tmp;
        }
        return num;
    }
}
