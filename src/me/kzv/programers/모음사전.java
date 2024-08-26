package me.kzv.programers;

import java.util.*;

public class 모음사전 {
    static final String[] words = {"", "A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList();

    public int solution(String word) {
        addWord(0, "");
        Collections.sort(list);

        return list.indexOf(word);
    }

    void addWord(int depth, String str) {
        if (depth == 5) {
            if (!list.contains(str)) list.add(str);
            return;
        }

        for (String word : words) {
            addWord(depth + 1, str + word);
        }
    }
}
