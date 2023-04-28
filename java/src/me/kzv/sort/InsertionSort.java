package me.kzv.sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] A = new int[]{1, 5, 2, 3, 4};

        print(insertion(A));
    }

    static int[] insertion(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int insert_point = i;
            int insert_value = A[i];

            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    insert_point = j + 1;
                    break;
                }
                if (j == 0) {
                    insert_point = 0;
                }
            }

            for (int j = i; j > insert_point; j--) {
                A[j] = A[j - 1];
            }

            A[insert_point] = insert_value;
        }

        return A;
    }

    static void print(int[] A){
        for (int i : A) {
            System.out.print(i + ", ");
        }
    }
}
