package me.kzv.algorithm;

import java.util.*;

public class Bfs {
    // BFS 넢이 우선 탐색
    // 큐를 이용한 횡의 방향 완전탐색
    // 최적의 경로를 보장한다! - 최단거리 문제
    // 2차원 배열 형태의 바둑판 모양으로 주어질 때 유용한듯
    /*
        -----------------
        | 1 | 2 | 3 | 4 |
        -----------------
        | 5 | *6* | 7 | 8 |
        -----------------
        | 9 | 10 | 11 | 12 |
        -----------------
        x,y 기준 (0,0) ~ (3,2) -- row, col 로 보면 y,x 가 되어야 한다.
        6 <- 시작 (1,1) 좌표

        탐색값 Q: 6
        1회차 out: 6 Q: 2, 5, 7, 10
        2회차 out: 2 Q: 5, 7, 10, 1, 3
        ...

        따라서 너비 우선 탐색을 하려면 FIFO 형태의 큐를 사용해야함

        2차원 배열이 주어졌을 때 x,y 좌표 보다 row,col 관점으로 보는게 더 편한듯
     */

    public static void main(String[] args) {
        // 1. 시작 노드를 큐에 저장
        // 2. 선입선출 맨앞 노드 추출 peek
        // 3. 연산 수행
        // 4. 인접 노드 큐에 저장
        // 5. 탐색이 끝난 노드 삭제 poll
        // 6. 다음 노드를 꺼내서 큐가 삘 때까지 반복
        int row = 3, col = 4;
        int[][] map = new int[row][col]; // 행 row - 열 col
        int temp = 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = temp;
                temp++;
            }
        }

        System.out.println("-------------------------------");
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("-------------------------------");

        Queue<Node> q = new LinkedList<>(); // 배열에 입력된 값

        boolean[][] visited = new boolean[row][col];

        // 1. 시작 노드 입력
        Node startNode = new Node();
        startNode.setValue(6);
        startNode.setY(1);
        startNode.setX(1);

        q.add(startNode);
        visited[1][1] = true;

        int index = 0;
        while (!q.isEmpty()) {
            // 2. 큐의 맨 앞의 노드 값으로 현재 노드의 좌표 가져오기
            Node n = q.peek();
            int y = n.y;
            int x = n.x;

            // 3. 해당 노드에 대한 연산 수행

            // 4. 인접한 노드 저장
            // 위쪽 노드
            if (y - 1 >= 0) {
                if (!visited[y - 1][x]) {
                    Node node = new Node();
                    node.setValue(map[y - 1][x]);// 인접 노드 값 저장
                    node.setY(y - 1); // 인접 노드 y좌표 저장
                    node.setX(x); // 인접 노드 x좌표 저장

                    q.add(node);
                    visited[y - 1][x] = true;
                }
            }

            // 왼쪽 노드
            if (x - 1 >= 0) {
                if (!visited[y][x - 1]) {
                    Node node = new Node();
                    node.setValue(map[y][x - 1]);
                    node.setY(y);
                    node.setX(x - 1);

                    q.add(node);
                    visited[y][x - 1] = true;
                }
            }

            // 아랫쪽 노드
            if (y + 1 < row) {
                if (!visited[y + 1][x]) {
                    Node node = new Node();
                    node.setValue(map[y + 1][x]);
                    node.setY(y + 1);
                    node.setX(x);

                    q.add(node);
                    visited[y + 1][x] = true;
                }
            }

            // 오른쪽 노드
            if (x + 1 < col) {
                if (!visited[y][x + 1]) {
                    Node node = new Node();
                    node.setValue(map[y][x + 1]);
                    node.setY(y);
                    node.setX(x + 1);

                    q.add(node);
                    visited[y][x + 1] = true;
                }
            }

            // 5. 연산이 끝난 노드 제거
            index++;
            System.out.print("<" + index + "회차> ");
            var out = q.poll();
            System.out.print("out: " + out.value + ", 좌표 : {x: " + out.x + ", y: " + out.y + "}");

            System.out.println(", Q : " + Arrays.toString(q.stream().map(i -> i.value).toArray()));
        }
    }

    static class Node {
        // y = row
        // x = col
        private int value, y, x;

        public Node() {
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }
    }
}

class Maze {
    public static void main(String[] args) {
        // -1: 시작점, 0 : 길, 벽, 1, 도착점 2
        int[][] map = {
                {-1, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 2}
        };

        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[map.length][map.length];
        int answer = 0;

        // 1. 시작 노드 입력 (0,0)
        Node startNode = new Node(0, 0);
        visited[0][0] = 1; // 방문한 위치에 첫시작점으로 부터 몇칸을 왔는지 저장한다. 즉, 출발지 = 1, 두번째로 갈 수 있는 모든 경로는 2 세번째로 ~ 3 ...
        // 이렇게 visited 는 모든 순간 갈 수 있는 최선의 경우의 수가 기입된다. 따라서 해당 노드에 방문 여부만 확인하면 최적의 이동 횟수를 찾을 수 있게 된다.
        q.add(startNode);

        while (!q.isEmpty()) {
            // 2. 큐의 맨 앞의 노드 값 가져오기
            Node node = q.poll();
            int row = node.row;
            int col = node.col;
            System.out.println(node);

            // 3. 해당 노드에 대한 연산 수행
            // 4. 인접한 노드 저장
            // 위쪽 노드
            if (row - 1 >= 0) {
                if (visited[row - 1][col] == 0) {
                    if (map[row - 1][col] != 1) {
                        q.add(new Node(row - 1, col));
                        visited[row - 1][col] = visited[row][col] + 1;
                    }
                }
            }

            // 아래쪽 노드
            if (row + 1 < 7) {
                if (visited[row + 1][col] == 0) {
                    if (map[row + 1][col] != 1) {
                        q.add(new Node(row + 1, col));
                        visited[row + 1][col] = visited[row][col] + 1;
                    }
                }
            }

            // 왼쪽 노드
            if (col - 1 >= 0) {
                if (visited[row][col - 1] == 0) {
                    if (map[row][col - 1] != 1) {
                        q.add(new Node(row, col - 1));
                        visited[row][col - 1] = visited[row][col] + 1;
                    }
                }
            }

            // 오른쪽 노드
            if (col + 1 < 7) {
                if (visited[row][col + 1] == 0) {
                    if (map[row][col + 1] != 1) {
                        q.add(new Node(row, col + 1));
                        visited[row][col + 1] = visited[row][col] + 1;
                    }
                }
            }
            System.out.println("========================");
        }

        answer = visited[6][6];
        System.out.println("distance: " + answer);
    }

    static class Node {
        int row, col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}

class Horse {
    // 일반적으로 BFS 와 DFS 는 대부분 상호 대체 가능하다.
    // 하지만 이 문제의 경우 BFS 가 더 효율적이다.

    // 1. 시작점은 0 도착점은 N
    // 2. 이동 횟수당 이동 가능 거리는 +3, -3, +7, -7
    // 3. 최소한의 이동 횟수

    // BFS 의 장점은 탐색하여 발견까지의 과정이 반드시 최적의 경로임을 보장한다.
    // 하지만 DFS 는 그렇지 않다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ArrayList<Integer> visitedList = new ArrayList<>(); // 방문 위치 저장

        LinkedList<Integer> pathQ = new LinkedList<>(); // 경로를 계산
        LinkedList<Integer> visitedQ = new LinkedList<>(); // 점프 횟수를 계산

        int answer = 0;

        pathQ.add(0);
        visitedList.add(0);
        visitedQ.add(0);

        while (true) {
            // 탐색할 지점의 좌표를 꺼내어 저장하고, 이동할 위치를 변수에 저장
            int now = pathQ.poll(); // 현재 노드의 위치를 알려줌
            int jump_cnt = visitedQ.poll(); // 현재 노드의 점프 횟수를 알려줌

            int jump_forward_3 = now + 3;
            int jump_back_3 = now - 3;

            int jump_forward_7 = now + 7;
            int jump_back_7 = now + 7;

            if (now == N) { // 도착점에 도달하면 루프 탈출!
                answer = jump_cnt;
                break;
            }

            if (!visitedList.contains(jump_forward_3)) {
                pathQ.add(jump_forward_3);
                visitedList.add(jump_forward_3);
                visitedQ.add(jump_cnt + 1);
            }

            if (!visitedList.contains(jump_back_3)) {
                pathQ.add(jump_back_3);
                visitedList.add(jump_back_3);
                visitedQ.add(jump_cnt + 1);
            }

            if (!visitedList.contains(jump_forward_7)) {
                pathQ.add(jump_forward_7);
                visitedList.add(jump_forward_7);
                visitedQ.add(jump_cnt + 1);
            }

            if (!visitedList.contains(jump_back_7)) {
                pathQ.add(jump_back_7);
                visitedList.add(jump_back_7);
                visitedQ.add(jump_cnt + 1);
            }
        }

        System.out.println("최적의 점프 횟수는 " + answer + "회");
    }
}

