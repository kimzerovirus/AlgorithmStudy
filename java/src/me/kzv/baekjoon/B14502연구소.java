package me.kzv.baekjoon;

import java.util.*;

public class B14502연구소 {

    static List<Pair> wall = new LinkedList<>();
    static List<Pair> virus = new LinkedList<>();
    static int ret;
    static int n, m;
    static int[][] a, visited;
    static final int dy[] = new int[]{-1, 0, 1, 0};
    static final int dx[] = new int[]{0, 1, 0, -1};

    /*
        방향 x,y 증가 값
                     x=0, y=-1
                         |
       x=-1, y=0 <-- x=0, y=0 --> x=1, y=0
                         |
                     x=0, y=1
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        a = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        // 맵의 크기는 n * m
        // 빈공간은 0
        // 벽은 1
        // 바이러스 2
        // 벽 3개를 세우고 바이러스를 퍼뜨린다

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) { // 벽을 세울 수 있다.
                    wall.add(new Pair(i, j));
                }
                if (a[i][j] == 2) { // 바이러스를 퍼뜨릴 수 있다.
                    virus.add(new Pair(i, j));
                }
            }
        }

        // 조합 같은 경우 재귀로도 풀 수 있지만 for 3개까지는 그냥 for 로 푸는게 나을지도
        for (int i = 0; i < wall.size(); i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    // 벽 3가지 세우는 조합
                    a[wall.get(i).first()][wall.get(i).second()] = 1;
                    a[wall.get(j).first()][wall.get(j).second()] = 1;
                    a[wall.get(k).first()][wall.get(k).second()] = 1;

                    ret = Math.max(ret, go());

                    // 다음 시뮬레이션을 위한 원상복구
                    a[wall.get(i).first()][wall.get(i).second()] = 0;
                    a[wall.get(j).first()][wall.get(j).second()] = 0;
                    a[wall.get(k).first()][wall.get(k).second()] = 0;
                }
            }
        }

        System.out.println(ret);
    }

    static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue; // 범위를 벗어날 경우
            if (visited[ny][nx] == 1) continue; // 이미 방문한 경우
            if (a[ny][nx] == 1) continue; // 벽인 경우
            visited[ny][nx] = 1;
            dfs(ny, nx);
        }
    }

    static int go() {
        // 경우의 수 마다 방문 배열 초기화
        visited = new int[n][m];

        for (Pair pair : virus) {
            visited[pair.first()][pair.second()] = 1;
            dfs(pair.first(), pair.second());
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0 && visited[i][j] == 0) cnt++; // 안전 영역
            }
        }

        return cnt;
    }

    static class Pair {
        private Integer x, y;

        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Integer first() {
            return x;
        }

        public Integer second() {
            return y;
        }
    }
}
