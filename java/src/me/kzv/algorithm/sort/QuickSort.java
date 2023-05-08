package me.kzv.algorithm.sort;

import java.util.Arrays;

/**
 * 퀵정렬 - 대표적인 분할 정복 알고리즘
 *
 *  최고 o(N * logN)
 *  최악 o(N^2) <- 이미 정렬되어 있거나 거의 다 정렬되어 있다면 이렇게 됨
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 6, 4, 3, 9, 6, 8, 2, 7, 1};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] data, int start, int end) {
        if (start >= end) { // 원소가 1개인 경우 그대로 두기
            return;
        }

        int key = start; // 키는 첫번째 원소
        int i = start + 1;
        int j = end;
        int temp;

        while (i <= j) {
            while (data[i] <= data[key]) { // 키 값보다 큰 값을 만날때까지
                i++;
            }
            while (j > start && data[j] >= data[key]) { // 키값보다 작은 값을 만날때까지
                j--;
            }
            if (i > j) { // 현재 엇갈린 상태면 키 값과 교체
                temp = data[j];
                data[j] = data[key];
                data[key] = temp;
            } else { // 엇갈리지 않았다면 i와 j를 교체
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        quickSort(data, start, j - 1);
        quickSort(data, j + 1, end);
    }
}
