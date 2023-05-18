package me.kzv.algorithm;

// 조합
// 가장 큰 두 수의 합 구하기
public class Combination {
    static int N = 4;
    static int[] Nums = {1, 2, 3, 4};

    static int solve(int pos, int cnt, int val) {
        if (cnt == 2) return val;
        if (pos == N) return -1;

        int ret = 0;
        ret = Math.max(ret, solve(pos + 1, cnt + 1, val + Nums[pos])); // 첫번째 숫자가 구해지면
        ret = Math.max(ret, solve(pos + 1, cnt, val)); // 두번째 숫자를 구한다

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(solve(0, 0, 0));
    }
}
