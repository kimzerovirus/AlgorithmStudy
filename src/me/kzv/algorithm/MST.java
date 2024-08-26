package me.kzv.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Minimum Spanning Tree 최소 신장 트리
 */
public class MST {
    // 간선의 개수는 총 노드의 개수 - 1 이다.

    // 구현 순서
    // 1. edges 배열 만들기
    // 2. edges 배열 정렬하기
    // 3. parent 배열 만들고
    // 4. union & find 함수 구성하기
    // 5. edges 배열 순회하면서 가중치 계산
}

class Kruskal {
    /**
     * 크루스칼 알고리즘은 가장 적은 비용으로 모든 노드를 연결하기 위해 사용하는 알고리즘
     * - 간선을 거리가 짧은 순서대로 그래프에 포함시키면 어떻게 될까?
     *
     * 최소비용신장트리는 노드를 이어붙이기만 하면되서 사이클이 발생하면 안됨
     *
     * 1. 거리(비용)을 기준으로 오름차순 정렬
     * 2. 사이클 테이블 확인
     * 3. 사이클을 형성시키지 않으면 간선에 포함
     */
    /*
5
6
1 3 3
1 4 8
4 5 9
1 2 10
2 3 13
2 5 14
     */

    public static void main(String[] args) throws IOException {
        // 간선 입력 받기, 그래프에 저장
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        int[][] graph = new int[m][3];

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken()); // 간선 나가는 정점
            graph[i][1] = Integer.parseInt(st.nextToken()); // 간선 들어오는 정점
            graph[i][2] = Integer.parseInt(st.nextToken()); // 가중치
        }

        // 간선 정렬
        Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);

        // 부모노드 초기화
        int[] parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        //크루스칼 알고리즘 수행
        kruskal(graph, parent);
    }

    // 유니온
    public static void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

    // 파인드
    public static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        else return find(parent, parent[x]); // 타고 들어가서 최상단 노드로
    }

    // 크루스칼
    public static void kruskal(int[][] graph, int[] parent) {
        int cost = 0;
        for (int i = 0; i < graph.length; i++) {
            if (find(parent, graph[i][0]) != find(parent, graph[i][1])) {
                cost += graph[i][2];
                union(parent, graph[i][0], graph[i][1]);
            }
        }

        // 최소 신장 트리의 총 가중치 출력
        System.out.println(cost);
    }
}

class MST2{
    // 사이클이 포함되면 가중치의 합이 최소가 될 수 없으므로 사이클을 포함하지 않는다.
    // N개의 노드가 있으면 최소 신장 트리를 구성하는 에지의 개수는 항상 N-1개
    // 1. 에지 리스트로 그래프 구현 & 유니온 파인드 배열 초기화
    // 2. 그래프 데이터를 가중치 기준으로 정렬
    // 3. 가중치가 낮은 에지부터 연결 - 사이클 형성 유무를 find 연산으로 확인 후 사이클이 형성되지 않을 경우에만 union 연산 수행 - 반복
    // 4. 총 에지 비용 출력

    static int[] parent;
    static PriorityQueue<pEdge> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        queue = new PriorityQueue<>();
        parent = new int[N + 1];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            queue.add(new pEdge(s, e, v));
        }

        int useEdge = 0, result = 0;
        while (useEdge < N - 1) {
            pEdge now = queue.poll();
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }

        System.out.println(result);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static class pEdge implements Comparable<pEdge> {
        int s;
        int e;
        int v;

        public pEdge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(pEdge o) {
            // 가중치 오름차순 정렬
            return this.v - o.v;
        }
    }

}

