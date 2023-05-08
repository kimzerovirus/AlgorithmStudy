package me.kzv.baekjoon;

import java.util.Scanner;

public class B2750수정렬하기 {
    static int[] arr = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int idx = 0;
        while (sc.hasNext()) {
            arr[idx++] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0, temp;
            for (int j = i; j < n; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
