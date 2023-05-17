package me.kzv.algorithm;

/**
 * & AND x&y 두 비트가 모두 1일 경우에만 1
 * | OR x|y 두 비트 중에서 하나라도 1이면 1
 * ^ XOR x^y 두비트가 같으면 0, 다르면 1
 * ~ NOT x~y 각 비트를 반적, 0이면 1, 1이면 0
 * << LEFT SHIFT x<<2 비트를 왼쪽으로 이동, 하나 이동할 때마다 곱하기 2
 * x = 0000 0001(2) = 1 -> 0000 0100(2) = 4
 * >> RIGHT SHIFT x>>2 비트를 오른쪽으로 이동, 하나 이동할 때마다 나누기 2
 * x = 0000 0100(2) = 4 -> 0000 0001(2) = 1
 * <p>
 * n개에서 부분집합의 개수는 2^n 이다.
 * 비트를 이용한 부분집합
 * 0    0000    {}
 * 1    0001    {A}
 * 2    0010    {B}
 * 3    0011    {A,B}
 * 4    0100    {C}
 * 5    0101    {A,C}
 * 6    0110    {B,C}
 * 7    0111    {A,B,C}
 * 8    1000    {D}
 * 9    1001    {A,D}
 * 10   1010    {B,D}
 * 11   1011    {A,B,D}
 * 12   1100    {B,C}
 * 13   1101    {A,C,D}
 * 14   1110    {B,C,D}
 * 15   1111    {A,B,C,D}
 */
public class BitMask {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D'};
//        printSubsets(data);
        q1두수의_합이_7인_경우의수();
    }

    private static void printSubsets(char[] arr) {
        // 부분 집합의 총 개수는 1 << n = 1 * 2^n
        for (int i = 0; i < (1 << arr.length); i++) {
            System.out.print(i + " : " + "{ ");

            for (int j = 0; j < arr.length; j++) {
                /**
                 *  j   1 << j
                 *  0   0001
                 *  1   0010
                 *  2   0100
                 *  3   1000
                 *
                 *  ex) i 가 7일 경우에
                 *  7 = 0111(2)
                 *  반복문을 돌면서 조건문이 0이 아닌 값은
                 *  0   0001
                 *  1   0010
                 *  2   0100 의 경우에서 arr[j] 가 출력되게 된다
                 */
                if ((i & 1 << j) != 0) System.out.print(arr[j] + " ");
            }

            System.out.println("}");
        }
    }

    static void q1두수의_합이_7인_경우의수(){
        int N = 6;
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};

        int ret = 0;
        for (int i = 0; i < (1 << N); i++) {
            if(Integer.bitCount(i) != 2) continue; // 두 수로 제한

            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) != 0) {
                    sum += arr[j];
                }
            }

            if(sum == 7) ret++; // {1,6} {2,5} {3,4}
        }

        System.out.println(ret);
    }
}

/**
 * 집합에 비트 연산 활용
 * 1. i번째 원소가 있는지 확인
 *  - (비트로 표현된 집합) & (1 << i) 결과가 0이 아니면 존재
 * 2. i번째 원소를 추가
 *  - (비트로 표현된 집합) | (1 << i)
 *  - ex) 1번째 원소를 추가
 *      - 0101 & (1 << 1) 0101 | 0010 = 0111
 * 3. i번째 원소를 삭제
 *  - (비트로 표현된 집합) % ~(1 << i)
 *  - ex) 2번째 원소를 삭제
 *      - 0101 & ~(1 << 2) = 0101 & ~(0100) = 0101 & 1011 = 0001
 *
 * 집합의 원소 개수 세는 방법
 * Integer.bitCount(int i) <- 1인 bit 의 개수를 세어줌
 *
 * 직접 구현시
 * int countBits(int n){
 *     int ret = 0;
 *     while(n != 0){
 *         if((n & 1) != 0) ret++;
 *         n = n >> 1
 *     }
 *     return ret;
 * }
 */