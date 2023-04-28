package me.kzv.sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] A = new int[]{1, 5, 2, 3, 4};

        print(bubble(A));
//        ex1();
    }

    static int[] bubble(int[] A) {
        // 0 ~ 마지막 요소 전까지 순회
        for (int i = 0; i < A.length - 1; i++) {
            // i 번째 까지는 이미 순회를 맞쳐서 정렬 된 상태이므로 반복문에서 예외 시켜줌 따라서 순회 범위는 A.length - 1 - i
            for (int j = 0; j < A.length - 1 - i; j++) {
                // j 번째와 j+1번째의 요소가 크기 순이 아니면 교환
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    System.out.println("swap : " + A[j] + ", " + A[j + 1] + " -> " + A[j + 1] + ", " + A[j]);
                } else {
                    System.out.println(A[j] + ", " + A[j + 1]);
                }
            }
        }

        return A;
    }

    static void print(int[] A){
        for (int i : A) {
            System.out.print(i + ", ");
        }
    }

    static void ex1(){
        int N = 5;
        Random random = new Random();
        bData[] A = new bData[N];
        for (int i = 0; i < N; i++) {
            A[i] = new bData(random.nextInt(100), i);
        }

        Arrays.sort(A);
        int Max = 0;

        for (int i = 0; i < N; i++) {
            if (Max < A[i].index - i) {
                Max = A[i].index - i;
            }
            System.out.println(Max + 1);
        }
    }
}

class bData implements Comparable<bData> {
    int value;
    int index;

    public bData(int value, int index) {
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(bData o) {
        return this.value - o.value;
    }
}

