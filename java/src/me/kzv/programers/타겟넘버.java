package me.kzv.programers;

import java.util.*;

public class 타겟넘버 {
    class Solution {
        static Stack<Integer> st = new Stack();
        static int answer = 0;

        public static void main(String[] args) {
            int sol = solution(new int[]{1,1,1,1,1}, 3);
            System.out.println(sol);
        }

        static int solution(int[] numbers, int target) {
            dfs(0, numbers, target);
            return answer;
        }

        static void dfs(int depth, int[] numbers, int target){
            if(depth == numbers.length){
                int sum = 0;
                int idx = 0;
                for(int num : st){
                    sum += num * numbers[idx++];
                }
                if(sum == target) answer++;
                return;
            }

            for(int i = 0; i < 2; i++) {
                if(i == 0) st.push(1);
                else st.push(-1);

                dfs(depth + 1, numbers, target);

                st.pop();
            }
        }
    }
}
