package me.kzv.swacademy;

import java.util.Scanner;

public class S1936가위바위보 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if(n == 1 && m == 3) System.out.println("A");
        else if(n == 2 && m == 1) System.out.println("A");
        else if(n == 3 && m == 2) System.out.println("A");
        else System.out.println("B");
    }
}
