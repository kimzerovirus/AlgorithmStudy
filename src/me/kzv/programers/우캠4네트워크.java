package me.kzv.programers;

import java.util.*;

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
public class 우캠4네트워크 {
    class Solution {
        static int solution(int[][] network, int[][] recover) {
            int[][] graph = new int[network.length + recover.length][3];
            for (int i = 0; i < network.length; i++) {
                graph[i] = new int[]{network[i][0], network[i][1], 0}; // 이미 연결된 부분은 비용을 0으로 넣고 진행?
            }
            for (int j = 0; j < recover.length; j++) {
                graph[j + network.length] = recover[j];
            }

            // 간선 비용 순으로 오름차순 정렬
            Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

            int[] parent = new int[]{1, 2, 3, 4, 5, 6}; // 아마 연결해야할 네트워크 총 개수를 제공했던것 같음

            if (!isConnected(graph)) return -1; // 노드가 연결되어 있지 않음
            else return kruskal(graph, parent);
        }

        static void union(int[] parent, int x, int y) {
            x = find(parent, x);
            y = find(parent, y);

            if (x < y) parent[y - 1] = x;
            else parent[x - 1] = y;
        }

        static int find(int[] parent, int i) {
            if (parent[i - 1] == i) return i;
            else return find(parent, parent[i - 1]);
        }

        static int kruskal(int[][] graph, int[] parent) {
            int cost = 0;

            for (int[] g : graph) {
                if (find(parent, g[0]) != find(parent, g[1])) {
                    cost += g[2];
                    union(parent, g[0], g[1]);
                }
            }
            return cost;
        }

        static boolean isConnected(int[][] graph) {
            Stack<Integer> st = new Stack<>();
            int[] visited = new int[6];

            st.push(graph[0][0]);
            visited[0] = 1;

            while (!st.isEmpty()) {
                int now = st.pop();
                for (int i = 0; i < graph.length; i++) {
                    if (graph[i][0] == now) {
                        int next = graph[i][1];
                        if (visited[next - 1] == 0) {
                            st.push(next);
                            visited[next - 1] = 1;
                        }
                    }
                }
            }

            for (int i : visited) {
                if (i == 0) return false; // 한번이라도 방문하지 않은 노드가 있음 = 트리가 끊어져 있음
            }

            return true;
        }

        public static void main(String[] args) {
            int[][] network = new int[][]{{1, 2}, {2, 3}, {4, 5}, {5, 6}};
            int[][] recover = new int[][]{{3, 4, 10}, {2, 6, 15}, {1, 3, 12}};

            int answer = solution(network, recover);
            System.out.println("answer = " + answer);
        }
    }

    class Solution2 {
        public static void main(String[] args) {
            Solution solution = new Solution();
            int n = 6;
            int[][] network = {{1, 2}, {3, 5}, {4, 2}, {5, 6}};
            int[][] repair = {{3, 2, 10}, {5, 4, 15}};

            long answer =
                    solution.solution(n, network, repair);
            System.out.println(answer);
        }


        static class Solution {
            public int solution(int n, int[][] network, int[][] repair) {
                List<Edge> list = new ArrayList<>();
                for (int i = 0; i < network.length; i++) {
                    list.add(new Edge(network[i][0], network[i][1], 0));
                }

                for (int i = 0; i < repair.length; i++) {
                    list.add(new Edge(repair[i][0], repair[i][1], repair[i][2]));
                }

                Collections.sort(list);

                int[] parent = new int[n + 1];


                for (int i = 1; i < parent.length; i++) {
                    parent[i] = i;
                }

                int count = 0;
                int answer = 0;
                for (int i = 0; i < list.size(); i++) {
                    Edge edge = list.get(i);
                    if (!findParent(parent, edge.node[0], edge.node[1])) {
                        count++;
                        answer+= edge.distance;
                        unionParent(parent, edge.node[0], edge.node[1]);
                    }
                }

                if (count != n - 1) {
                    answer = -1;
                }

                return answer;
            }

            public int getParent(int[] parent, int x) {
                if (parent[x] == x) {
                    return x;
                }
                return parent[x] = getParent(parent, parent[x]);
            }

            public void unionParent(int[] parent, int a, int b) {
                a = getParent(parent, a);
                b = getParent(parent, b);
                if (a < b) {
                    parent[b] = a;
                } else {
                    parent[a] = b;
                }
            }

            public boolean findParent(int[] parent, int a, int b) {
                a = getParent(parent, a);
                b = getParent(parent, b);
                return a == b;
            }
        }

        static class Edge implements Comparable<Edge> {

            public Edge(int a, int b, int distance) {
                node[0] = a;
                node[1] = b;
                this.distance = distance;
            }
            int[] node = new int[2];
            int distance;


            @Override
            public String toString() {
                return "Edge{" +
                        "node=" + Arrays.toString(node) +
                        ", distance=" + distance +
                        '}';
            }

            @Override
            public int compareTo(Edge o) {
                return distance - o.distance;
            }
        }
    }
}

