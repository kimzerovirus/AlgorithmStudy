package me.kzv.baekjoon;

import java.util.*;

public class B2580스도쿠 {
    public static int[][] arr = new int[9][9];
    public static List<int[]> blank = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 0) blank.add(new int[]{i, j});
            }
        }

        go(0);
    }

    public static void go(int idx) {
        if (idx == blank.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        int[] position = blank.get(idx);
        int row = position[0];
        int col = position[1];

        for (int i = 1; i <= 9; i++) {
            if (isPossible(row, col, i)) {
                arr[row][col] = i;
                go(idx++);
                arr[row][col] = 0;
            }
        }
    }


    public static boolean isPossible(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value || arr[i][col] == value) {
                return false;
            }
        }

        row = (row / 3) * 3;
        col = (col / 3) * 3;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
