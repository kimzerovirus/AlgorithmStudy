package me.kzv.swacademy;

import java.util.Arrays;
import java.util.Scanner;

public class S1859백만장자프젝트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        int idx = 0;

        while (idx < T) {
            int N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

            long sum = 0;
            int max_value = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] > max_value) max_value = arr[i];
                else sum += max_value - arr[i];
            }

            sb.append("#").append(++idx).append(" ").append(sum).append("\n");
        }

        System.out.println(sb);
    }

//    void solution2(){
//        Scanner sc = new Scanner(System.in);
//        StringBuilder sb = new StringBuilder();
//
//        int T = sc.nextInt();
//        int idx = 0;
//
//        while (idx < T) {
//            long sum = 0;
//            int N = sc.nextInt();
//            Integer[] arr = new Integer[N];
//            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
//            Integer[] arr2 = arr.clone();
//            Arrays.sort(arr2, (a, b) -> b - a);
//            int temp = 0, j = 0, k = 0;
//            for (int i = 0; i < N; i++) {
//                if(arr[i].equals(arr2[k]) && temp != 0){
//                    sum += (long) j * arr2[k] - temp;
//                    k++;
//                    temp = 0;
//                    j = 0;
//                } else {
//                    j++;
//                    temp += arr[i];
//                }
//            }
//
//            sb.append("#").append(++idx).append(" ").append(sum).append("\n");
//        }
//        System.out.println(sb);
//    }
}



