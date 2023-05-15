package me.kzv.swacademy;

public class S2027대각선출력하기 {
    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 5; i++) {
//            char[] chars = "+++++".toCharArray();
//            chars[i] = '#';
//            sb.append(chars).append("\n");
//        }
//        System.out.print(sb);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) System.out.print("#");
                else System.out.print("+");
            }
            System.out.print("\n");
        }
    }
}
