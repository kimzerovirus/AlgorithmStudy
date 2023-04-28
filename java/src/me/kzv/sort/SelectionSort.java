package me.kzv.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] A = new int[]{1, 5, 2, 3, 4};

        print(selection(A));
    }

    static void print(int[] A){
        for (int i : A) {
            System.out.print(i + ", ");
        }
    }

    static int[] selection(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int Minimum = i; // 순회를 돌면서 가장 작은 값을 담을 변수

            // 맨 앞은 정렬된 부분이므로 하나씩 뒤로 정렬범위를 좁힌다
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[Minimum]) Minimum = j;
            }

            if (A[i] > A[Minimum]) {
                int temp = A[i];
                A[i] = A[Minimum];
                A[Minimum] = temp;
            }
        }

        return A;
    }
}
