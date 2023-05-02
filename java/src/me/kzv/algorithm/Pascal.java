package me.kzv.algorithm;

import java.util.Scanner;

// Pascal's triangle
// 이항 계수를 삼각형 모양으로 배열한 것
// 조합 combination : nCr = n! / r! * (n-r)!
public class Pascal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        int result = combination(n, r);

        System.out.println(result);
    }

    private static int combination(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    // 이렇게 팩토리얼을 사용하게 된다면 금방 수가 커져서 int 의 범위를 벗어나게 될 가능성이++
    static int factorial(int num) {
        int rtn = 1;
        for (int i = 1; i < num; i++) {
            rtn *= i;
        }
        return rtn;
    }

    // 파스칼의 삼각형 - 조합이 가지고 있는 성질 n-1Cr-1 + n-1Cr = nCr 을 이용
    static void pascal(){
        int N = 20;
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            matrix[i][0] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
            }
        }
    }
}
