package me.kzv.swacademy;

import java.util.Scanner;

public class S2070큰놈작은놈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int idx = 0;
        while (idx < n) {
            String buho;
            int num = sc.nextInt() - sc.nextInt();
            if(num > 0){
                buho = ">";
            } else if (num < 0) {
                buho = "<";
            } else {
                buho = "=";
            }

            sb.append("#").append(++idx).append(" ").append(buho).append("\n");
        }

        System.out.println(sb);
    }
}
