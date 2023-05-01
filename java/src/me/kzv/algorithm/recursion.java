package me.kzv.algorithm;

public class recursion {
    public static void main(String[] args) {
        System.out.println(factorial(1, 1, 5));
        // 1 * 2 * 3 * 4 * 5 = 120
    }

    // 메서드 간의 변수를 이용했지만 전역으로도 이용할 수 있을 것이다.
    static int factorial(int result, int num, int end) {
        if (num > end){
            return result;
        } else {
            result = result * num;
            num += 1;
            return factorial(result, num, end);
        }
    }
}
