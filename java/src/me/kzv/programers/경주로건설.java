package me.kzv.programers;

public class 경주로건설 {
    static int[][] board, costs;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N;

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        this.board = board;
        N = board.length;
        costs = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                costs[i][j] = Integer.MAX_VALUE;
            }
        }

        costs[0][0] = 0;
        for (int i = 0; i < 4; i++) {
            go(0, 0, i);
        }

        answer = costs[N - 1][N - 1];

        if (answer == Integer.MAX_VALUE) answer = -1;

        return answer;
    }

    void go(int y, int x, int dir) {
        if (isEnd(y, x)) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
            if (isWall(ny, nx)) continue;

            int nowCost = (dir == i) ? 100 : 600;
            int newCost = costs[y][x] + nowCost;

            if (costs[ny][nx] < newCost) {
                continue;
            }

            costs[ny][nx] = newCost;
            go(ny, nx, i);
        }
    }

    static boolean isWall(int y, int x) {
        return board[y][x] == 1;
    }

    static boolean isEnd(int y, int x) {
        return y == N - 1 && x == N - 1;
    }
}
