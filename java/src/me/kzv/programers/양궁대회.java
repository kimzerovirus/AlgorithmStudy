package me.kzv.programers;

import java.util.*;

public class 양궁대회 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);
            n -= enemy[i];

            if(n < 0){
                if(k > 0){
                    n += pq.poll();
                    k--;
                } else {
                    break;
                }
            }
            answer++;
        }

        return answer;
    }
}