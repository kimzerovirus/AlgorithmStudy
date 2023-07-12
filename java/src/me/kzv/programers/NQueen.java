package me.kzv.programers;

public class NQueen {
    class Solution {
        int[][] map;
        int answer = 0;
        int N;

        int[] dy = new int[]{1, 1, -1, -1};
        int[] dx = new int[]{1, -1, 1, -1};

        public int solution(int n) {
            N = n;
            map = new int[N][N];
            go(0);
            return answer;
        }

        void go(int row) {
            if (row == N) {
                answer++;
                return;
            }

            for (int col = 0; col < N; col++) {
                map[row][col] = 1;
                if (isPossible(row, col)) go(row + 1);
                map[row][col] = 0;
            }
        }

        boolean isPossible(int row, int col) {
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += map[row][i];
                cnt += map[i][col];

                if (i > 0) {
                    for (int j = 0; j < 4; j++) {
                        int ny = row + dy[j] * i;
                        int nx = col + dx[j] * i;

                        if (ny >= 0 && nx >= 0 && ny < N && nx < N) cnt += map[ny][nx];

                        ny = row - dy[j] * i;
                        nx = col - dx[j] * i;

                        if (ny >= 0 && nx >= 0 && ny < N && nx < N) cnt += map[ny][nx];
                    }
                }
            }

            return cnt == 2;
        }
    }
}
