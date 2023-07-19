package me.kzv.baekjoon;


import java.util.*;

public class Main {
    static int N, M, K, x1, x2, y1, y2;
    static int answer = -1;
    static int[][] visited;
    static boolean[][] wall;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        sc.nextLine();

        visited = new int[N + 1][M + 1];
        wall = new boolean[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == '#') wall[i][j] = true;
            }
        }

        y1 = sc.nextInt();
        x1 = sc.nextInt();
        y2 = sc.nextInt();
        x2 = sc.nextInt();

        System.out.println(answer);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{y1, x1});
        visited[y1][x1] = 1;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int y = point[0];
            int x = point[1];

            for (int i = 0; i < 4; i++) {
                for (int k = 1; k <= K; k++) {
                    int ny = y + dy[i] * k;
                    int nx = x + dx[i] * k;

                    if(ny < 0 || ny > N || nx < 0 || nx > M || wall[ny][nx]) break;

                    q.add(new int[]{ny, nx});
                }
            }
        }
    }
}