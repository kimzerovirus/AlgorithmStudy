package me.kzv.algorithm.search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
    -------------------------------
      0
     /
    1 -- 3    7
    |  / | \ /
    | /  |  5
    2 -- 4   \
              6 - 8
    -------------------------------
    DFS(0)
    0 1 3 5 7 6 8 4 2
    BFS(0)
    0 1 2 3 4 5 6 7 8
    DFS(0) - Recursive
    0 1 2 4 3 5 6 8 7
    -------------------------------

 */
public class Search {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        // 위와 같이 관계 매핑
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(5,6);
        g.addEdge(5,7);
        g.addEdge(6,8);

//        g.dfs();
//        g.bfs();
        g.dfsR();
    }
}

class Graph {
    Node[] nodes;

    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    // 두 노드의 관계를 저장
    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        // 인접 노드 저장
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfs(){
        dfs(0);
    }

    void dfs(int idx) {
        Node root = nodes[idx];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.isVisited = true;
        while (!stack.isEmpty()) {
            Node r = stack.pop();
            for (Node n : r.adjacent) {
                if (!n.isVisited) {
                    n.isVisited = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    void dfsR(Node r) {
        if(r == null) return;
        r.isVisited = true;
        visit(r);
        for (Node n : r.adjacent) {
            if (!n.isVisited) {
                dfsR(n);
            }
        }
    }

    void dfsR(int idx) {
        Node r = nodes[idx];
        dfsR(r);
    }

    void dfsR(){
        dfsR(0);
    }

    void bfs(){
        bfs(0);
    }

    void bfs(int idx) {
        Node root = nodes[idx];
        Queue<Node> queue = new LinkedList<>(); // 자바 큐 -> add, offer, poll, remove, clear, clear
        queue.add(root);
        root.isVisited = true;
        while (!queue.isEmpty()) {
            Node r = queue.poll();
            for (Node n : r.adjacent) {
                if(!n.isVisited){
                    n.isVisited = true;
                    queue.add(n);
                }
            }
            visit(r);
        }
    }

    void visit(Node n) {
        System.out.print(n.data + " ");
    }

    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean isVisited;

        public Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList<>();
            this.isVisited = false;
        }
    }
}
