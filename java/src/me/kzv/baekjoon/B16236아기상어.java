package me.kzv.baekjoon;

import java.util.*;

public class B16236아기상어 {
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    // 상어 정보
    static int lv = 2;
    static int exp = -1; // 반복문 시작하면서 +1 하므로 0이 아니라 -1 부터 시작

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int result = 0;
        int N = sc.nextInt();
        int[][] arr = new int[N][N];

        // 먹이 찾을 순서용
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int size = sc.nextInt();
                if (size == 9) {
                    pq.add(new Node(i, j, 0)); // 상어가 있는 위치부터 시작
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = size;
            }
        }


        Queue<Node> q = new LinkedList<>(); // 길찾기용 bfs

        while (!pq.isEmpty()) {
            boolean[][] visited = new boolean[N][N];
            Node node = pq.poll(); // 가장 가까운 녀석을 꺼내고
            pq.clear(); // 먹이 순서를 다시 정하기 위해 초기화
            arr[node.y][node.x] = 0; // 방문 노드는 0으로 설정
            result += node.dist;
            if(++exp == lv) {
                lv += 1;
                exp = 0;
            }

            q.add(new Node(node.y, node.x, 0)); // bfs 시작점 세팅
            visited[node.y][node.x] = true;

            while (!q.isEmpty()) {
                Node shark = q.poll(); // 현재 상어 위치
                int y = shark.y;
                int x = shark.x;

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    // 이미 후보로 등록되었거나 먹을 수 없는 경우
                    if (ny < 0 || ny >= N || nx < 0 || nx >= N || arr[ny][nx] > lv || visited[ny][nx]) {
                        continue;
                    }

                    if (arr[ny][nx] < lv && arr[ny][nx] != 0) { // 먹을 수 있는 후보 저장
                        pq.add(new Node(ny, nx, shark.dist + 1));

                    }

                    q.add(new Node(ny, nx, shark.dist + 1)); // 위치 이동
                    visited[ny][nx] = true;
                }
            }
        }

        System.out.println(result);
    }

    static class Node implements Comparable<Node> {
        int y, x, dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            if (dist == n.dist) {
                if (y == n.y) {
                    return x - n.x;
                } else {
                    return y - n.y;
                }
            } else {
                return dist - n.dist;
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    ", dist=" + dist +
                    '}';
        }
    }
}