package me.kzv.baekjoon;

import java.util.Scanner;

public class B2580스도쿠 {
    public static int[][] arr = new int[9][9];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        go(0, 0);
    }

    public static void go(int row, int col) {
        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isPossible(row, col, i)) {
                    arr[row][col] = i;
                    next(row, col);
                    arr[row][col] = 0;
                }
            }
        } else {
            next(row, col);
        }
    }

    public static void next(int row, int col) {
        if (++col < 9) {
            go(row, col);
        } else {
            if (++row == 9) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
                System.exit(0);
            }

            go(row, 0);
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
