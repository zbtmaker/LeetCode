package noip.luogu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zoubaitao
 * date 2022/10/03
 */
public class Main1616 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(" ");
        int W = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int[] w = new int[m];
        int[] v = new int[m];
        for (int i = 0; i < m; i++) {
            s = scanner.nextLine();
            arr = s.split(" ");
            w[i] = Integer.parseInt(arr[0]);
            v[i] = Integer.parseInt(arr[1]);
        }
        System.out.println(bottomUp(W, w, v));
    }

    private static int dfsMemorize(int W, int[] w, int[] v) {
        int[] F = new int[W + 1];
        Arrays.fill(F, -1);
        F[0] = 0;
        return dfs(W, w, v, F);

    }

    private static int dfs(int W, int[] w, int[] v, int[] F) {
        if (F[W] != -1) {
            return F[W];
        }
        int max = 0;
        for (int i = 0; i < w.length; i++) {
            if (W >= w[i]) {
                int cur = dfs(W - w[i], w, v, F) + v[i];
                max = Math.max(cur, max);
            }
        }
        F[W] = max;
        return max;
    }

    private static long bottomUp(int W, int[] w, int[] v) {
        long[] F = new long[W + 1];
        for (int i = 1; i <= W; i++) {
            long max = 0;
            for (int j = 0; j < w.length; j++) {
                if (i >= w[j]) {
                    max = Math.max(max, F[i - w[j]] + v[j]);
                }
            }
            F[i] = max;
        }
        return F[W];
    }
}
