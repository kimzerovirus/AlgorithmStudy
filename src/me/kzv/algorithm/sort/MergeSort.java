package me.kzv.algorithm.sort;

import java.util.Arrays;

/**
 * 병합정렬 - 분할 정복으로 반씩 잘라나가는거
 * <p>
 * 퀵정렬과 달리 o(N * logN)을 보장한다
 */
public class MergeSort {
    static int[] sorted;

    public static void main(String[] args) {
        int[] arr = new int[]{10, 6, 4, 3, 9, 5, 8, 2, 7, 1};
        sorted = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    static void merge(int a[], int left, int middle, int right) {
        int i, j, k;
        i = left;
        j = middle + 1;
        k = left;

        /* 작은 순서대로 배열에 삽입 */
        while (i <= middle && j <= right) {
            if (a[i] <= a[j])
                sorted[k++] = a[i++];
            else
                sorted[k++] = a[j++];
        }

        // 남아 있는 데이터도 삽입
        if (i > middle) {
            for (int t = j; t <= right; t++)
                sorted[k++] = a[t];
        } else {
            for (int t = i; t <= middle; t++)
                sorted[k++] = a[t];
        }

        // 정렬된 배열을 실제 배열에 삽입
        for (int t = left; t <= right; t++) {
            a[t] = sorted[t];
        }
    }

    static void mergeSort(int a[], int left, int right) {
        // 크기가 1보다 큰 경우
        if (left < right) {
            int middle = (left + right) / 2; // 가운데 기준
            mergeSort(a, left, middle); // 왼쪽 정렬
            mergeSort(a, middle + 1, right); // 오른쪽 정렬
            merge(a, left, middle, right); //합치기
        }
    }
}
