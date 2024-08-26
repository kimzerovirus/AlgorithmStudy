package me.kzv.swacademy;

import java.util.Scanner;

public class S1926간단한369 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            String answer = "";
            String num = String.valueOf(i);

            int cnt = 0;
            for (char c : num.toCharArray()) if (c == '3' || c == '6' || c == '9') cnt++;

            if (cnt == 0) answer = num;
            else for (int e = 0; e < cnt; e++) answer += "-";

            sb.append(answer).append(" ");
        }
        System.out.println(sb);
    }
}
