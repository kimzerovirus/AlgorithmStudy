package me.kzv.programers;

public class 쿼드압축후수세기 {
    static int[] answer = {0, 0};
    static int[][] infos;

    public int[] solution(int[][] arr) {
        infos = arr;

        go(0, 0, infos.length);
        return answer;
    }

    void go(int y, int x, int size) {
        if (check(y, x, size)) {
            if (infos[y][x] == 0) {
                answer[0] += 1;
            } else {
                answer[1] += 1;
            }
            return;
        }

        size /= 2;

        go(y, x, size);
        go(y, x + size, size);
        go(y + size, x, size);
        go(y + size, x + size, size);
    }

    boolean check(int y, int x, int size) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (infos[i][j] != infos[y][x]) {
                    return false;
                }
            }
        }
        return true;
    }
}

