package Unkown;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019\3\9 0009.
 */
public class FractiontoRecurringDecimal166 {
    public static void main(String[] args){

        String str = new FractiontoRecurringDecimal166().fractionToDecimal(-1,-2147483648);
        System.out.println(str);

    }
    /**
     * 测试用例A : 1 / 2 = 0.5
     * 测试用例B : 1 / 3 = 0.(3);
     * 测试用例C : 1 / 6 = 0.1(6)
     * 测试用例D : 1 / 7 = 0.(142871)
     * 测试用例E : 1 / 9 = 0.(1)
     * 测试用例F : 25 / 7 = 3.(571248)
     * 测试用例G : 4 /333 = 0.(012)
     * 测试用例F : 4 /332 = 0.(01204819277108433734939759036144578313253)
     * 测试用例  : 1 / 90 = 0.0(1)
     * 测试用例  : -50 / 8 = -6.25
     * 问题两个整数相乘，其中被除数为numerator，除数为denominator。我们这里只考虑整数部分
     *
     * 具体的思路，我们将一个的整数部分首先放入到StringBuilder当中，然后如果此时余数不等于零，那么我们
     * 在StringBuilder中添加一个'.'符号表示此除法还有小数部分，那么我们的小数部分放置到LinkedHashMap
     * 当中，其中LinkedHashMap中的key-value分别放置小数部分以及其位置。为什么使用LinkedHashMap，而不是
     * 其他数据结构，首先我们要使用Map，如果一个数是一个无限循环小数，那么我们就需要找到其无限不循环的位置，从而
     * 在该位置前面和最后添加"()"符号，而查找最快的方式就是Map能够实现O(1)时间复杂度的查找。此外为什么不是
     * HashMap，而是LinkedHashMap，这是因为LinkedHashMap有助于我们的小数插入到StringBuilder是有序的。

     * 那么我们知道这需要一个循环来实现，因此循环的结束条件是什么，
     * 条件一 : 那就是一旦余数(residual)为零。
     * 条件二 : 余数相同则表示开开始循环了
     *
     * 遇到的坑:
     * 坑A : 如果不是循环小数，那么while循环退出的条件就是res = 0,如果是一个循环小数，那么我们就需要判断什么时候开始循环，
     *      这里我们使用LinkedHashMap用于放置商和余数res->quo，如果当前所得结果的余数能够在LinkedHashMap中找到，那么此时
     *      说明循环开始了，我们就从LinkedHashMap中相应的res->quo处添加'('。
     * 坑B : 两个计算结果的余数相同，当时商可能不一定相同，但是有一点可以保证的是，如果两个计算结果的余数相同，那么第二次所得到的
     *      商一定比第一次的商要短，因此在余数相同的情况下，一定要根据第二个商来判断第一个商是从何处开始循环的(1/90=0.0(1))
     * 坑C :对于负数我们首先判断除法结果的正负性，如果是负数，那么我们在StringBuilder当中添加'-',如果一个数是Integer.MIN，
     *      那么Math.abs(Integer.MIN) = Integer.MIN。因此我们想到了将int型数据转换成long数据中这样就解决了这个问题。
     * LinkedHashMap中找到了对应的商。那么此时就应该结束。结束之后，将LinkedHashMap中的元素有序的放入到
     * StringBuilder中。
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        long num = numerator;
        long denom = denominator;

        Map<Long,String> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        if((num <0 && denom>0) || (num>0 && denom<0)){
            sb.append('-');
        }
        num = Math.abs(num);
        denom = Math.abs(denom);
        long quo = num/ denom;//表示商
        long res = num % denom;//表示余数
        if(res != 0){
            sb.append(quo).append(".");
        }else{
            sb.append(quo);
        }
        num = res;
        while(res != 0){
            int mul = 10;
            StringBuilder resStr = new StringBuilder();
            int i = 0;//很神奇的是循环开始的位置还和这个i的值是有关系的
            while(num < denom){
                if(i > 0){
                    resStr.append(0);
                }
                num *= mul;
                i++;
            }
            quo = num / denom;
            res = num % denom;
            resStr.append(quo);
            String str = resStr.toString();
            if(map.containsKey(num)){
                for(Map.Entry<Long,String> entry : map.entrySet()){
                    if(entry.getKey().equals(num)){
                        //这里还需要进一步处理
                        String  str0 = entry.getValue();
                        int len0 = str0.length();
                        int len1 = str.length();
                        int index = len0 - len1 -1;
                        if(index == -1){
                            sb.append('(').append(str0);
                        }else{
                            for(int j = 0;j<len0;j++){
                                if(j == index){
                                    sb.append(str0.charAt(j)).append('(');
                                }else{
                                    sb.append(str0.charAt(j));
                                }
                            }
                        }

                    }else{
                        sb.append(entry.getValue());
                    }
                }
                sb.append(')');
                return sb.toString();
            }else{
                map.put(num,str);
            }
            num = res;

        }
        if(map.size() > 0){
            for(Map.Entry<Long,String> entry : map.entrySet()){
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }
}
