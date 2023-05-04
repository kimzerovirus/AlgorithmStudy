package me.kzv.programers;

import java.util.*;

public class 이모티콘할인행사 {

    // dfs + 백트래킹
    class Solution {
        static int[] discountedRates = {10, 20, 30, 40};
        static Stack<Emoticon> discountedEmoticons = new Stack<>();
        static int ePlus = 0, totalPrice = 0;

        public int[] solution(int[][] users, int[] emoticons) {
            //중복 순열을 위한 재귀함수
            dfs(0, users, emoticons);

            return new int[]{ePlus, totalPrice};
        }

        public static void dfs(int depth, int[][] users, int[] emoticons) {
            if (depth == emoticons.length) {
                int allUserTotalPrice = 0;
                int join = 0;
                for (int[] user : users) {
                    int userPercent = user[0];
                    int userPrice = user[1]; // 구매한도
                    int userTotalPrice = 0; //개인이 구매한 이모티콘 금액의 합

                    for (Emoticon discountedEmoticon : discountedEmoticons) {
                        if (discountedEmoticon.percent >= userPercent) userTotalPrice += discountedEmoticon.price;
                    }

                    if (userTotalPrice >= userPrice)
                        join++;
                    else {
                        allUserTotalPrice += userTotalPrice;
                    }

                    if (ePlus < join) {
                        totalPrice = allUserTotalPrice;
                        ePlus = join;
                    } else if (ePlus == join && totalPrice < allUserTotalPrice) {
                        totalPrice = allUserTotalPrice;
                    }
                }
                return;
            }

            for (int rate : discountedRates) {
                discountedEmoticons.add(new Emoticon((100 - rate) * emoticons[depth] / 100, rate));

                dfs(depth + 1, users, emoticons);
//            System.out.println(depth);
//            System.out.println(discountedEmoticons);
                discountedEmoticons.pop();
            }
        }

        static class Emoticon {
            int price;
            int percent;

            Emoticon(int price, int percent) {
                this.price = price;
                this.percent = percent;
            }

            @Override
            public String toString(){
                return "price : "+price+" / " + "percent : " + percent;
            }
        }
    }
}


//class Solution {
//
//    private static final int[] RATE = {90, 80, 70, 60};
//    private static int EMOTICON_PLUS = 0;
//    private static int TOTAL_SALES = 0;
//
//    public int[] solution(int[][] users, int[] emoticons) {
//        getPrices(emoticons, users, 0, new int[emoticons.length]);
//        return new int[]{EMOTICON_PLUS, TOTAL_SALES};
//    }
//
//    private void getPrices(int[] emoticons, int[][] users, int cur, int[] rates) {
//        if (cur == emoticons.length) { // 조합이 완성된 상태
//            updateAnswer(emoticons, users, rates);
//            return;
//        }
//
//        for (int rate : RATE) {
//            rates[cur] = rate;
//            getPrices(emoticons, users, cur + 1, rates);
//        }
//    }
//
//    private void updateAnswer(int[] emoticons, int[][] users, int[] rates) {
//
//        int ePlus = 0;
//        int totalExpense = 0;
//
//        for (int[] user : users) {
//            int expense = 0;
//            int rate = user[0];
//            int price = user[1];
//            for (int i = 0; i < rates.length; i++) {
//                if (100 - rates[i] >= rate) {
//                    expense += emoticons[i] * rates[i] / 100;
//                }
//                if (expense >= price) {
//                    ePlus += 1;
//                    expense = 0;
//                    break;
//                }
//            }
//            totalExpense += expense;
//        }
//
//        if (ePlus > EMOTICON_PLUS) {
//            EMOTICON_PLUS = ePlus;
//            TOTAL_SALES = totalExpense;
//        } else if (ePlus == EMOTICON_PLUS) {
//            TOTAL_SALES = Math.max(totalExpense, TOTAL_SALES);
//        }
//    }
//
//
//}