package backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019\2\5 0005.
 */
public class RestoreIpAddresses93 {
    @Test
    public void test(){
        String s = "010010";
        List<String> list = restoreIpAddresses(s);
        for(String string : list){
            System.out.println(string);
        }

    }

    /**
     * 规则一：任何一位置的八进制不能超过255，也就是必须小于256
     * 规则二:如果一个点分十进制是由零开头的，那么此时该电分十进制只能是一个零，不能出现00的情况，
     *        具体例子010010，从这个例子的输出{0.10.0.10 , 0.100.1.0}这里的以零开头的点分十进制长度为 1
     *
     * 根据上面的两个规则：我们在每次递归的时候需要对下面两个条件进行判断
     *
     * 条件一: s.charAt(index) == '0' && j == index，这个条件表示如果这个点分十进制从零开始的，那么此时我们不需要循环判断3次
     *        只需要判断当前位置就可以了，如：0.1.0.10(0.1.00.10),这种情况是不可以的，因此我们
     * 条件二: s.charAt(index) != '0' && num<256,如果我们的点分十进制的首位不是'0',那么此时我们将判断这个点分十进制是否超过了255
     *        如果超过了255,那么这个dot就是无效的，也就是我们不需要往下进行递归。
     * 具体的流程：对于每一个点分十进制最多只有三位，因此我们从每一个开始位，我们将开始位标记为index，循环三次，也就是循环到index+2。
     *            在每次循环的过程中我们需要判断我们的值是否超越了数组边界，如果超越了，则退出循环（此种情况主要是针对那种比较短的
     *            字符串）。我们在每次往下递归的时候，需要记录我们已经打好的点dot，以及这些dot都在什么位置，其中dot的数量用count记录
     *            而dot的位置，我们采用数组来记录dot[]。
     *            对于一个回溯算法，涉及到递归的停止条件，以及递归范式和恢复现场三部分（当然还有返回值）。
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        if(s.length() <4 || s.length() >12){
            return list;
        }
        int[] dot = new int[3];//用于记录dot的位置，一个IPV4地址，有三个dot
        recurRestoreIpAddresses(s,0,0,dot,list);
        return list;
    }

    /**
     *
     * @param s
     * @param index 表示下一个点分十进制的初始位置
     * @param count 表示已经标记的dot的数量
     * @param dot 用来记录dot的位置
     * @param list 用来记录存储有效地IP地址
     */
    private void recurRestoreIpAddresses(String s,int index,int count,
                                         int[] dot,List<String> list){
        if(count == 3){
            int num = Integer.parseInt(s.substring(index,s.length()));
            if((s.charAt(index) == '0' && index == s.length()-1)||
                    (s.charAt(index) != '0' && num<256)){
                list.add(splice(s,dot));
                return;
            }else{
                return;
            }
        }else if(index == s.length()){
            return;
        }
        for(int j = index;j < s.length()-1 && j < index + 3;j++){
            int num = Integer.parseInt(s.substring(index,j+1));
            if((s.charAt(index) == '0' && j == index)||
                    (s.charAt(index) != '0' && num<256)){
                dot[count] = j;
                count ++;
                recurRestoreIpAddresses(s,j + 1,count,dot,list);
                count --;
                dot[count] = 0;
            }
        }
    }

    /**
     * 根据String和dot数组将String转换成一个IP地址
     * @param s
     * @param dot
     * @return
     */
    private String splice(String s,int[] dot){
        StringBuilder sb = new StringBuilder(s.length() + 3);

        for(int k = 0;k<=dot.length;k++){
            if(k == 0){
                sb.append(Integer.parseInt(s.substring(0,dot[0]+1)));
                sb.append(".");
            }else if(k == dot.length){
                sb.append(Integer.parseInt(s.substring(dot[k-1]+1)));
            }else{
                sb.append(Integer.parseInt(s.substring(dot[k-1]+1,dot[k]+1)));
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
