package me.kzv.programers;

public class 삼각달팽이 {
    static int[] dy = {1, 0, -1};
    static int[] dx = {0, 1, -1};

    public int[] solution(int n) {
        int finish = n * (n + 1) / 2;
        int[][] arr = new int[n][n];
        int[] answer = new int[finish];
        int end = n;
        int mode = 0;
        int cnt = 0, y = 0, x = 0, idx = 0;

        while (cnt != finish) {
            idx++;
            arr[y][x] = ++cnt;

            if (mode == 0 && idx == end) {
                mode = 1;
                idx = 0;
                end--;
            } else if (mode == 1 && idx == end) {
                mode = 2;
                idx = 0;
                end--;
            } else if (mode == 2 && idx == end) {
                mode = 0;
                idx = 0;
                end--;
            }

            y += dy[mode];
            x += dx[mode];
        }

        int i = 0;
        for (int[] ar : arr) {
            for (int a : ar) {
                if (a == 0) break;
                answer[i++] = a;
            }
        }

        return answer;
    }

    // 깔끔한 풀이
    public int[] solution2(int n) {
        int[] answer = new int[(n*(n+1))/2];
        int[][] matrix = new int[n][n];

        int x = -1, y = 0;
        int num = 1;

        // 2중 for 문은 각 회차별 최대 가능 자릿수까지 돌려줌
        // n이 5일 경우, i = 0 -> 5, i = 1 -> 4, i = 2 -> 3 ...
        // 내려가고, 우측 이동, 대각선으로 올라가기 3가지 방향으로 이동하므로
        // i가 3회 돌때마다 방향의 한 사이클이 돈다.
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i % 3 == 0) {
                    ++x;
                } else if (i % 3 == 1) {
                    ++y;
                } else if (i % 3 == 2) {
                    --x;
                    --y;
                }
                matrix[x][y] = num++;
            }
        }

        int k = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) break;
                answer[k++] = matrix[i][j];
            }
        }

        return answer;
    }
}
