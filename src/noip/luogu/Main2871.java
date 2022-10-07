package noip.luogu;

import java.util.Scanner;

/**
 * @author zoubaitao
 * date 2022/10/03
 */
public class Main2871 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        int[][] herbs = new int[N][2];
        for (int i = 0; i < N; i++) {
            s = scanner.nextLine();
            arr = s.split(" ");
            herbs[i][0] = Integer.parseInt(arr[0]);
            herbs[i][1] = Integer.parseInt(arr[1]);
        }
        scanner.close();
        System.out.println(knapsackByBottomUpMemorization(herbs, M));
    }

    private static int knapsackByBottomUpMemorization(int[][] A, int L) {
        int[] cur = new int[L + 1];
        int[] last = new int[L + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= L; j++) {
                if (j < A[i - 1][0]) {
                    cur[j] = last[j];
                } else {
                    cur[j] = Math.max(last[j], last[j - A[i - 1][0]] + A[i - 1][1]);
                }
            }
            for (int k = 0; k <= L; k++) {
                last[k] = cur[k];
                cur[k] = 0;
            }
        }
        return last[L];
    }
}
