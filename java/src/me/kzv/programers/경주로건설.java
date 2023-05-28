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

        // 비용 배열 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                costs[i][j] = Integer.MAX_VALUE;
            }
        }

        // 시작 지점 초기화
        costs[0][0] = 0;
        for (int i = 0; i < 4; i++) {
            go(0, 0, i);
        }

        answer = costs[N - 1][N - 1];

        if (answer == Integer.MAX_VALUE) answer = -1;

        return answer;
    }

    void go(int y, int x, int dir) {
        if (y == N - 1 && x == N - 1) { // 마지막에 도달하면 탈출
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N || board[y][x] == 1) continue;

            int nowCost = (dir == i) ? 100 : 600; // 더할 비용
            int newCost = costs[y][x] + nowCost; // ny, nx 지점의 현재까지의 총 비용

            if (costs[ny][nx] < newCost) { // 이미 책정된 ny, nx 지점의 비용이 더 작다면 넘어간다
                continue;
            }

            costs[ny][nx] = newCost;
            go(ny, nx, i);
        }
    }
}
