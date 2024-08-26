package me.kzv.programers;

import java.util.*;

public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);
            n -= enemy[i];

            if (n < 0) {
                if (k == 0) break;
                n += pq.poll();
                k--;
            }
            answer++;
        }

        return answer;
    }
}