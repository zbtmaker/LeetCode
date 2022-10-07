package noip.luogu;

import java.util.Scanner;

/**
 * @author zoubaitao
 * date 2022/10/03
 */
public class Main1048 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(" ");
        int T = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        int[][] herbs = new int[M][2];
        for (int i = 0; i < M; i++) {
            s = scanner.nextLine();
            arr = s.split(" ");
            herbs[i][0] = Integer.parseInt(arr[0]);
            herbs[i][1] = Integer.parseInt(arr[1]);
        }
        System.out.println(catchHerbs(herbs, T));
    }

    private static int catchHerbs(int[][] arr, int T) {
        int[][] F = new int[arr.length + 1][T + 1];
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= T; j++) {
                F[i][j] = -1;
            }
        }
        return knapsackByTopDownMemorization(T, arr, arr.length, F);
    }

    private static int knapsackByTopDownMemorization(int L, int[][] arr, int n, int[][] F) {
        if (n == 0) {
            return 0;
        }
        if (F[n][L] >= 0) {
            return F[n][L];
        }
        if (L < arr[n - 1][0]) {
            F[n][L] = knapsackByTopDownMemorization(L, arr, n - 1, F);

        } else {
            F[n][L] = Math.max(knapsackByTopDownMemorization(L, arr, n - 1, F), knapsackByTopDownMemorization(L - arr[n - 1][0], arr, n - 1, F) + arr[n - 1][1]);
        }
        return F[n][L];
    }

}
