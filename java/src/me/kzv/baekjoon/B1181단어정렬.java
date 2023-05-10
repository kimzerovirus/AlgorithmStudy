package me.kzv.baekjoon;

import java.util.*;

public class B1181단어정렬 {

    public static void main(String[] args) {
        // 1. 길이가 짧은 것분터
        // 2. 길이가 같으면 사전 순
        // 3. 1 <= N <= 20000

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] arr = new String[N];

        sc.nextLine();    // 개행 버림

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
        }

        Arrays.sort(arr, (String s1, String s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2); // 사전순으로 정렬
            } else {
                return s1.length() - s2.length();
            }
        });

        System.out.println(arr[0]);
        for (int i = 1; i < N; i++) {
            // 중복되지 않는 단어만 출력
            if (!arr[i].equals(arr[i - 1])) {
                if(i != N -1) System.out.println(arr[i]);
                else System.out.print(arr[i]);
            }
        }
    }
}

