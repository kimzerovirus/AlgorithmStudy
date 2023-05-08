package me.kzv.algorithm.sort;

import java.util.Arrays;

/**
 * 선택정렬 - 정렬 안된 부분 중에서 가장 작은걸 선택해서 맨 앞으로 보낸다.
 *
 * 진행함에 따라 앞 부분은 정렬된 상태가 된다.
 * j = i ~ arr.length
 *
 *  o(N^2)
 * */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 6, 4, 3, 9, 5, 8, 2, 7, 1};

        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int temp, index = 0;
            for (int j = i; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        System.out.println(Arrays.toString(arr));
        // 시간 복잡도를 게산해보자
        // 10 + 9 + 8 + ... + 1
        // 10 * (10 + 1) / 2 = 55
        // N * (N + 1) / 2
        // O(N^2)
    }
}
