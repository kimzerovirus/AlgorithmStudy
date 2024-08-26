package me.kzv.algorithm;

import java.util.Scanner;

/**
 * 주어진 시작점으로부터 연결된 영역들을 찾는 알고리즘
 * 다차원 배열의 어떤 칸과 연결된 영역을 찾는 알고리즘
 *
 * 재귀를 이용한 알고리즘 dfs
 */
public class FloodFill {
/*

5
0 0 0 0 0
0 0 0 1 1
0 0 0 1 0
1 1 1 1 0
0 0 0 0 0
1 1

 */

    static int N;
    static int[][] board = new int[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int row = sc.nextInt();
        int col = sc.nextInt();

        fill(row, col);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    static void fill(int r, int c) {
        if (r < 0 || r > N - 1 || c < 0 || c > N - 1) return;
        if (board[r][c] != 0) return;

        board[r][c] = 1;

        fill(r - 1, c); // up
        fill(r + 1, c); // down
        fill(r, c - 1); // left
        fill(r, c + 1); //right
    }
}
