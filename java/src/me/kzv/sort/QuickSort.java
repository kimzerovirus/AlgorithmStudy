package me.kzv.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = new int[]{1, 5, 2, 3, 4};

        print(quick(A, 0, A.length - 1));
    }

    static void print(int[] A) {
        for (int i : A) {
            System.out.print(i + ", ");
        }
    }

    private static int[] quick(int[] A, int L, int R) {
        int left = L, right = R;
        int pivot = A[(L + R) / 2]; // 재귀 돌 때 마다 새로운 pivot 설정 (가운데)
        int temp;

        while (left <= right) { // left 가 right 보다 오른쪽에 있을 때까지 반복
            while (A[left] < pivot) { // left 가 pivot 보다 큰 값을 만나거나 pivot 을 만날 때까지
                left++;
            }
            while (A[right] > pivot) { // right 가 pivot 보다 작은 값을 만나거나 pivot 을 만날 때까지
                right--;
            }
            if (left <= right) { // left 가 right 보다 왼쪽에 있다면 교환
                temp = A[left];
                A[left] = A[right];
                A[right] = temp;

                // left 오른쪽으로 한칸, right 왼쪽으로 한칸 이동
                left++;
                right--;
            }
        }

        if (L < right) {
            quick(A, L, right);    // 왼쪽 배열 재귀적으로 반복
        }

        if (left < R) {
            quick(A, left, R);    // 오른쪽 배열 재귀적으로 반복
        }

        return A;
    }
}