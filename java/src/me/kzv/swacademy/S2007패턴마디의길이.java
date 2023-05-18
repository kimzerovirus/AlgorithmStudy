package me.kzv.swacademy;

import java.util.Scanner;

public class S2007패턴마디의길이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        int idx = 0;

        sc.nextLine();
        while (idx < T) {
            String str = sc.nextLine();

            for (int i = 1; i < str.length() / 2; i++) {
                if (str.substring(i, 2 * i).equals(str.substring(0, i))) {
                    sb.append("#").append(++idx).append(" ").append(i).append("\n");
                    break;
                }
            }

        }

        System.out.println(sb);
    }
}



