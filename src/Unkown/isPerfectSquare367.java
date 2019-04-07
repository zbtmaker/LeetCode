package Unkown;

/**
 * Created by Administrator on 2019\3\20 0020.
 */
public class isPerfectSquare367 {
    public static void main(String[] args){
        int num = 2147483647;
        boolean flag = new isPerfectSquare367().isPerfectSquare(num);
        System.out.println(flag);
        System.out.println(Math.sqrt(num));
    }
    /**
     * 这种题的本质还是二分法，只不过掺杂了数学知识，也就是用数学知识做外套，将二分法
     * 知识包围了起来，因此我们要使用二分法，首先需要构造一个数组，因此，当一个数比较大的
     * 时候就会浪费大量的空间。这种方式对于小数是可以接受的,但是对于一个大树，我们就无法得到这个
     * 结果了。因此看看有没有更简单的方法，这里我们不用辅助数组了，因为没有必要，我们直接将left = 1；
     * right = num。此时空间超出的问题解决了。但是对于一个大数Integer.MAX_VALUE这个值当left = 1，
     * right = Integer.MAX_VALUE时，会出现整数溢出的情况，因此最好的办法就是将整形换成long型的数据，就不会有
     * 整数溢出的情况了。
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        while(left <= right){
            long middle = (left + right) >> 1;
            long mul = middle * middle;
            if(mul > num){
                right = middle - 1;
            }else if(mul < num){
                left = middle + 1;
            }else{
                return true;
            }

        }
        return false;
    }
    /**
    private int[] constructArray(int num){
        int[] arr = new int[num];
        for(int i = 0;i<arr.length;i++){
            arr[i] = i + 1;
        }
        return arr;
    }*/
}
