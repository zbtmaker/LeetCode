package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 上升的三元组序列--这个题和之前的题目最长上升序列是一样的
 * @author zoubaitao
 * date 2019/12/29
 */
public class IncreasingTriplet {
    /**
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        return increasingTripletByBinarySearch(nums);
    }

    /**
     * 这个题目和LengthOfLIS是一个类型的题目，所以首先会采用Dynamic Programming方式来
     * 做
     *
     * @param nums
     * @return
     */
    private boolean increasingTripletByDp(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] aux = new int[nums.length];
        Arrays.fill(aux, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j > -1; j--) {
                if (nums[i] > nums[j]) {
                    aux[i] = aux[j] + 1;
                    if (aux[i] >= 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 维护一个算法
     *
     * @param nums
     * @return
     */
    private boolean increasingTripletByBinarySearch(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        List<Integer> aux = new ArrayList<>();
        aux.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            insertToList(nums[i], aux);
            if (aux.size() >= 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * 功能：找出aux链表中刚好大于num的与元素的位置index,如果num > aux.get(index),则aux.set(index + 1,num)
     * 如果num < aux.get(index),则aux.set(index,num)
     * 那么直接将aux中index位置的元素替换为num,如果index超出了aux的索引，那么直
     * 接添加到aux当中。
     *
     * @param num 判断是否需要插入的数据
     * @param aux 插入的目标链表
     */
    private void insertToList(int num, List<Integer> aux) {
        int high = aux.size() - 1;
        if (num == aux.get(high)) {
            return;
        }
        if (num > aux.get(high)) {
            aux.add(num);
            return;
        }
        int low = 0;
        int mid = (low + high) >> 1;
        while (low < high) {
            if (num < aux.get(mid)) {
                high = mid - 1;
            } else if (num > aux.get(mid)) {
                low = mid + 1;
            } else {
                return;
            }
            mid = (low + high) >> 1;
        }
        if (aux.get(low) < num) {
            aux.set(low + 1, num);
        } else {
            aux.set(low, num);
        }
    }
}
