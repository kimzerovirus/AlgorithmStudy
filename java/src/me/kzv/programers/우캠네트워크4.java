package me.kzv.programers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 크루스칼 알고리즘 (Kruskal Algorithm)
 * 크루스칼 알고리즘은 간선들을 중심으로, 그리디 알고리즘을 통해 최소 스패닝 트리를 구하는 알고리즘이다.
 * 형태와 관계없이 모든 정점을 사이클 없이 이을수만 있다면, 그것이 곧 스패닝 트리이다
 * <p>
 * [동작 원리]
 * 1. 선택되지 않은 간선들 중 최소 가중치인 간선을 선택한다.
 * 2. 만약 그 간선을 선택했을 때, 지금까지 구성된 스패닝 트리에 사이클이 없을 경우에만 선택한다.
 * 3. 총 V - 1(정점의 개수 - 1)개의 간선이 선택될 때까지 반복한다.
 */
// 처음에 네트워크랑 리패어 돌면서 하나라도 연결되지 않을땐 탐색없이 리턴하고 종료
public class 우캠네트워크4 {

}

class Solution {
    static int solution(int[][] network, int[][] recover) {
        int answer = -1;
        int[][] graph = new int[network.length + recover.length][3];
        for (int i = 0; i < network.length; i++) {
            graph[i] = new int[]{network[i][0], network[i][1], 0};
        }
        for (int j = 0; j < recover.length; j++) {
            graph[j + network.length] = recover[j];
        }

        // 간선 비용 순으로 오름차순 정렬
        Arrays.sort(graph, Comparator.comparingInt(o -> o[2]));

        kruskal(graph, new int[]{1, 2, 3, 4, 5, 6});
        return answer;
    }

    static void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

    static int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        else return find(parent, parent[i]);
    }

    static void kruskal(int[][] graph, int[] parent) {
        int cost = 0;

        for (int[] g : graph) {
            if (find(parent, g[0]) != find(parent, g[1])) {
                cost += g[2];
                union(parent, g[0], g[1]);
            }
        }

        System.out.println(cost);
    }

    public static void main(String[] args) {
        int[][] network = new int[][]{{1, 2}, {2, 3}, {4, 5}, {5, 6}};
        int[][] recover = new int[][]{{2, 4, 10}, {3, 5, 15}};

        solution(network, recover);
    }
}