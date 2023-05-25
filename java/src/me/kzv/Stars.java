package me.kzv;

public class Stars {
    public static void main(String[] args) {
        역삼각형();
        삼각형2번();
        반대삼각형();
        반대역삼각형();
        정삼각형();
        역정삼각형();
    }

    static void 역삼각형() {
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void 삼각형2번() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i % 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void 반대삼각형() {
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 4; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void 반대역삼각형() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void 정삼각형(){
        int num = 1;

        for (int i = 0; i < 5; i++) {
            for (int k = 4; k > i; k--) {
                System.out.print("　");
            }
            for (int j = 0; j < num; j++) {
                System.out.print("★");
            }
            num = num + 2;
            System.out.println();
        }
    }

    static void 역정삼각형(){
        int num = 9;

        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print("　");
            }
            for (int j = num; j > 0; j--) {
                System.out.print("★");
            }
            num = num - 2;
            System.out.println();
        }
    }
}
