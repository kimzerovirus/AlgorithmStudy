package me.kzv.swacademy;

import java.util.Scanner;

public class S2056연월일달력 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int idx = 0;

        sc.nextLine();

        int[] monthOfDays = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        while (idx < n) {
            String year, month, day;
            String num = sc.nextLine();
            year = num.substring(0, 4);
            month = num.substring(4, 6);
            day = num.substring(6, 8);

            String answer = "-1";
            if(Integer.parseInt(day) <= monthOfDays[Integer.parseInt(month)]) answer = year + "/" + month + "/" + day;

            sb.append("#").append(++idx).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}






//            switch (Integer.parseInt(month)) {
//                case 1, 3, 5, 7, 8, 10, 12:
//                    if (Integer.parseInt(day) <= 31) answer = year + "/" + month + "/" + day;
//                    break;
//                case 4, 6, 9, 11:
//                    if (Integer.parseInt(day) <= 30) answer = year + "/" + month + "/" + day;
//                    break;
//                case 2:
//                    if (Integer.parseInt(day) <= 28) answer = year + "/" + month + "/" + day;
//                    break;
//            }