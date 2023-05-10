package me.kzv.algorithm.search;

/**
 * 합집합 찾기, 서로소 집합
 */
public class UnionFind {

    public static void main(String[] args) {
        int[] parent = new int[11];

        for (int i = 0; i < 10; i++) {
            parent[i] = i;
        }

        union(parent, 1, 2);
        union(parent, 2, 3);
        union(parent, 3, 4);
        union(parent, 5, 6);
        union(parent, 6, 7);
        union(parent, 7, 8);

        int a = 5;
        int b = 8;
        System.out.println(a + "와 " + b + "는 연결되어 있는가? " + isConnected(parent, a, b));
    }

    // 부모 노드를 찾는 함수
    static int findParent(int parent[], int i) {
        if (parent[i] == i) return i; // 타고 들어가서 최상단 노드로
        return findParent(parent, parent[i]);
    }

    // 두 부모 노드를 합치는 함수 - 작은값으로
    static void union(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    // 같은 부모를 가지는지 확인
    static boolean isConnected(int parent[], int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);

        return a == b;
    }

}
