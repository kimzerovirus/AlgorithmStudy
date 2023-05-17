package me.kzv.programers;

public class 삼각달팽이 {
    static int[] dy = {1, 0, -1};
    static int[] dx = {0, 1, -1};

    public int[] solution(int n) {
        int[][] arr = new int[n][n];

        int finish = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                finish++;
            }
        }

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
                if (a != 0) answer[i++] = a;
            }
        }

        return answer;
    }
}
