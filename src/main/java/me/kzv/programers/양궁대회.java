package me.kzv.programers;

public class 양궁대회 {
    int[] apeach, ryan = new int[11], answer = new int[]{-1};
    int N, MAX = Integer.MIN_VALUE;

    public int[] solution(int n, int[] info) {
        apeach = info;
        N = n;

        dfs(0, 0);
        return answer;
    }

    void dfs(int depth, int idx) {
        if (depth == N) {
            getScore();
            return;
        }

        for (int i = idx; i < apeach.length && ryan[i] <= apeach[i]; i++) {
            ryan[i]++;
            dfs(depth + 1, idx);
            ryan[i]--;
        }
    }

    private void getScore() {
        int apeach_score = 0, ryan_score = 0;

        for (int i = 0; i < apeach.length; i++) {
            if (apeach[i] != 0 || ryan[i] != 0) {
                if (apeach[i] < ryan[i]) ryan_score += 10 - i;
                else apeach_score += 10 - i;
            }
        }

        if (ryan_score > apeach_score) {
            int diff = ryan_score - apeach_score;
            if (diff >= MAX) {
                MAX = diff;
                answer = ryan.clone();
            }
        }
    }
}

// 이 방법이 더 가지치기가 많이됨
class 양궁대회2 {
    int[] apeach, ryan = new int[11], answer = new int[]{-1};
    int MAX = Integer.MIN_VALUE;

    public int[] solution(int n, int[] info) {
        apeach = info;
        dfs(n, 0);

        return answer;
    }

    // arrow 남은 화살 수 score 탐색할 점수
    void dfs(int arrow, int score) {
        if (arrow == 0) {
            getScore();
            return;
        }

        for (int i = score; i < apeach.length && ryan[i] <= apeach[i]; i++) {
            if (i == 10) {
                ryan[i] = arrow;
                dfs(0, i + 1);
                ryan[i] = 0;
                continue;
            }

            // 이길 수 있는 경우의 수가 존재한다면
            if (arrow - apeach[i] > 0) {
                ryan[i] = apeach[i] + 1;
                dfs(arrow - ryan[i], i + 1);
                ryan[i] = 0;
            }
        }
    }

    void getScore() {
        int apeach_score = 0, ryan_score = 0;

        for (int i = 0; i < apeach.length; i++) {
            if (apeach[i] != 0 || ryan[i] != 0) {
                if (apeach[i] < ryan[i]) ryan_score += 10 - i;
                else apeach_score += 10 - i;
            }
        }

        if (ryan_score > apeach_score) {
            int diff = ryan_score - apeach_score;
            if (diff > MAX) {
                MAX = diff;
                answer = ryan.clone();
            } else if (diff == MAX) {
                for (int i = ryan.length - 1; i >= 0 && answer[i] <= ryan[i]; i--) {
                    if (answer[i] == 0 && ryan[i] == 0) continue;
                    answer = ryan.clone();
                    break;
                }
            }
        }
    }
}

// 가장 깔끔한 풀이 Bit를 이용한 부분집합, 완전 탐색(Exhaustive Search, Brute Force)
class 양궁대회3 {
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        int[] ryan = new int[11];
        int[] apeach = info;
        int maxDiff = 0;

        // 0을 선택하는 경우, 라이언이 이기는 경우가 없으므로 제외한 1 ~ 10점 2^10가지의 집합을 가지고 계산
        for (int subset = 1; subset < (1 << 10); subset++) {
            int apeach_score = 0, ryan_score = 0, arrow = 0;

            for (int i = 0; i < 10; i++) {
                if ((subset & (1 << i)) != 0) {
                    // 라이언이 이기는 경우
                    ryan_score += 10 - i;
                    ryan[i] = apeach[i] + 1;
                    arrow += ryan[i];
                } else {
                    // 어피치가 이기거나 비기는 경우
                    ryan[i] = 0;
                    if (info[i] > 0) apeach_score += 10 - i; // 어피치가 이긴 경우에만 점수 계산
                }
            }

            if (arrow > n) continue; //화살이 넘어간 경우

            // 여기까지 왔는데 남은 화살은 0점에 넣어버리면 된다
            ryan[10] = n - arrow;

            int diff = ryan_score - apeach_score;
            if (diff > maxDiff) {
                maxDiff = diff;
                answer = ryan.clone();
            } else if (diff == maxDiff) {
                for (int i = 10; i >= 0; i--) {
                    if (ryan[i] > answer[i]) { // 기존 답안보다 새로운 답안이 낮은 점수를 더 많이 맞춘것
                        answer = ryan.clone();
                        break;
                    } else if (ryan[i] < answer[i]) { // 기존답안이 낮은 점수를 더 많이 맞춘것이므로 종료
                        break;
                    }
                }
            }
        }

        // 경우의 수가 없음
        if(maxDiff == 0) return new int[]{-1};
        return answer;
    }
}