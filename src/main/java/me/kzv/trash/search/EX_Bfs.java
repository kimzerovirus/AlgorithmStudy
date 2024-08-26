package me.kzv.trash.search;

import java.util.*;

public class EX_Bfs {
    static int N = 10;

    static boolean visited[];
    static List<Integer>[] A = new List[N];

    public static void main(String[] args) {
        for (int i = 1; i <= N - 1; i++) A[i] = new ArrayList();

        // 번호가 작은 것을 먼저 방문하기 위해 정렬
        for (int i = 1; i <= N - 1; i++) {
            Collections.sort(A[i]);
        }
        visited = new boolean[N]; // 방문 배열 초기화
        dfs(0);
        System.out.println();
        bfs(0);
        System.out.println();
    }

    static void dfs(int node) {
        System.out.println("node = " + node);
        visited[node] = true;
        for (int i : A[node]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            System.out.println(now_node + " ");
            for (int i : A[now_node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
