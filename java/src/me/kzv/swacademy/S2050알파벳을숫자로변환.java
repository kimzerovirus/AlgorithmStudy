package me.kzv.swacademy;

import java.util.Scanner;

public class S2050알파벳을숫자로변환 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        char[] alphabets = sc.nextLine().toCharArray();

        for (char alphabet : alphabets) {
            sb.append((int) alphabet - 64).append(" ");
        }
        System.out.print(sb);
    }
}
