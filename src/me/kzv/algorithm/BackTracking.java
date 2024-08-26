package me.kzv.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 퇴각 검색 - 갈림길에서 일정한 규칙을 따라(일반적으로 오름차순) 이동하다가 마지막 지점에 도착하면 직전 갈림길로 퇴각한 후 다시 검색 시작 - DFS 와 비슷 한듯?
 * DFS 와의 차이 - DFS 는 모든 경우의 수를 탐색하는 것이지만 백 트래킹은 현재 가는 길이 더 이상 맞는 해가 아니라면 퇴각한 후 다시 검색한다.
 * <p>
 * 백트래킹을 적용해야 하는 경우
 * - 일정한 크기의 조건들이 주어져 있고, 그 안에서 완전탐색을 통해 최적비용 또는 최적 경로를 탐색해야 하는 경우
 * - 각 조건에서 선택할 수 잇는 경우의 수가 정해져 있을 경우(2차원 배열 등)
 */
public class BackTracking {
}

class ThrowDice {
    static int N;
    static int[] result;

    public static void main(String[] args) {
        // 주사위 N개를 던져서 나올 수 있는 경우의 수 모두 출력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        result = new int[N];
        int diceNum = 0; // 0 ~ (N-1)번 주사위 까지

        throwDiceR(diceNum);
    }

    static void throwDiceR(int diceNum) {
        if (diceNum == N) {
            System.out.println(Arrays.toString(result)); // 주사위 N번 까지 다 돌으면 출력
            return;
        } else {
            for (int i = 1; i <= 6; i++) {
                result[diceNum] = i; // n번 주사위에 값 설정
                diceNum += 1;
                throwDiceR(diceNum); // n+1 주사위 호출
                diceNum -= 1;
                result[diceNum] = 0;
            }
        }
    }
}

class NRooks {
    /*
        -------------
        | * |   |   |
        -------------
        |   | * |   |
        -------------
        |   |   | * |
        -------------

        -------------
        |   | * |   |
        -------------
        | * |   |   |
        -------------
        |   |   | * |
        -------------
     */
    static int N;
    static int[][] map;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new int[N];
        int row = 0;

        locate(row);
    }

    static void locate(int row) {
        if (row == N) {
            print();
            return;
        } else {
            for (int col = 0; col < N; col++) {
                if (visited[col] != 1) {
                    // 값 채우기
                    map[row][col] = 1;
                    visited[col] = 1;
                    row += 1;
                    System.out.println("+실행" + Arrays.toString(visited));

                    locate(row);
                    // 원상복귀
                    row -= 1;
                    visited[col] = 0;
                    System.out.println("-실행" + Arrays.toString(visited));
                    map[row][col] = 0;
                }
            }
        }
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println("-----------------");
    }
}

class MinSum {
    static int N;
    static int[][] map;
    static int[] visited;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new int[N];
        result = 0;

        // map 에 값 채우기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int row = 0, sum = 0;
        selectNum(row, sum);

        System.out.println(result);
    }

    private static void selectNum(int row, int sum) {
        if (row == N) {
            result = Math.min(result, sum);
            return;
        } else {
            for (int col = 0; col < N; col++) {
                if (visited[col] + 1 != 1) {
                    sum += map[row][col];
                    row += 1;

                    selectNum(row, sum);

                    row -= 1;
                    visited[col] = 0;
                    sum -= map[row][col];
                }
            }
        }
    }
}

class MaxSum {
    // 최대한 음식 주문하기
    static String[] menu;
    static int[] price;
    static int limit;

    static int[] visited;
    static ArrayList<String> orderList;
    static int totalPrice;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        limit = sc.nextInt(); // 소지금

        menu = new String[]{"치킨", "피자", "족발", "자장면", "곱창", "분식", "회"};
        price = new int[]{20000, 30000, 40000, 7000, 32000, 15000, 36000};

        visited = new int[menu.length];

        totalPrice = 0; // 최종 합계
        orderList = new ArrayList<>(); // 최종 주문 리스트

        int priceSum = 0; // 임시
        ArrayList<String> tempOrder = new ArrayList<>(); // 임시

        order(priceSum, tempOrder);

        System.out.println(totalPrice);
        System.out.println(orderList);
    }

    private static void order(int priceSum, ArrayList<String> tempOrder) {
        if (priceSum > limit) {
            return;
        } else {
            totalPrice = priceSum;
            orderList = (ArrayList<String>) tempOrder.clone();
        }

        for (int i = 0; i < 7; i++) {
            if (visited[i] == 0) {
                tempOrder.add(menu[i]);
                priceSum += price[i];
                visited[i] = 1;

                order(priceSum, tempOrder);

                visited[i] = 0;
                priceSum -= price[i];
                tempOrder.remove(menu[i]);
            }
        }
    }
}