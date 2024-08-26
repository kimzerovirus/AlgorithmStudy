package me.kzv.swacademy;

import java.util.Scanner;

public class S2072홀수만더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int idx = 0, sum = 0;

        while (idx < n) {
            for (int i = 0; i < 10; i++) {
                int num = sc.nextInt();
                if(num % 2 == 1) sum += num;
            }

            sb.append("#").append(++idx).append(" ").append(sum).append("\n");
            sum = 0;
        }

        System.out.println(sb);
    }
}
