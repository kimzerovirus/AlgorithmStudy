package me.kzv.programers;

import java.util.Arrays;

public class 완주하지못한참가자 {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            Arrays.sort(participant);
            Arrays.sort(completion);

            answer = participant[participant.length - 1];
            for(int i = 0; i < participant.length - 1; i++){
                if(!participant[i].equals(completion[i])) {
                    answer = participant[i];
                    break;
                }
            }

            return answer;
        }
    }
}
