package me.kzv.programers;

import java.util.*;

public class 보석쇼핑 {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int kind = new HashSet<>(Arrays.asList(gems)).size();
        Map<String, Integer> map = new HashMap<>();

        int L = 0, R = 0;
        int min = Integer.MAX_VALUE;
        while (true) {
            // 보석의 모든 종류가 모인 범위 중 가장 짧은 범위 담기
            if (kind == map.size()) {
                map.put(gems[L], map.get(gems[L]) - 1);

                int d = R - L;
                if (d < min) {
                    min = d;
                    answer[0] = L + 1;
                    answer[1] = R;
                }

                // 왼쪽 범위 한칸 줄이고 보석 map 에서 하나 줄이기
                if (map.get(gems[L]) == 0) map.remove(gems[L]); // 0이 되면 map 에서 삭제
                L++;
            } else {
                if (R == gems.length) break; // 배열 범위 끝까지 다 돌으면 탈출
                map.put(gems[R], map.getOrDefault(gems[R], 0) + 1);
                R++;
            }
        }

        return answer;
    }
}