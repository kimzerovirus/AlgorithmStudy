package me.kzv;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
//        String[] ss = s();
//        printList(ss);
    }

    static void printList(Object[] oo) {
        for (Object o : oo) {
            System.out.println(o);
        }
    }

    public static String[] s() {
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        IntStream.of(numbers).min().orElse(0);
        IntStream.of(numbers).max().orElse(0);
        return IntStream.of(numbers).mapToObj(String::valueOf).toArray(String[]::new);
    }

}
