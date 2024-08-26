package me.kzv.programers;

import java.util.*;

public class 거리두기확인하기 {
    final int[] dy = {-1, 0, 1, 0};
    final int[] dx = {0, 1, 0, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            if (check(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    private boolean check(String[] place) {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (place[y].charAt(x) == 'P') {
                    if (bfs(place, y, x)) { // 거리두기를 지키지 않고 있음
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean bfs(String[] place, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] point = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = point[0] + dy[i]; // 탐색할 지점의 행 번호
                int nx = point[1] + dx[i]; // 탐색할 지점의 열 번호

                if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue; // 범위 벗어나면 넘어가기
                if (ny == y && nx == x) continue; // 새로 탐색하는 지점이 최초 지점이면 넘어가기

                int d = Math.abs(y - ny) + Math.abs(x - nx); // 맨해튼 거리

                // X는 더이상 탐색을 하지 않는다 -> PXP 의 경우 거리두기를 지킨것이므로
                // 맨해튼 거리 1인 지점에 O가 나온다면 O를 기준으로 탐색을 한번 더 한다 -> 다음 회차에서 POP 가 나오는 경우를 찾는다
                if (place[ny].charAt(nx) == 'O' && d == 1) {
                    q.add(new int[]{ny, nx});
                } else if (place[ny].charAt(nx) == 'P' && d <= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
