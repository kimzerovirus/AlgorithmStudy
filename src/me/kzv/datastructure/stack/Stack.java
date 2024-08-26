package me.kzv.datastructure.stack;

import java.util.EmptyStackException;

/**
 * Last in Last out
 */
public class Stack<T> {
    private Node<T> top;

    public void push(T item) {
        Node<T> t = new Node<T>(item);
        t.next = top;
        top = t;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek(){
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}

class Test {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }
}