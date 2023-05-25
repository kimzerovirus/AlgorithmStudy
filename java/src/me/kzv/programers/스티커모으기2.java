package me.kzv.programers;

public class 스티커모으기2 {
    public int solution(int sticker[]) {
        int len = sticker.length;
        if(len == 1) return sticker[0];

        int[] dp1 = new int[len], dp2 = new int[len];
        dp1[0] = sticker[0]; // 연속해서 더해가므로 시작지점 부터 끝까지 넣어줘야함
        dp1[1] = sticker[0];

        for(int i = 2; i < len -1; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }

        dp2[1] = sticker[1];
        for(int i = 2; i < len; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }

        return Math.max(dp1[len - 2], dp2[len - 1]);
    }
}