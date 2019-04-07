package String;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019\3\9 0009.
 */
public class IntegerToRoman12 {
    public static void main(String[] args){
        IntegerToRoman12 to = new IntegerToRoman12();
        String str = to.intToRoman(1993);
        System.out.println(str);
    }

    /**
     * 罗马数字转整数主要的方式是将，第一步将要转换的数分割成每一位如1994可以分割成
     * {3->9->9->1}这四个数，然后我们分别将3*1，9*10，9*100,1*1000转换成Roman，
     * 对于这其中的每一数转换成Roman需要注意的是，我们首先需要在罗马字母表中对应的找到
     * 这个数或者是比这个数小的数，比如3这个数，并不能用已有的数直接表示，而是要分成
     * 3个I来表示，那么我们就需要构造一个数组aux，这个数组中的元素表示能够直接与罗马数字
     * 进行转换的数字。我们在这里采用二分法的变种来实现这个问题，我们的3只能用I来表示，
     * 那么我们就需要在aux这个数组中找到一个数使这个数刚好小于我们的target=3的数组的下标。
     * 具体的函数可以参考binarySearch这个function。然后调用func方法将数组转换成一个Roman。
     * 对{3->9->9->1}中所有的元素都如此操作即可。
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] aux = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        List<Integer> list = split(num);
        int mul = 1;
        LinkedList<String> result = new LinkedList<>();
        for(Integer i : list){
            if(i != 0){
                result.addFirst(func(i * mul,aux));
            }
            mul *= 10;
        }
        StringBuilder sb = new StringBuilder();
        for(String str : result){
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * 将数组num拆分成每一位并将每一位放在List当中，这里我们采用倒叙的方式放置
     * 如16在链表当中就是 6->1
     * @param num
     * @return
     */
    private List<Integer> split(int num){
        List<Integer> list = new LinkedList<>();
        while(num != 0){
            int quotient = num / 10;
            int res = num % 10;
            list.add(res);
            num = quotient;
        }
        return list;
    }

    /**
     * 将某一位上的数转换成一个Roman数字
     * @param target
     * @param aux
     * @return
     */
    private String func(int target,int[] aux){
        StringBuilder sb = new StringBuilder();
        int index = binarySearch(aux,target);
        int quotient = target / aux[index];
        String str = toRoman(aux[index]);
        for(int i = 0;i<quotient;i++){
            sb.append(str);
        }
        int res = target % aux[index];
        if(res != 0){
            sb.append(func(res,aux));
        }
        return sb.toString();
    }
    /**
     * 此binary Search和之前接触的binary Search有所不同，以前的二分查找：如果命中则返回索引
     * 如果没有命中则返回-1。这里如果我们命中，则返回当前的那个索引，如果没有命中，那么我们就返回
     * 刚好比其小的那个数。
     * @param aux
     * @param target
     * @return
     */
    private int binarySearch(int[] aux,int target){
        int left = 0;
        int right = aux.length-1;
        while(left <= right){
            int middle = (left + right)>>1;
            if(aux[middle] > target){
                right = middle - 1;
            }else if(aux[middle] < target){
                left = middle + 1;
            }else{
                return middle;
            }
        }
        return right;
    }

    /**
     * 对应的整数转换成数组
     * @param num
     * @return
     */
    private String toRoman(int num){
        switch (num){
            case 1:    return "I";
            case 4:    return "IV";
            case 5:    return "V";
            case 9:    return "IX";
            case 10:   return "X";
            case 40:   return  "XL";
            case 50:   return "L";
            case 90:   return "XC";
            case 100:  return "C";
            case 400:  return "CD";
            case 500:  return "D";
            case 900:  return "CM";
            case 1000: return "M";
            default:return "";
        }
    }
}
