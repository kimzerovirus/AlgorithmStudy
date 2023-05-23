package me.kzv.programers;

import java.util.*;

class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int cur = Integer.MIN_VALUE;
        for(int[] r : routes){
            if(r[0] > cur) {
                cur = r[1];
                answer++;
            }
        }

        return answer;
    }
}
