package me.kzv.baekjoon;

import java.util.*;

public class B16235나무재테크 {
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt(); // K년 후

        int[][] A = new int[N][N]; // 양분 정보
        int[][] S2D2 = new int[N][N]; // 추가되는 양분
        Queue<Tree> trees = new PriorityQueue<>(); // 심은 나무 정보 (x,y)좌표, z개수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = 5; // 초기 양분은 5
                S2D2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            trees.add(new Tree(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()));
        }

        while (K-- > 0) {
            ArrayList<Tree> temp = new ArrayList<>();
            Queue<Tree> dt = new LinkedList<>();

            // 1. 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 증가하며, 양분은 나이가 어린 나무부터 먹는다
            while (!trees.isEmpty()) {
                Tree tree = trees.poll();
                // 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.

                if (A[tree.y][tree.x] - tree.age < 0) {
                    // 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다
                    dt.add(new Tree(tree.y, tree.x, tree.age / 2));
                } else {
                    temp.add(new Tree(tree.y, tree.x, tree.age + 1)); // 생존한 나무
                    A[tree.y][tree.x] -= tree.age;
                }
            }

            // 2. 여름에는 죽은 나무가 나이/2 만큼 양분으로 변환됨
            while(!dt.isEmpty()){
                Tree tree = dt.poll();
                A[tree.y][tree.x] += tree.age;
            }

            // 3. 가을에는 나무 번식
            //      - 번식하는 나무는 나이가 5의 배수여야함
            //      - 인접한 8개의 칸에 나이가 1인 나무가 생김
            //      - 땅을 벗어나는 칸에는 생성되지 않음
            for (Tree tree: temp) {
                if (tree.age % 5 == 0) {
                    for (int i = 0; i < 8; i++) {
                        int ny = tree.y + dy[i];
                        int nx = tree.x + dx[i];

                        if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                        trees.add(new Tree(ny, nx, 1));
                    }
                }
            }

            // 4. 겨울에는 S2D2가 양분을 S2D2[i][j] 만큼씩 추가
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[i][j] += S2D2[i][j];
                }
            }

            trees.addAll(temp);
        }

        System.out.println(trees.size());
    }

    static class Tree implements Comparable<Tree> {
        int y, x, age;

        public Tree(int y, int x, int age) {
            this.y = y;
            this.x = x;
            this.age = age;
        }

        @Override
        public int compareTo(Tree t) {
            return this.age - t.age;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "y=" + y +
                    ", x=" + x +
                    ", age=" + age +
                    '}';
        }
    }
}


