package noip.luogu;

import dp.MultiKnapsack;

import java.util.Scanner;

/**
 * @author zoubaitao
 * date 2022/10/03
 */
public class Main1776 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(" ");
        int m = Integer.parseInt(arr[0]);
        int W = Integer.parseInt(arr[1]);
        int[] w = new int[m];
        int[] v = new int[m];
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            s = scanner.nextLine();
            arr = s.split(" ");
            v[i] = Integer.parseInt(arr[0]);
            w[i] = Integer.parseInt(arr[1]);
            nums[i] = Integer.parseInt(arr[2]);
        }
        MultiKnapsack knapsack = new MultiKnapsack();
        System.out.println(knapsack.multiKnapsack(W, w, v, nums));
    }
}
