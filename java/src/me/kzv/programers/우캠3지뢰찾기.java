package me.kzv.programers;

import java.util.Arrays;

public class 우캠3지뢰찾기 {
    class Solution {
        static String[][] map, result;
        static int yLength, xLength;
        static final int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
        static final int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};

     /*
       방향 x,y 증가 값 (북서 -> 북 -> 북동 -> 동 -> 동남 -> 남 -> 남서 -> 서)

          (x=-1, y=-1)  (x=0, y=-1)  (x=1, y=-1)
                      \      |      /
        (x=-1, y=0) <-- (x=0, y=0) --> (x=1, y=0)
                      /      |      \
          (*x=-1, y=1)  (x=0, y=1)   (x=1, y=1)
     */

        static String[] solution(String[] list, int y, int x) {
            yLength = list.length; // 멥의 세로 길이
            xLength = list[0].length(); // 맵의 가로 길이
            map = new String[yLength][xLength];
            result = new String[yLength][xLength];

            for (int ny = 0; ny < yLength; ny++) {
                String[] temp = list[ny].split("");
                for (int nx = 0; nx < xLength; nx++) {
                    map[ny][nx] = temp[nx];
                    result[ny][nx] = "E";
                }
            }


            if (map[y][x].equals("M")) {
                go(y, x, true); // 지뢰를 누른 경우 전체를 탐색
            } else {
                go(y, x, false); // 지뢰 전까지 탐색
            }

            // 처음에 선택한 지점 표시
            result[y][x] = "X";

            return joinArr(result);
        }

        static String[] joinArr(String[][] result) {
            return Arrays.stream(result).map(arr -> String.join("", arr)).toArray(String[]::new);
        }

        static void go(int y, int x, boolean flag) {
            if (y < 0 || x < 0 || y >= yLength || x >= xLength) return; // 맵의 좌표 범위를 넘어서는 경우
            if (!result[y][x].equals("E")) return; // 이미 방문한 노드
            if (flag) { // 정답을 보여줘야하는 경우
                result[y][x] = countMine(y, x);
            } else { // 선택 지점에 대한 지뢰 탐색만 해야하는 경우
                String m = countMine(y, x);
                result[y][x] = m;
                if (!m.equals("B")) return; // 탐색 결과 현재 노드가 빈공간이 아닌 경우 탐색 종료
            }

            // 위로 탐색
            go(y - 1, x, flag);

            // 아래로 탐색
            go(y + 1, x, flag);

            // 왼쪽으로 탐색
            go(y, x - 1, flag);

            // 오른쪽으로 탐색
            go(y, x + 1, flag);
        }

        static String countMine(int y, int x) {
            if (map[y][x].equals("M")) return "M";

            int count = 0;

            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (0 <= ny && ny < yLength && 0 <= nx && nx < xLength) {
                    if (map[ny][nx].equals("M")) count++;
                }
            }

            return count > 0 ? String.valueOf(count) : "B";
        }

        public static void main(String[] args) {
            // 지뢰 M 빈 공간 B 탐색되지 않은 공간 E
            String[] list = new String[]{
                    "EEMEE",
                    "EMEEE",
                    "EEEEE"
            };

            String[] answer = solution(list, 1, 4);

            System.out.println("=====맵=====");
            for (String[] m : map) {
                System.out.println(Arrays.toString(m));
            }
            System.out.println("=====결과=====");
            for (String[] m : result) {
                System.out.println(Arrays.toString(m));
            }
            System.out.println();

            System.out.println(Arrays.toString(answer));
        }
    }
}



