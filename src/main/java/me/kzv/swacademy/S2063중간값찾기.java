package me.kzv.swacademy;

import java.util.Arrays;
import java.util.Scanner;

public class S2063중간값찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(arr[arr.length / 2]);
    }
}
