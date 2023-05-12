package me.kzv.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11726타일링 {
    static int[] d = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int i = dp(n);
        System.out.println(i);
    }

    static int dp(int x) {
        if(x == 1) return 1;
        if(x == 2) return 2;
        if(d[x] != 0) return d[x];

        return d[x] = (dp(x - 1) + dp(x - 2)) % 10007;
    }
}
