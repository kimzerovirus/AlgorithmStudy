package me.kzv.programers;

import java.util.*;

public class 순위검색 {
    Map<String, Integer> WordMap = new HashMap();
    List<List<Integer>> ScoreList = new ArrayList();

    public int[] solution(String[] info, String[] query) {
        WordMap.put("-", 0);
        WordMap.put("cpp", 1);
        WordMap.put("java", 2);
        WordMap.put("python", 3);
        WordMap.put("backend", 1);
        WordMap.put("frontend", 2);
        WordMap.put("junior", 1);
        WordMap.put("senior", 2);
        WordMap.put("chicken", 1);
        WordMap.put("pizza", 2);

        // 총 108 개의 조합이 나오므로 먼저 점수 리스트를 만들어준다 - 메모리를 좀 더 쓰고 시간을 절약하기
        for (int i = 0; i < 4 * 3 * 3 * 3; i++) {
            ScoreList.add(new ArrayList<>());
        }

        for (String str : info) {
            String[] word = str.split(" ");
            int[] arr = {WordMap.get(word[0]) * 3 * 3 * 3
                    , WordMap.get(word[1]) * 3 * 3
                    , WordMap.get(word[2]) * 3
                    , WordMap.get(word[3])};
            int score = Integer.parseInt(word[4]);

            for (int i = 0; i < (1 << 4); i++) {
                int idx = 0;
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) != 0) {
                        idx += arr[j];
                    }
                }
                ScoreList.get(idx).add(score);
            }
        }

        for (int i = 0; i < 4 * 3 * 3 * 3; i++) {
            Collections.sort(ScoreList.get(i));
        }

        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String[] word = query[i].split(" ");

            int idx = WordMap.get(word[0]) * 3 * 3 * 3 + WordMap.get(word[2]) * 3 * 3 + WordMap.get(word[4]) * 3 + WordMap.get(word[6]);
            int score = Integer.parseInt(word[7]);
            int ret = Collections.binarySearch(ScoreList.get(idx), score);

            if (ret < 0) {
                ret = -(ret + 1);
            } else {
                for (int j = ret - 1; j >= 0; j--) {
                    if (ScoreList.get(idx).get(j) == score) {
                        ret = j;
                    } else {
                        break;
                    }
                }
            }
            answer[i] = ScoreList.get(idx).size() - ret;
        }

        return answer;
    }
}