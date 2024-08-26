package me.kzv.swacademy;

import java.util.Scanner;

public class S2069최대수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int idx = 0;

        while (idx < n) {
            int num = 0;
            for (int i = 0; i < 10; i++) {
                int newNum = sc.nextInt();
                if(num - newNum < 0) num = newNum;
            }

            sb.append("#").append(++idx).append(" ").append(num).append("\n");
        }

        System.out.println(sb);
    }
}
