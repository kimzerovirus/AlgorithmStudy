package me.kzv.swacademy;

import java.util.Scanner;

public class S2071평균값구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int idx = 0;
        float sum = 0;

        while (idx < n) {
            for (int i = 0; i < 10; i++) {
                sum += sc.nextInt();
            }

            sb.append("#").append(++idx).append(" ").append(Math.round(sum / 10)).append("\n");
            sum = 0;
        }

        System.out.println(sb);
    }
}
