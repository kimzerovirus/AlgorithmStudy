package me.kzv.programers;

public class 택배배달과수거하기 {

    // 뒤에서 부터 생각해서 돌려야함
    // 맨 끝에서 부터 채워간다고 생각하면 배달과 수거 칸을 다르게 생각해도 된다.
    // 제한 사항 1 ≤ n ≤ 100,000 -> o(n^2) 풀이로는 불가능
    class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;
            int d = 0, p = 0;

            // 1. 가장 마지막에서 부터 배달할 것
            // 2. 마지막 부터 배달을 하므로 수거할 때는 차가 빈 상태가 된다. -> 배달과 수거를 분리해서 생각해도됨
            for(int i = n - 1; i >= 0; i--){
                int cnt = 0; // 왕복 횟수
                d -= deliveries[i];
                p -= pickups[i];

                while(d < 0 || p < 0){
                    d += cap;
                    p += cap;
                    cnt += 1;
                }

                answer += (long) (i + 1) * 2 * cnt; // i가 인덱스인 0부터 시작했으므로 거리로 변환시에 1로 바꾸어야함 * 왕복 * 왕복횟수
            }

            return answer;
        }
    }

}


