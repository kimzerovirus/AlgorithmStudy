package me.kzv.algorithm;

/**
 * Q. 연속된 숫자의 합이 K가 되는 경우의 수 구하기
 */
public class TwoPointer {
    static int[] arr = {3, 1, 4, 2, 8, 7, 5, 5};
    static int k = 10;

    public static void main(String[] args) {
        int a1 = nx2();
        System.out.println(a1);
        int a2 = twoPointer_same_direction();
        System.out.println(a2);
    }

    // 단순히 2중 for 문으로 구현한다면 - o(n^2)
    static int nx2() {
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum >= k) {
                    if (sum == k) {
                        answer++;
                    }
                    break;
                }
            }
        }

        return answer;
    }

    // 투 포인터, 시작 포인터와 끝 포인터 같은 지점에서 옮기며 작업 수행
    // 범위 ~ 까지의 합이
    static int twoPointer_same_direction() {
        int answer = 0;
        int sum = 0;

        // 같은 진행방향
        int start = 0;
        int end = 0;

        while (start < arr.length) {
            if (sum > k || end == arr.length) {
                sum -= arr[start];
                start++;
            } else {
                sum += arr[end];
                end++;
            }

            if (sum == k) answer++;
        }

        return answer;
    }

    // 투 포인터, 시작 포인터와 끝 포인터 맨앞과 맨뒤에서 포인터를 옮기며 작업 수행
    // 두 원소의 합이 ~
    static int twoPointer_different_direction() {
        int answer = 0;

        // 같은 진행방향
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] + arr[end] == k) {
                answer++;
            } else if (arr[start] + arr[end] > k) {
                end--;
            } else {
                start++;
            }
        }

        return answer;
    }
}
