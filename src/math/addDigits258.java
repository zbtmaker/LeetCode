package math;

/**
 * Created by Administrator on 2019\3\20 0020.
 */
public class addDigits258 {
    public static void main(String[] args){
        int num = new addDigits258().addDigits(38);
        System.out.println(num);
    }
    public int addDigits(int num) {
        while(num > 9){
            int tmp = 0;
            while(true){
                tmp += num % 10;
                num = num / 10;
                if(num == 0){
                    break;
                }
            }
            num = tmp;
        }
        return num;
    }
}
