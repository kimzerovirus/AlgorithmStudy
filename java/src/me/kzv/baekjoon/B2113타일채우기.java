package me.kzv.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2113타일채우기 {
    static int[] dp = new int[31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

    }

    static int top(int n){
        if(n == 0) return 1;
        if(n == 1) return 0;
        if(n == 2) return 3;

        int result = 3 * top(n - 2);
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                result += 2 * top(n - i);
            }
        }
        return dp[n] = result;
    }

    static int bottom(int n){
        if (n % 2 == 1) {
            return 0;
        }

        dp[0] = 3;
        dp[1] = 11;
        int temp = 0;
        for (int i = 2; i < n / 2; i++) {
            dp[i] = dp[i - 1] * 3 + 2 + (temp += dp[i - 2] * 2);
        }

        return dp[n / 2 - 1];
    }

//    public static int (int x) {
//        if(x==0) return 1;
//        if(x==1) return 0;
//        if(x==2) return 3;
//        if(d[x]!=0) return d[x];
//        int result =3dp(x-2);
//        for(int i=3; i<=x; i++) {
//            if(i%2==0) {
//                result+= 2dp(x-i);
//            }
//        }
//        return d[x]=result;
//    }

}
