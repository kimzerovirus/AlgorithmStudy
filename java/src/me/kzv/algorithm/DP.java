package me.kzv.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 동적 프로그래밍
 *
 * 하나의 문제를 단 한번만 풀도록 하는 알고리즘
 * 1. 규칙성을 세워 점화식을 만든다.
 * 2. 메모이제이션을 통해 이전 연산결과를 정한것을 바탕으로 현재 위치에서의 연산을 진행한 후 다시 메모하는 것을 반복
 * 즉, 동적계획법은 일반화를 통해 점화식을 찾고, 메모이제이션을 이용해서 연산을 반복해서 수행하는 과정이다.
 */
public class DP {
    public static void main(String[] args) {
        System.out.println("=====================");
        fibonacci();

        System.out.println("=====================");
        System.out.println(fibonacci2(10));

        System.out.println("=====================");
        q1_with_back_tracking();

        System.out.println("=====================");
        q1_with_dp();
    }

    // 피보나치 수열 점화식
    static void fibonacci() {
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        System.out.println(Arrays.toString(arr));
    }

    // 재귀 이용 - 메모이제이션을 안하면 2^n 의 시간이 걸린다
    // o(n)
    static int[] d = new int[100];
    static int fibonacci2(int x){
        System.out.println(x);
        if(x == 1) return 1;
        if(x == 2) return 1;
        if(d[x] != 0) return d[x];
        System.out.println();
        return d[x] = fibonacci2(x - 1) + fibonacci2(x - 2);
    }

    // LIS 최장 증가 수열
    static int[] arr1 = {10, 20, 10, 30, 20, 50};

    static void q1_with_back_tracking() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            int location = i;
            int value = arr1[i];
            list.add(value);
            btr(location, value, list);
            list.remove(list.size() - 1);
        }
    }

    private static void btr(int location, int value, ArrayList<Integer> list) {
        if (location == arr1.length - 1) {
            System.out.println(list);
            return;
        }

        for (int i = location + 1; i < arr1.length; i++) {
            if (arr1[i] > value) {
                list.add(arr1[i]);
                btr(i, arr1[i], list);
                list.remove(list.size() - 1);
            }
        }
    }

    static void q1_with_dp() {
        int l = arr1.length;
        int[] dp = new int[l];

        for (int i = 0; i < l; i++) {
            dp[i] = 1;
            for (int j = 0; j < l; j++) {
                if (j < i) { // 자신보다 앞에 위치한
                    if (arr1[j] < arr1[i]) { // 자신보다 작은 값을 가진 항 중에서
                        dp[i] = Math.max(dp[i], dp[j] + 1); // 가장 큰 LIS 값 + 1
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
