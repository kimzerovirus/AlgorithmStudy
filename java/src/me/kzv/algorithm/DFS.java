package me.kzv.algorithm;

import java.util.Arrays;
import java.util.Stack;

public class DFS {
    // DFS 깊이 우선 탐색
    // 스택, 재귀 사용
    // 경로의 정보를 저장하는 유형
    // 간선과 노드 형태의 문제들 유리한듯
    public static void main(String[] args) {
        // 1. 시작 노드를 스택에 저장
        // 2. 스택에서 pop
        // 3. 연산 수행
        // 4. 인접 노드를 순서대로 스택에 저장
        // 5. 스택이 빌 때까지 pop 하고 인접 노드를 스택에 저장하길 무한 반복

        // 트리 구현

        /*
                 0
                / \
               1   2
              / \   \
             3   4 - 5
             \      /
              \    /
               \  /
                 6
        */
        int[][] map = {
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4},
                {2, 5},
                {3, 6},
                {4, 5},
                {5, 6},
        };

        Stack<Integer> st = new Stack<>();
        int[] visited = new int[7];

        int startNode = 0;
        st.push(startNode);
        visited[startNode] = 1;

        // DFS
        while (!st.isEmpty()) {
            int now = st.pop();
            for (int i = 0; i < map.length; i++) {
                if (map[i][0] == now) {
                    int next = map[i][1];
                    if (visited[next] == 0) {
                        st.push(next);
                        visited[next] = visited[now] + 1;
                    }
                }
            }

            System.out.println("pop 추출: " + now);
            System.out.println("stack 인접 노드 : " + st);
            System.out.println("방문 : " + Arrays.toString(visited));
            System.out.println("------------------");
        }
    }
}

class DFS_Recursion {
    static boolean[] visited = new boolean[9];

    // 그래프의 연결상태를 2차원 배열로 표현
    // 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태
    static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};

    public static void main(String[] args) {
        dfs(1);
    }

    static void dfs(int nodeIndex) {
        // 방문 처리
        visited[nodeIndex] = true;

        // 방문 노드 출력
        System.out.print(nodeIndex + " -> ");

        // 방문한 노드에 인접한 노드 찾기
        for (int node : graph[nodeIndex]) {
            // 인접한 노드가 방문한 적이 없다면 DFS 수행
            if (!visited[node]) {
                dfs(node);
            }
        }
    }
}

class DFS_stack {

    // 방문처리에 사용 할 배열선언
    static boolean[] visited = new boolean[9];

    // 그림예시 그래프의 연결상태를 2차원 배열로 표현
    // 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태
    static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        // 시작 노드 세팅
        stack.push(1);
        visited[1] = true;

        // 스택이 비어있지 않으면 계속 반복
        while (!stack.isEmpty()) {

            // 스택에서 하나 추출
            int nodeIndex = stack.pop();

            // 방문 노드 출력
            System.out.print(nodeIndex + " -> ");

            // 꺼낸 노드와 인접한 노드 찾기
            for (int LinkedNode : graph[nodeIndex]) {
                // 인접한 노드를 방문하지 않았을 경우에 스택에 넣고 방문처리
                if (!visited[LinkedNode]) {
                    stack.push(LinkedNode);
                    visited[LinkedNode] = true;
                }
            }
        }
    }
}

class DFS_BackTracking {
    static int[] rates = {10, 20, 30};
    static Stack<Integer> rateCombination = new Stack<>();
    static int N = 3;

    static void dfs(int depth) {
        if (depth == N) {
//            System.out.println(temp);
            System.out.println("조합 완성");
            return;
        }

        for (int rate : rates) {
            rateCombination.push(rate);

            System.out.println(rateCombination);
            dfs(depth + 1); // N이 3인 경우 첫번째 dfs 가 돌고 첫번째 안의 dfs(두번째) 가 돌고 그 안의 dfs(세번째) 가 세번 돌고나서 다시 두번째 dfs 가 돌고 이 두번재 dfs 가 세번 다 돌면 첫번째 dfs 가 도는 방식
            /**
             *  for{
             *      for{
             *          for{
             *              이런 느낌
             *          }
             *      }
             *  }
             */
            rateCombination.pop();
        }
    }

    public static void main(String[] args) {
        dfs(0);
    }
}
