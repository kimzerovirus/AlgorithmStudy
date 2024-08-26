package me.kzv.baekjoon;

import java.io.*;
import java.util.*;

public class B2887행성터널 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken()); // x
            points[i][1] = Integer.parseInt(st.nextToken()); // y
            points[i][2] = Integer.parseInt(st.nextToken()); // z
            points[i][3] = i; // 행성 식별자
        }

        List<int[]> edges = new ArrayList<>();

        // 입력값이 10만이라 메모리 초과됨 n^2 는 안됨
//        for (int i = 0; i < points.length; i++) {
//            for (int j = i + 1; j < points.length; j++) {
//                int cost = Math.min(Math.min(Math.abs(points[i][0] - points[j][0]), Math.abs(points[i][1] - points[j][1])), Math.abs(points[i][2] - points[j][2]));
//                edges.add(new int[]{i, j, cost});
//            }
//        }

        // x기준
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        for (int x = 0; x < points.length - 1; x++) {
            edges.add(new int[]{points[x][3], points[x + 1][3], Math.abs(points[x][0] - points[x + 1][0])});
        }

        // y기준
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        for (int y = 0; y < points.length - 1; y++) {
            edges.add(new int[]{points[y][3], points[y + 1][3], Math.abs(points[y][1] - points[y + 1][1])});
        }

        // z기준
        Arrays.sort(points, Comparator.comparingInt(o -> o[2]));
        for (int z = 0; z < points.length - 1; z++) {
            edges.add(new int[]{points[z][3], points[z + 1][3], Math.abs(points[z][2] - points[z + 1][2])});
        }

        // 간선 정렬
        edges.sort(Comparator.comparingInt(o -> o[2]));

        // 부모노드 초기화
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        //크루스칼 알고리즘 수행
        int answer = kruskal(edges);
        System.out.println(answer);
    }

    // 부모 노드를 찾는 함수
    static int find(int i) {
        if (parent[i] == i) return i;
        return find(parent[i]);
    }

    // 두 부모 노드를 합치는 함수 - 작은값으로
    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    // 크루스칼
    public static int kruskal(List<int[]> edges) {
        int cost = 0;
        for (int[] edge : edges) {
            if (find(edge[0]) != find(edge[1])) {
                cost += edge[2];
                union(edge[0], edge[1]);
            }
        }

        // 최소 신장 트리의 총 가중치 출력
        return cost;
    }
}

