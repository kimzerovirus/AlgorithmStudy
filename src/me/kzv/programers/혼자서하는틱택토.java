package me.kzv.programers;

public class 혼자서하는틱택토 {
    class Solution {
        static char[][] map = new char[3][3];

        public int solution(String[] board) {
            int cntO = 0, cntX = 0;

            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    map[i][k] = board[i].charAt(k);
                    if (map[i][k] == 'O') cntO++;
                    if (map[i][k] == 'X') cntX++;
                }
            }

            // O가 선공이므로 X보다 1개 많거나 개수가 같아야 한다.
            if (!(cntO - cntX == 0 || cntO - cntX == 1)) return 0;

            int winnerO = 0, winnerX = 0;

            for (int i = 0; i < 3; i++) {
                // 가로
                if (map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                    if (map[i][0] == 'O') winnerO++;
                    if (map[i][0] == 'X') winnerX++;
                }

                // 세로
                if (map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
                    if (map[0][i] == 'O') winnerO++;
                    if (map[0][i] == 'X') winnerX++;
                }
            }

            // 대각선 우 -> 좌
            if (map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
                if (map[0][0] == 'O') winnerO++;
                if (map[0][0] == 'X') winnerX++;
            }

            // 대각선 좌 -> 우
            if (map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
                if (map[0][2] == 'O') winnerO++;
                if (map[0][2] == 'X') winnerX++;
            }

            if (winnerO > 0 && winnerX > 0) return 0;
            if (winnerO > 0 && cntO != cntX + 1) return 0;
            if (winnerX > 0 && cntX != cntO) return 0;

            return 1;
        }
    }
}