package me.kzv.programers;

import java.util.*;

public class 개인정보수집유효기간 {

    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            LinkedList<Integer> list = new LinkedList();
            String[] date = today.split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);

            HashMap<String, Integer> map = new HashMap();

            for(String term : terms){
                String[] s = term.split(" ");
                map.put(s[0], Integer.parseInt(s[1]));
            }

            int num = 1;
            for(String privacy : privacies){
                String[] sp = privacy.split(" ");
                String p_term = sp[1];
                String[] p_date = sp[0].split("\\.");
                int p_year = Integer.parseInt(p_date[0]);
                int p_month = Integer.parseInt(p_date[1]);
                int p_day = Integer.parseInt(p_date[2]);

                if(p_month + map.get(p_term) > 12) {
                    p_year += (p_month + map.get(p_term)) / 12;
                    p_month = (p_month + map.get(p_term)) % 12;
                    if(p_month == 0) {
                        p_year -= 1;
                        p_month = 12;
                    }
                } else {
                    p_month += map.get(p_term);
                }

                if(p_year < year) list.add(num);
                if(p_year == year) {
                    if(p_month < month) list.add(num);
                    if(p_month == month) {
                        if(p_day <= day) list.add(num);
                    }
                }

                num++;
            }

            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }

}



