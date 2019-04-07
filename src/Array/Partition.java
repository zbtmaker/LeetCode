package Array;

import java.util.Arrays;

/**
 * 给定一个pivot，以及一个数组。现在我们要将数组中小于等于pivot的元素放到pivot的左边，
 * 而大于pivot的元素都放到pivot的右边。下面我们提供两种方法，第一种是使用两个指针都在同一边的partitionI,
 * 另一个是两个指针在数组的两侧，然后向中间靠拢的的partitionII
 * Created by Administrator on 2019\2\19 0019.
 */
public class Partition {
    public static void main(String[] args){
        int[] arr = new int[]{7,6,5,4,3,2,1};
        new Partition().partitionII(arr,3);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * partitionI主要是利用两个指针来实现，small这个指针表示数组arr中小鱼pivot的最左侧位置。
     * 而i这个指针用来遍历这个数组。其中如果arr[i] > small,那么将i ++ 就可以了，什么操作都不用；
     * 如果arr[i] <= small, 那么我们将arr[small]下一个元素arr[++small] 与 arr[i]进行交换。
     * 此时small在交换之前就已经扩大了小于pivot的范围，循环结束的条件就是i<arr.length。
     * @param arr
     * @param pivot
     */
    public void partitionI(int[] arr,int pivot){
        int small = -1;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] <= pivot){
                swap(arr,++small,i);
            }
        }
    }
    private void swap(int[] arr,int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 这是《Algorithm》一书中的方法，使用两个指针,分别是left和right。left指向arr的0位置，
     * 而right指向arr.length-1处。两个指针同时走，left一旦遇到arr[left] > pivot,就停下来；
     * 而right如果满足arr[right]<pivot,也停下来，这样如果此时的left< right,那么就执行swap(arr,left,right);
     * 循环结束条件是left< right;
     *
     * @param arr
     * @param pivot
     */
    public void partitionII(int[] arr,int pivot){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            while(left<arr.length && arr[left] <= pivot){
                left ++;
            }
            while(right>-1 && arr[right] > pivot){
                right -- ;
            }
            if(left >= right){
                break;
            }
            swap(arr,left,right);
        }

    }
}
