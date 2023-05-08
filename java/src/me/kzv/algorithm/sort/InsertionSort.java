package me.kzv.algorithm.sort;

import java.util.Arrays;

/**
 * 삽입정렬 - 각 숫자를 적절한 위치에 삽입하는 정렬
 *
 *  버블 정렬이나 선택정렬은 끝까지 반복문이 무조건 다 돌기 때문에 느리지만
 *  삽입정렬은 선택요소의 왼쪽이 항상 정렬되어 있기 때문에 선택요소와 왼쪽 요소 비교후 자신보다 작다면 이동을 멈추면 되므로 조금은 더 빠르다
 *  다만 그래봤자 o(N^2)
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 6, 4, 3, 9, 5, 8, 2, 7, 1};

        for (int i = 0; i < arr.length - 1; i++) {
            int temp, j = i;
            while (j >= 0 && arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
