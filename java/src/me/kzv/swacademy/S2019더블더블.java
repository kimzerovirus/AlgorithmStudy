package me.kzv.swacademy;

import java.util.Scanner;

public class S2019더블더블 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dd(1, 0, n);
//        System.out.println(1 << n); // 비트연산으로 제곱 수 표현
    }

    static void dd(int num, int idx, int n) {
        System.out.print(num + " ");
        if (idx == n) return;
        dd(2 * num, ++idx, n);
    }
}
