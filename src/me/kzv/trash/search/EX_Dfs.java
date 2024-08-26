package me.kzv.trash.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class EX_Dfs {
    static int N = 10;
    static List<Integer>[] A = new List[N];
    static boolean[] visited;

    public static void main(String[] args) {
        IntStream.rangeClosed(1, N).forEach(i -> A[i - 1] = new ArrayList<>());
        visited = new boolean[A.length];
        dfs();
    }

    static void dfs() {
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            if (!visited[i]) { // 방문하지 않은 노드가 없을 때 까지 루프
                count++;
                search(i);
            }
            System.out.println(count);
        }
    }

    static void search(int v) {
        if (visited[v]) return;
        visited[v] = true;
        for (int i : A[v]) { // 연결 노드 중 방문하지 않았던 노드만 탐색
            if (!visited[i]) search(i);
        }
    }
}
