package array;

/**
 * Created by Administrator on 2019\1\18 0018.
 */
public class isOneBitCharacter717 {
    public static void main(String[] args){
        int[] bits = new int[]{1,0,0};
        System.out.println(isOneBitCharacter(bits));
    }
    public static boolean isOneBitCharacter(int[] bits){
        boolean flag = false;
        int i = 0;
        while(i<bits.length){
            if(i == bits.length-1){
                flag = true;
                i++;
            }
            else if(bits[i] == 1){
                i += 2;
            }else{
                i++;
            }
        }
        return flag;
    }
}
