package me.kzv.programers;

public class 숫자의표현 {
    // 등차수열의 합 공식 이용
    static int solution(int n) {
        int answer = 0;

        for (int i = 1; n - (i * (i - 1) / 2) > 0; i++) {
            if ((n - (i * (i - 1) / 2)) % i == 0) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(15);
    }
}
