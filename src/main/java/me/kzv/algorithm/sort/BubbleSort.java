package me.kzv.algorithm.sort;

import java.util.Arrays;

/**
 * 버블정렬 - 옆에 있는 값과 비교해서 더 작은 값을 앞으로 보내는 정렬
 * <p>
 * 진행함에 따라 뒷부분이 정렬된다.
 * j = 0 ~ arr.length - (i + 1) 까지 -> 한번에 두개의 요소를 선택해야하므로 i + 1 개를 빼줘야함
 *
 * o(N^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 6, 4, 3, 9, 5, 8, 2, 7, 1};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - (i + 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
