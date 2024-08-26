package me.kzv.datastructure.stack;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        // 1. add, push
        s.add(1);
        s.add(2);
        s.push(3);
        s.push(4);
        s.push(5);

        // 2. peek
        System.out.println(s.peek());
        System.out.println(s);

        // 3. pop
        System.out.println(s.pop());
        System.out.println(s);

        // 4. size
        System.out.println(s.size());

        // 5. clear
        s.clear();

        // 6. isEmpty
        System.out.println(s.isEmpty());
    }
}
