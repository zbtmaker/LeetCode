package array;

/**
 * Created by Administrator on 2019\1\10 0010.
 */
public class FlipAndInvertImage832 {


    public void flipAndInvertImage(int[][] A) {
        for (int[] ints : A) {
            flipAdnInvertArray(ints);
        }
    }

    private void flipAdnInvertArray(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            arr[i] = arr[i] ^ 1;
            arr[j] = arr[j] ^ 1;
            i++;
            j--;
        }
        if (arr.length % 2 == 1) {
            int mid = arr.length >> 1;
            arr[mid] = arr[mid] ^ 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
