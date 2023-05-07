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
