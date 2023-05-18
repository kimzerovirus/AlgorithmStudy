package me.kzv.algorithm;

// 순열
// 두 수를 선택하여 가장 큰 값 만들기
public class Permutation {
    static int N = 4;
    static int[] Nums = {1, 5, 4, 1};

    static int solve(int cnt, int used, int val) {
        if (cnt == 2) return val; // 2개의 숫자를 고르면 종료

        int ret = 0;
        for (int i = 0; i < N; i++) {
            if ((used & 1 << i) != 0) continue;
            ret = Math.max(ret, solve(cnt + 1, used | 1 << i, val * 10 + Nums[i]));
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(solve(0, 0, 0));
    }
}
