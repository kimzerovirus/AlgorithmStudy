package me.kzv.baekjoon;

import java.util.Scanner;
import java.util.Arrays;

/**
 * 이분탐색
 */
public class B1920수찾기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];


        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 배열은 반드시 정렬되어있어야한다.
        Arrays.sort(arr);

        int M = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            // 찾고자 하는 값이 있을 경우 1, 없을 경우 0을 출력해야한다.
            if (binarySearch(arr, sc.nextInt()) >= 0) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }


    /**
     * @param arr 정렬 된 배열
     * @param key 찾으려는 값
     * @return key와 일치하는 배열의 인덱스
     */
    public static int binarySearch(int[] arr, int key) {

        int start = 0;               // 탐색 범위의 왼쪽 끝 인덱스
        int end = arr.length - 1;    // 탐색 범위의 오른쪽 끝 인덱스

        while (start <= end) {              // start 가 end 보다 커지기 전까지 반복한다.
            int mid = (start + end) / 2;    // 중간위치를 구한다.

            if (key < arr[mid]) { // key 값이 중간 위치의 값보다 작을 경우
                end = mid - 1;
            } else if (key > arr[mid]) { // key 값이 중간 위치의 값보다 클 경우
                start = mid + 1;
            } else { // key 값과 중간 위치의 값이 같을 경우
                return mid;
            }
        }

        return -1;
    }
}