package me.kzv.algorithm;

import java.util.Random;
import java.util.Scanner;

// 주어진 자료구조를 순차적으로 이동해가며 연산 수행 -> 슬라이딩
// 배열의 부분합 구하기
public class SlidingWindow {
    // Q. 크기가 N인 배열에 크기가 K인 연속된 부분 합 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = r.nextInt(30);
        }

//        for (int i = 0; i < N - K; i++) {
//            int sum = 0;
//            for (int j = 0; j < K; j++) {
//                sum += arr[i + j];
//            }
//            System.out.println(sum);
//        }

        int sum = 0, cnt = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            cnt++;
            if (cnt >= K) {
                System.out.println(i + " : " + sum);
                sum -= arr[i - K + 1]; // 선택한 부분집합의 가장 앞의 값을 빼고 다음 값을 더하는 창문을 미는듯한 방법을 취한다.
            }
        }
    }
}
