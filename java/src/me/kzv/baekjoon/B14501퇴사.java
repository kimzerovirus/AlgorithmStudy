package me.kzv.baekjoon;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B14501퇴사 {
    static int N;
    static int[][] arr;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N][2];

        pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int T = 0; T < N; T++) {
            arr[T][0] = sc.nextInt(); // day
            arr[T][1] = sc.nextInt(); // pay
        }

        go(0, 0);

        System.out.println(pq.peek());
    }

    static void go(int day, int pay) {
        if (day > N) {
            return;
        }
        pq.add(pay);

        for (int i = day; i < N; i++) {
            go(i + arr[i][0], pay + arr[i][1]);
        }
    }
}
