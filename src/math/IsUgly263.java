package math;

/**
 * @author baitao zou
 * date 2020/02/08
 */
public class IsUgly263 {

    /**
     * 1、暴力破解的方式实现
     * 2、没有可以优化的方案了
     *
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        return isUglyByBruteForce(num);
    }

    /**
     * 使用暴力破解的方式实现
     * 1、如果一个数小于等于0，那么一定不是丑数
     * 2、如果一个数是丑数，那么一定能整除2，3，5其中任意一个数，如果这三个数都没有整除，那么这个数肯定就不是丑数了。
     * 所以用一个while循环就可以搞定
     *
     * @return true-丑数，false-非丑数
     */
    public boolean isUglyByBruteForce(int num) {
        if (num < 1) {
            return false;
        }
        while (num != 1) {
            boolean flag = true;
            if (num % 2 == 0) {
                num = num / 2;
                flag = false;
            } else if (num % 3 == 0) {
                num = num / 3;
                flag = false;
            } else if (num % 5 == 0) {
                num = num / 5;
                flag = false;
            }
            if (flag) {
                return false;
            }
        }
        return true;
    }
}
