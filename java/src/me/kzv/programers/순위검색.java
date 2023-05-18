package me.kzv.programers;

import java.util.*;

public class 순위검색 {
    static final Map<String, Integer> WordMap = new HashMap() {
        {
            put("-", 0);
            put("cpp", 1);
            put("java", 2);
            put("python", 3);
            put("backend", 1);
            put("frontend", 2);
            put("junior", 1);
            put("senior", 2);
            put("chicken", 1);
            put("pizza", 2);
        }
    };
    static List<List<Integer>> ScoreList = new ArrayList();

    public int[] solution(String[] info, String[] query) {
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

    class Solution2 {
        public int[] solution(String[] info, String[] query) {
            int[] answer = new int[query.length];
            Map<String, List<Integer>> map = new HashMap<>();

            for (String s : info) {
                String[] data = s.split(" ");
                buildMap(0, data, "", map);
            }

            for (String key : map.keySet()) {
                Collections.sort(map.get(key));
            }

            for (int i = 0; i < query.length; i++) {
                query[i] = query[i].replaceAll(" and ", "");
                String[] q = query[i].split(" ");

                if (!map.containsKey(q[0])) {
                    answer[i] = 0;
                    continue;
                }

                answer[i] =  binarySearch(map.get(q[0]), Integer.parseInt(q[1]));
            }

            return answer;
        }

        public void buildMap(int index, String[] data, String selected, Map<String, List<Integer>> map) {
            if (index == 4) {
                if (!map.containsKey(selected)) {
                    map.put(selected, new ArrayList<>());
                }
                map.get(selected).add(Integer.parseInt(data[4]));
                return;
            }
            buildMap(index + 1, data, selected + data[index], map);
            buildMap(index + 1, data, selected + "-", map);
        }

        public int binarySearch(List<Integer> list, int score) {
            int start = 0;
            int end = list.size() - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (list.get(mid) < score) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return list.size() - start;
        }
    }
}