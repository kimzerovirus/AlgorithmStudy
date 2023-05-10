package me.kzv.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 1. edges 배열 만들기
// 2. edges 배열 정렬하기
// 3. parent 배열 만들고
// 4. union & find 함수 구성하기
// 5. edges 배열 순회하면서 가중치 계산
public class B6497전력난 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] in = bf.readLine().split(" ");
            int m = Integer.parseInt(in[0]); // 집의 수
            int n = Integer.parseInt(in[1]); // 길의 수

            if (m == 0 && n == 0) return;
            int[][] edges = new int[n][3];

            StringTokenizer st;
            int max_cost = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                edges[i][0] = Integer.parseInt(st.nextToken()); // 간선 나가는 정점
                edges[i][1] = Integer.parseInt(st.nextToken()); // 간선 들어오는 정점
                edges[i][2] = Integer.parseInt(st.nextToken()); // 가중치

                max_cost += edges[i][2];
            }


            parent = new int[m + 1];
            for (int i = 1; i <= m; i++) {
                parent[i] = i;
            }

            // 정렬
            Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));

            int min_cost = 0;
            for (int[] edge : edges) {
                if (findParent(edge[0]) != findParent(edge[1])) {
                    union(edge[0], edge[1]);
                    min_cost += edge[2];
                }
            }

            System.out.println(max_cost - min_cost);
        }
    }

    // 부모 노드를 찾는 함수
    static int findParent(int i) {
        if (parent[i] == i) return i; // 타고 들어가서 최상단 노드로
        return findParent(parent[i]);
    }

    // 두 부모 노드를 합치는 함수 - 작은값으로
    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}
