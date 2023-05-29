package me.kzv.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1331나이트투어 {
    static int[] dy = {-2, -2, -1, 1, 2, 2, -1, 1};
    static int[] dx = {-1, 1, 2, 2, -1, 1, -2, -2};

    static boolean check(int[] prev, int curY, int curX) {
        for (int i = 0; i < 8; i++) {
            if (curY + dy[i] == prev[0] && curX + dx[i] == prev[1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = 6;
        int[][] visited = new int[N][N];
        Queue<int[]> q = new LinkedList<>();

        boolean answer = true;

        // 시작점 채우기
        String s = sc.nextLine();
        int fy = s.charAt(0) - 'A';
        int fx = s.charAt(1) - '1';
        visited[fy][fx] = 1;
        q.add(new int[]{fy, fx});

        for (int i = 1; i < 36; i++) {
            String str = sc.nextLine();
            int y = str.charAt(0) - 'A';
            int x = str.charAt(1) - '1';

            if (visited[y][x] != 0) {
                answer = false;
                break;
            }

            if (check(q.poll(), y, x)) {
                visited[y][x] = 1;
                q.add(new int[]{y, x});
            } else {
                answer = false;
                break;
            }

            // 나이트 투어는 체스판에서 나이트가 모든 칸을 정확히 한 번씩 방문하며, 마지막으로 방문하는 칸에서 시작점으로 돌아올 수 있는 경로이다.
            if (i == 35) { // 종료지점에서 시작지점으로 갈 수 있어야함
                if (check(new int[]{y, x}, fy, fx)) {
                    break;
                }

                // 여기까지 왔다면 마지막 지점에서 시작 지점으로 돌아갈 수 없는 상황
                answer = false;
            }
        }

        for (int[] visits : visited) {
            for (int visit : visits) {
                if (visit == 0) {
                    answer = false;
                    break;
                }
            }
        }

        if (answer) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
