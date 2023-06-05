package me.kzv.baekjoon;

import java.util.Scanner;

public class B14500테크로미노 {

    static int[][] arr;
    static boolean[][] visited;
    static int N, M;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) { // 각 좌표 실행
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                go(i, j, arr[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(MAX);
    }

    static void go(int y, int x, int sum, int depth) {
        if (depth == 4) {
            MAX = Math.max(MAX, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                continue;
            }

            if (!visited[ny][nx]) {
                if (depth == 2) { // ㅜ 모양 체크
                    visited[ny][nx] = true;
                    go(y, x, sum + arr[ny][nx], depth + 1); // ㄱ 모양 만들어 높고 옆에 하나 더함
                    visited[ny][nx] = false;
                }

                visited[ny][nx] = true;
                go(ny, nx, sum + arr[ny][nx], depth + 1);
                visited[ny][nx] = false;
            }
        }
    }
}
