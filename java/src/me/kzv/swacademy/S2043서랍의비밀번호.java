package me.kzv.swacademy;

import java.util.Scanner;

public class S2043서랍의비밀번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(Math.abs(n - m) + 1);
    }
}
