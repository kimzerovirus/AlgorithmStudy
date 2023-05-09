package me.kzv.algorithm.sort;

import java.util.Arrays;

/**
 * 계수정렬 - 크기를 기준으로 갯수를 세서 구함, 누적합 배열 이용
 *
 * 범위조건이 있는 경우에만 사용 가능
 * 범위가 커지면 차지하는 용량이 커질 수 있음
 * o(N)
 */
public class CountingSort {

    static int[] count = new int[5];
    static int[] arr = new int[]{
            1, 5, 4, 2, 3, 4, 1, 5, 3, 3, 1, 5, 2, 3, 4, 5, 1, 5, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 3, 2, 1, 2, 3
    };

    public static void main(String[] args) {
        for (int i : arr) {
            count[i - 1]++;
        }

        int temp = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = temp; j < temp + count[i]; j++) {
                arr[j] = i + 1;
            }
            temp += count[i];
        }

        System.out.println(Arrays.toString(arr));
    }
}
