package me.kzv.baekjoon;

import java.util.*;

public class B13458시험감독 {
    // int 범위를 초과하는 입력값이 있음..
    private static long result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int B = sc.nextInt();
        int C = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int students = arr[i];

            students -= B;
            result += 1;
            if (students <= 0) continue;

            result += students / C;
            if (students % C > 0) result += 1;
        }

        System.out.println(result);
    }
}
