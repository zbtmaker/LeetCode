package Array;

/**
 * Created by Administrator on 2019\1\19 0019.
 */
public class maxDistToClosest849 {
    public static void main(String[] args){
        int[] seats= new int[]{0};
        System.out.println(maxDistToClosest(seats));
    }
    public static int maxDistToClosest(int[] seats){
        int max = 0;
        for(int i = 0;i<seats.length;i++){
            if(seats[i] == 0){
                int left = i-1;
                int right = i+1;
                int distance = 1;
                if(i == 0){
                    while(right<seats.length){
                        if(seats[right] == 1){
                            break;
                        }
                        distance ++;
                        right++;
                    }
                }else if(i == seats.length-1){
                    while(left<seats.length){
                        if(seats[left] == 1){
                            break;
                        }
                        distance ++;
                        left--;
                    }
                }else{
                    while(left>=0 && right<seats.length){
                        if(seats[left] == 1 || seats[right] == 1){
                            break;
                        }
                        distance ++;
                        left--;
                        right++;
                    }
                }

                if(distance > max){
                    max = distance;
                }
            }
        }
        return max;
    }
}
