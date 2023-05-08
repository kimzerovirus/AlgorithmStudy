package me.kzv.programers;

import java.util.*;

public class 올바른괄호 {
    class Solution {
        boolean solution(String s) {
            int temp = 0;
            for(char c : s.toCharArray()){
                if(c == '(') temp += 1;
                else temp -= 1;
                if(temp < 0) return false;
            }

            if(temp == 0) return true;
            else return false;
        }
    }

    class Solution2 {
        boolean solution(String s) {
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if(c == '(') {
                    stack.add(c);
                } else {
                    try {
                        stack.pop();
                    } catch (EmptyStackException e) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }
    }
}
