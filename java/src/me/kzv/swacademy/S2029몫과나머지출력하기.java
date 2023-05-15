package me.kzv.swacademy;

import java.util.Scanner;

public class S2029몫과나머지출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int idx = 0;

        while (idx < n) {
            int l = sc.nextInt();
            int k = sc.nextInt();
            int quotient = l / k;
            int remainder = l % k;

            sb.append("#").append(++idx).append(" ").append(quotient).append(" ").append(remainder).append("\n");
        }

        System.out.println(sb);
    }
}
