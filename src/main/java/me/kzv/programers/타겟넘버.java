package me.kzv.programers;

import java.util.*;

public class 타겟넘버 {

    public static void main(String[] args) {
        int sol = Solution.solution(new int[]{1, 1, 1, 1, 1}, 3);
//        int sol = Solution2.solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(sol);
    }

    class Solution {
        static Stack<Integer> st = new Stack();
        static int answer = 0;

        static int solution(int[] numbers, int target) {
            dfs(0, numbers, target);
            return answer;
        }

        static void dfs(int depth, int[] numbers, int target) {
            if (depth == numbers.length) {
                int sum = 0;
                int idx = 0;
                for (int num : st) {
                    sum += num * numbers[idx++];
                }
                if (sum == target) answer++;
                return;
            }

            for (int i = 0; i < 2; i++) {
                if (i == 0) st.push(1);
                else st.push(-1);

                dfs(depth + 1, numbers, target);

                st.pop();
            }
        }
    }

    class Solution2 {
        static int solution(int[] numbers, int target) {
           return dfs(numbers, 0, 0, target);
        }

        static int dfs(int[] numbers, int n, int sum, int target) {
            if (n == numbers.length) {
                if (sum == target) {
                    return 1;
                }
                return 0;
            }

            return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
        }
    }
}
