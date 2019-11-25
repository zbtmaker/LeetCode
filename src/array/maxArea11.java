package array;

/**
 * Created by Administrator on 2019\1\10 0010.
 */
public class maxArea11 {
    public static void main(String[] args){
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int area = maxArea(height);
        System.out.println(area);
    }
    public static int maxArea(int[] height){
        int maxLeft = height[0];
        int maxIndex = 0;
        int max = 0;
        for(int i = 1; i<height.length;i++){
            for(int j = i-1;j>=0;j--){
                int area = (i-j)*Math.min(height[j],height[i]);
                if(area>max){
                    max = area;
                }
            }
        }
        return max;
    }
}
