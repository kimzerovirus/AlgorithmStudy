package me.kzv.algorithm;

// 참고: https://injae-kim.github.io/dev/2020/07/23/all-about-kmp-algorithm.html
/**
 * 문자열 검색 알고리즘
 * KMP 알고리즘의 시간 복잡도는 O(N+M)으로 위의 무식한 방법 O(NM) 보다 빠름
 * <p>
 * <구현 방법>
 * 1. 접미사, 접두사
 * - banana의 접두사(prefix) 예시
 * b
 * ba
 * ban
 * bana
 * banan
 * banana
 * <p>
 * - banana의 접미사(suffix) 예시
 * a
 * na
 * ana
 * nana
 * anana
 * banana
 * <p>
 * 2. pi 배열 (접미사와 접두사 일치하는 부분 길이 배열)
 * pi[i]는 주어진 문자열의 0~i 까지의 부분 문자열 중에서 prefix == suffix가 될 수 있는 부분 문자열 중에서 가장 긴 것의 길이를 의미
 * (이때 prefix가 0~i  까지의 부분 문자열과 같으면 안된다.)
 * <p>
 * 일일히 하나하나 글자를 비교하지 않고 접미사와 접두사가 일치하는 부분을 찾아서 점프해 나가면서 시간 단축하는 알고리즘인듯
 */

public class KMP {
    final static String text = "aklewjfkafljawlkefafjlkasdjlsafdkfjklsdaf";
    final static String pattern = "af";

    public static void main(String[] args) {
        int bf = BruteForceMatch(text, pattern);
        System.out.println(bf);

        int kmp = kmpMatch(text, pattern);
        System.out.println(kmp);
    }

    // O(n * m) 일일히 문자열 비교하고 카운팅
    static int BruteForceMatch(String text, String pattern) {
        char[] chars = text.toCharArray();
        char[] patterns = pattern.toCharArray();

        int count = 0;
        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            int j = 0;
            while (j < pattern.length() && chars[i + j] == patterns[j]) {
                j++;

                // match point starts on i
                if (j == patterns.length) count++;
            }
        }

        return count;
    }

    static int kmpMatch(String text, String pattern) {
        char[] chars = text.toCharArray();
        char[] patterns = pattern.toCharArray();
        int n = chars.length;
        int m = patterns.length;

        // 탐색할 문자열의 접두사와 접미사가 일치하는 길이를 문자열의 처음부터 끝까지 미리 계산
        int[] pi = getPi(patterns);

        int count = 0;
        int begin = 0, matched = 0;

        while (begin <= n - m) {
            // 탐색할 문자열과 원본 문자열에서 현재 위치의 문자가 동일한 경우
            if (matched < m && chars[begin + matched] == patterns[matched]) {
                matched++;

                // 문자열이 모두 일치하는 경우
                if (matched == m) count++;
            } else {
                // 일치하는 부분이 없는 경우, 다음 위치의 문자 부터 탐색
                if (matched == 0) {
                    begin++;
                } else {
                    // 문자열이 불일치 하므로 접두사, 접미사의 길이 만큼 건너뛴다
                    // 현재 불일치가 발생한 위치는 begin + matched
                    // 접두사와 접미사의 길이인 pi[matched-1] 을 빼주면 다음 탐색 시작 위치
                    begin += matched - pi[matched - 1];
                    matched = pi[matched - 1];
                }
            }
        }

        return count;
    }

//    private static int[] getPi(char[] patterns) {
//        int l = patterns.length;
//        int[] pi = new int[l];
//
//        // 탐색 문자열의 처음부터 끝까지 모두 비교해 보면서 접두사, 접미사의 길이 계산 - 결국 이 방법도 2중 for 라 별로임
//        for (int begin = 1; begin < l; begin++) {
//            for (int i = 0; begin + i < l; i++) {
//                if (patterns[begin + i] != patterns[i]) break;
//                pi[begin + i] = Math.max(pi[begin + i], i + 1);
//            }
//        }
//
//        return pi;
//    }

    private static int[] getPi(char[] patterns) {
        int l = patterns.length;
        int[] pi = new int[l];

        int begin = 1, matched = 0;

        while (begin + matched < l) {
            // 매칭 되는 문자열 찾기
            if (patterns[begin + matched] == patterns[matched]) {
                matched++;
                pi[begin + matched - 1] = matched; // 매칭 진행하며, 접두사 접미사 배열 갱신
            } else {
                if( matched == 0) {
                    begin++;
                } else {
                    // KMP 와 동일하게 불일치 발생 시
                    // 매칭을 진행하며 구했던 접두 접미사 길이 만큼 탐색 건너뛰기
                    begin += matched - pi[matched - 1];
                    matched = pi[matched - 1];
                }
            }
        }

        return pi;
    }
}
