package me.kzv.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16930달리기 {
    static int N, M, K, x1, x2, y1, y2;
    static int[][] answer;
    static boolean[][] wall;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        sc.nextLine();

        wall = new boolean[N][M];
        answer = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == '#') wall[i][j] = true;
            }
        }

        y1 = sc.nextInt() - 1;
        x1 = sc.nextInt() - 1;
        y2 = sc.nextInt() - 1;
        x2 = sc.nextInt() - 1;

        bfs();

        if (answer[y2][x2] == 0) System.out.println(-1);
        else System.out.println(answer[y2][x2]);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{y1, x1});

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int y = point[0];
            int x = point[1];

            int current = answer[y][x] + 1;
            if (y == y2 && x == x2) continue;

            for (int i = 0; i < 4; i++) {
                for (int k = 1; k <= K; k++) {
                    int ny = y + dy[i] * k;
                    int nx = x + dx[i] * k;

                    if (ny < 0 || ny >= N || nx < 0 || nx >= M || wall[ny][nx]) break;

                    if (answer[ny][nx] == 0) {
                        answer[ny][nx] = current;
                        q.add(new int[]{ny, nx});
                    } else if (answer[ny][nx] < current) {
                        break;
                    }
                }
            }
        }
    }
}
