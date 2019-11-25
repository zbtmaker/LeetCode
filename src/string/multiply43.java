package string;

/**
 * Created by Administrator on 2019\2\21 0021.
 */
public class multiply43 {
    public static void main(String[] args){
        String num1 = "9113";
        String num2 = "0";

        System.out.println(new multiply43().multiply(num1,num2));
    }

    /**
     * 字符串相乘主要的思想是num1、num2,然后将num1的每一位和num2进行相乘，得到的结果然后进行一个累加就可以了
     * 例子：123 * 456，首先将123 和 456中的 3 和456进行相乘并将结果存在StringBuilder当中，使用append方法
     * 只能讲字符存在StringBuilder的后面，那么我们求得的结果为8631（实际应为1368），得到的结果不用在结尾处添加零，然后是在2和456和进行相乘
     * 然后还需要在前面添加 num1.length() - 1 -i 个0，因此在每次字符和字符串执行相乘操作的时候还需首先在StringBuilder中
     * 插入相应的零位。然后再执行两个字符串相加操作。
     * 注意事项：如果num1中某一位为0，那么这一位可以直接跳过。如果num1或者num2的第零位为0，那么我们可以直接返回0
     * 如：999*000，的情况
     * 需要注意的是我们需要
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null ||
                num1.charAt(0) == '0' || num2.charAt(0) == '0'){
            return "0";
        }
        String sum = "0";
        for(int i = num1.length() -1;i > -1;i--){
            if(num1.charAt(i) != '0'){
                String tmp = multiply(num1.charAt(i),num2,num1.length() - 1 -i);
                sum = addString(sum,tmp);
            }
        }
        return inverse(sum);
    }
    private String multiply(char ch,String num,int len){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<len;i++){
            sb.append(0);
        }
        int n = ch - '0';
        int mul = 0;
        int basic = 0;
        int carry = 0;
        for(int i = num.length() - 1;i > -1;i--){
            mul = n * (num.charAt(i) - '0') + carry;
            basic = mul % 10;
            carry = mul / 10;
            sb.append(basic);
        }
        if(carry != 0){
            sb.append(carry);
        }
        return sb.toString();
    }
    private String addString(String num1,String num2){
        int i1 = 0;
        int i2 = 0;

        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int basic = 0;
        int carry = 0;

        while(i1 < num1.length() && i2 < num2.length()){
            sum = (num1.charAt(i1 ++)-'0') + (num2.charAt(i2 ++) -'0') + carry;
            basic = sum % 10;
            carry = sum / 10;
            sb.append(basic);

        }
        while(i1 < num1.length()){
            sum = (num1.charAt(i1 ++)-'0') + carry;
            basic = sum % 10;
            carry = sum / 10;
            sb.append(basic);
        }
        while(i2 < num2.length()){
            sum = (num2.charAt(i2 ++)-'0') + carry;
            basic = sum % 10;
            carry = sum / 10;
            sb.append(basic);
        }
        if(carry != 0){
            sb.append(carry);
        }
        return sb.toString();
    }

    private String inverse(String str){
        char[] chs = str.toCharArray();
        int i = 0;
        int j = chs.length-1;
        while(i<j){
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
        return new String(chs);
    }
}
