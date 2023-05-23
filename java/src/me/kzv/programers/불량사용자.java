package me.kzv.programers;

import java.util.*;

public class 불량사용자 {
    static Set<Set<String>> answer = new HashSet();
    static Set<String> set = new HashSet();
    static List<String> visited = new ArrayList<>();
    static List<List<String>> list = new ArrayList();

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
    }

    public static int solution(String[] user_id, String[] banned_id) {

        // 밴후보군
        for (int i = 0; i < banned_id.length; i++) {
            list.add(new ArrayList<>());
        }

        int idx = 0;
        for (String ban : banned_id) {
            for (String user : user_id) {
                if (ban.length() == user.length()) {
                    if (check(ban, user)) {
                        list.get(idx).add(user);
                    }
                }
            }
            idx++;
        }

        go(0);

        return answer.size();
    }

    static boolean check(String ban, String user) {
        for (int i = 0; i < ban.length(); i++) {
            if (ban.charAt(i) != '*' && ban.charAt(i) != user.charAt(i))
                return false;
        }
        return true;
    }

    static void go(int cnt) {
        if (cnt == list.size()) {
            answer.add(new HashSet<>(set)); // 전역에 있는 set을 가지고 하다보니 주소 참조로 인한 에러가 있는 듯 따라서 새로운 set을 만들어서 담아서 해결
            return;
        }

        for (String ban : list.get(cnt)) {
            if (!visited.contains(ban)) {
                visited.add(ban);
                set.add(ban);
                go(cnt + 1);
                visited.remove(ban);
                set.remove(ban);
            }
        }
    }
}
