package me.kzv.programers;

import java.util.*;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";
        Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, (a, b) ->
                Integer.parseInt(String.valueOf(b) + a) - Integer.parseInt(String.valueOf(a) + b)
        );

        StringBuilder sb = new StringBuilder();
        for (Integer num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    public String solution2(int[] numbers) {
        String answer = "";

        List<String> list = new ArrayList<>();

        for (int number: numbers) {
            list.add("" + number);
        }

        Collections.sort(list, (s1, s2) -> (s2+s1).compareTo(s1+s2));

        for (String str: list) {
            answer += str;
        }

        if (answer.startsWith("0")) {
            return "0";
        }

        return answer;
    }
}