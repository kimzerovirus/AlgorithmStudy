package me.kzv.programers;

import java.util.*;

public class 포켓몬 {
    class Solution {
        public int solution(int[] nums) {
            HashSet set = new HashSet();
            Arrays.stream(nums).forEach(set::add);

            return Math.min(set.size(), nums.length / 2);
        }
    }
}

// 중복을 허용하여 서로 다른 n개 중 r개를 순서 있게 나열하는 경우의 수 n^r
