package me.kzv.baekjoon;

import java.util.*;

public class Main {
    static ArrayDeque<Node> Snake = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] MAP = new int[N][N];
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            // 사과의 위치
            MAP[sc.nextInt()][sc.nextInt()] = 1;
        }
        int L = sc.nextInt();
        Queue<Direction> q = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            q.add(new Direction(sc.nextInt(), sc.nextLine()));
        }

        Snake.addFirst(new Node(0, 0));

        int time = 0;
        int lazy = 0;
        while (q.isEmpty()) {
            Node bam = Snake.peek();
            int y = bam.y;
            int x = bam.x;

            if(lazy == 0){
                Direction poll = q.poll();
                lazy = poll.time;
            }

        }
    }

    static int changeDirection(String c){
        if("D".equals(c)){
            return 0;
        } else if ("L".equals(c)) {
            return 0;
        }
        return 0;
    }

    static boolean isPossible(int[] position) {
        return Snake.contains(position);
    }

    static class Node {
        int y,x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Direction {
        int time;
        String dir;

        public Direction(int time, String dir) {
            this.time = time;
            this.dir = dir;
        }
    }
}