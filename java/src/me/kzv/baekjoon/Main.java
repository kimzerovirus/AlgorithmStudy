package me.kzv.baekjoon;

import java.util.*;

public class Main {
    static List<Integer>[] arr;
    static int r,c,k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < 3; i++) {
            arr[i] = new LinkedList();
            for (int j = 0; j < 3; j++) {
                arr[i].add(sc.nextInt());
            }
        }

        for (List list : arr) {

        }
    }
}