package me.kzv.programers;

public class 우캠박스1 {
    class Solution {
        static int MAX = 100000;

        public static void main(String[] args) {
            int[] box = new int[]{1000, 800, 900};
            int money = 1000000;
            int day = 3;

            int answer = solution(box, money, day);
            System.out.println(answer);
        }

        static int solution(int[] box, int money, int day){
            for (int i = 0; i < day; i++) {
                int temp = 0;
                for (int b : box) {
                    int earn = (money / 10000) * b;
                    if(earn <= MAX) temp = Math.max(temp, earn);
                }
                money += temp;
            }

            return money;
        }
    }
}


