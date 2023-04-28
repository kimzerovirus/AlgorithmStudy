package me.kzv.sort;

public class MergeSort {
    static int[] temp;

    public static void main(String[] args) {
        int[] A = new int[]{1, 5, 2, 3, 4};
        temp = new int[A.length];

        print(merge_sort(A, 0, A.length - 1));
    }

    static void print(int[] A) {
        for (int i : A) {
            System.out.print(i + ", ");
        }
    }

    // i: 정렬된 왼쪽 리스트에 대한 인덱스
    // j: 정렬된 오른쪽 리스트에 대한 인덱스
    // k: 정렬될 리스트에 대한 인덱스
    // 2개의 인접한 배열 A[left...mid]와 A[mid+1...right]의 합병 과정
    static void merge(int[] A, int left, int mid, int right) {
        int i, j, k, l;
        i = left;
        j = mid + 1;
        k = left;

        /* 분할 정렬된 list의 합병 */
        while (i <= mid && j <= right) {
            if (A[i] <= A[j])
                temp[k++] = A[i++];
            else
                temp[k++] = A[j++];
        }

        // 남아 있는 값들을 일괄 복사
        if (i > mid) {
            for (l = j; l <= right; l++)
                temp[k++] = A[l];
        }
        // 남아 있는 값들을 일괄 복사
        else {
            for (l = i; l <= mid; l++)
                temp[k++] = A[l];
        }

        // 임시배열 -> 배열로 재복사
        for (l = left; l <= right; l++) {
            A[l] = temp[l];
        }
    }

    static int[] merge_sort(int[] A, int left, int right) {
        int mid;

        if (left < right) {
            mid = (left + right) / 2; // 중간 위치를 계산하여 리스트를 균등 분할 -분할(Divide)
            merge_sort(A, left, mid); // 앞쪽 부분 리스트 정렬 -정복(Conquer)
            merge_sort(A, mid + 1, right); // 뒤쪽 부분 리스트 정렬 -정복(Conquer)
            merge(A, left, mid, right); // 정렬된 2개의 부분 배열을 합병하는 과정 -결합(Combine)
        }

        return A;
    }
}
