package array;

/**
 * Created by Administrator on 2019\1\18 0018.
 */
public class canPlaceFlowers605 {
    public static void main(String[] args){
        int[] flowerbed = new int[]{1,0,0,0,1};
        System.out.println(canPlaceFlowers(flowerbed,2));
    }
    public static boolean canPlaceFlowers(int[] flowerbed,int n){
        boolean flag = false;
        int count = 0;
        int i = 0;
        while(i<flowerbed.length){
            if(i == 0){
                if(flowerbed[i]+flowerbed[i+1] == 0){
                    flowerbed[i] = 1;
                    count ++;
                    if(count >= n){
                        flag = true;
                        break;
                    }
                    i += 2;
                }else{
                    i++;
                }
            }else if( i == flowerbed.length-1){
                if(flowerbed[i]+flowerbed[i-1] == 0){
                    count ++;
                    if(count >= n){
                        flag = true;
                        break;
                    }

                }
                i++;
            }else if(flowerbed[i-1] + flowerbed[i] + flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                count ++;
                if(count >= n){
                    flag = true;
                    break;
                }
                i += 2;
            }else{
                i++;
            }
        }
        return flag;
    }
}
