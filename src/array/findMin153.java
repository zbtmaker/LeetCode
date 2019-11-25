package array;

/**
 * Created by Administrator on 2019\3\4 0004.
 */
public class findMin153 {
    public static void main(String[] args){
        int[] nums = new int[]{2,3,4,5,1};
        int min = new findMin153().findMin(nums);
        System.out.println(min);
    }
    /**
     * search33和这个题目相似，都是旋转数组。这个题目是找到旋转数组的最小值
     * 最小值的特点是当前索引满足nums[index-1]<num[index]<nums[index+1]
     * 如果index为0，此时没有旋转，也就是nums[index]<nums[index + 1]。如果
     * index为nums.length，那么这个时候就需要满足nums[index]<nums[index-1]
     *
     * 测试例子 A : [0,1,2,3,4,5,6,7]此时到达的最小值时nums[middle]<nums[middle]
     * 测试例子 B : [7,6,5,4,3,2,1,0]此时达到最小值时有nums[middle]<nums[middle-1]
     * 测试例子 C : [3,4,5,6,7,0,1,2]此例子用于判断是向左还是向右，同时最小值必须满足
     *              nums[middle-1]<nums[middle]< nums[middle+1]
     *              a. 如果nums[middle] > nums[left] && nums[middle] > nums[right]
     *              此时left = middle + 1 , right = right;      （例子：[3,4,5,6,7,0,1,2]）
     *              b. 如果nums[middle] > nums[left] && nums[middle] < nums[right]
     *              此时left = left , right = middle -1;        （例子：[0,1,2,3,4,5,6,7]）
     *              c. 如果nums[middle] < nums[left] && nums[middle] < nums[right]
     *              此时left = left , right = middle -1;
     *              d. 如果nums[middle] < nums[left] && nums[middle] > nums[right]
     *              此时left = middle + 1 ,right = right;       （例子：[7,6,5,4,3,2,1,0]）
     *
     * 测试例子 D : [1,2]此时在判断的时候会出问题
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int middle = (left + right) >> 1;
            if(middle -1 < 0 || middle + 1 <0){
                return nums[middle];
            }

            if(nums[middle]<nums[middle + 1] && nums[middle] < nums[middle -1]){
                return nums[middle];
            }

            if(nums[middle] > nums[left] && nums[middle] > nums[right]){
                left = middle + 1;
            }else if(nums[middle] > nums[left] && nums[middle] < nums[right]){
                right = middle-1;
            }else if(nums[middle] < nums[left] && nums[middle] < nums[right]){
                right = middle -1;
            }else if(nums[middle] < nums[left] && nums[middle] > nums[right]){
                left = middle + 1;
            }
        }
        return nums[left];
    }
}
