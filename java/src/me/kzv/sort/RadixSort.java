package me.kzv.sort;

public class RadixSort {
    public static void main(String[] args) {
        int[] A = new int[]{1, 5, 2, 3, 4};

        print(radix(A, A.length));
    }

    static void print(int[] A){
        for (int i : A) {
            System.out.print(i + ", ");
        }
    }

    static int[] radix(int[] A, int max_size) {
        int[] result = new int[A.length];
        int digit = 1;
        int count = 0;

        while (count != max_size) { // 최대 개수까지 반복
            int[] bucket = new int[10];

            for (int i = 0; i < A.length; i++) {
                bucket[(A[i] / digit) % 10]++; // 일의 자리부터 시작
            }

            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1]; // 합 배열을 이용해 index 계산
            }

            for (int i = A.length - 1; i >= 0; i--) { // 현재 자릿수 기준으로 정렬
                result[bucket[(A[i] / digit) % 10] - 1] = A[i];
                bucket[(A[i] / digit) % 10]--;
            }

            for (int i = 0; i < A.length; i++) {
                A[i] = result[i];
            }

            digit = digit * 10;
            count++;
        }

        return result;
    }
}
