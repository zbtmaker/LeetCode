package BackTracking;

/**
 * Created by Administrator on 2019\3\6 0006.
 */
public class numDecodings91 {
    public static void main(String[] args){
        String s = "12101";
        int count = new numDecodings91().numDecodings(s);
        System.out.println(count);

    }
    /**
     * 这个题目使用回溯的方式来解决，对于任意一个位置，要么取一位，要么取两位。
     * 同时，如果去两位不成，那么直接返回，取一位的时候如果发现这个位是零，那么发现实行不通的则返回。
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int[] count = new int[]{0};
        recurNumDecodings(s,0,count);
        return count[0];
    }

    private void recurNumDecodings(String s,int index,int[] count){
        if(index >= s.length()){
            count[0] += 1;
            return ;
        }

        //caseI 每一个位置取1位

        int num1 = s.charAt(index) - '0';
        if(num1 < 1 || num1 > 26){
            return;
        }
        recurNumDecodings(s,index + 1,count);

        //caseII 每一个位置取两位
        if(index + 1 >= s.length()){
            return;
        }
        int num2 = Integer.parseInt(s.substring(index,index + 2));
        if(num2 < 1 || num2 > 26){
            return;
        }
        recurNumDecodings(s,index+ 2,count);
    }

    /**
     * 因为只要求得解码的总数，因此我统计了一下模式，最后发现可以用动态规划的
     * 的方式求解，最后将时间复杂度变为O(1)、空间复杂度变为O(N)。也就是使用
     * 空间换时间的方法，将时间缩小为原来的很多倍。
     * 测试用例： 101
     * @param s
     * @return
     */
    public int numDecodingsII(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int len = s.length();
        int[] aux = new int[len];
        aux[0] = 1;
        for(int i = 1;i<len;i++){

            char ch = s.charAt(i);
            char last = s.charAt(i-1);
            if(last == '0'){
                if(ch == '0'){
                    return 0;
                }
                aux[i] = aux[i-1];
            }else{
                int num = Integer.parseInt(s.substring(i-1,i+1));
                if (ch == '0'){//此种情况是最难的以后解决
                    if(num < 27){
                        aux[i] = aux[i-1];
                    }else{
                        return 0;
                    }
                }else{
                    if(num > 26){
                        aux[i] = aux[i-1];
                    }else{
                        aux[i] = aux[i-1] + 1;
                    }

                }
            }

        }
        return aux[len-1];
    }
}
