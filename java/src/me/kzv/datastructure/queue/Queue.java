package me.kzv.datastructure.queue;

import java.util.NoSuchElementException;

/**
 * First in First out
 */
public class Queue<T> {
    // queue 는 앞 뒤 주소를 알아야함
    private Node<T> first;
    private Node<T> last;

    public void enqueue(T item) {
        Node<T> t = new Node<T>(item);

        if (last != null) {
            last.next = t;
        }
        last = t;
        if (first == null) {
            first = last;
        }
    }

    public T dequeue() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        T data = first.data;
        first = first.next;

        if (first == null) {
            last = null;
        }

        return data;
    }

    public T front() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    // 노드가 앞의 주소를 가지고 있어야 될듯
//    public T rear(){
//        if (first == null) {
//            throw new NoSuchElementException();
//        }
//        if (first == last) {
//            return last.data;
//        }
//
//    }

    public boolean isEmpty() {
        return first == null;
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
        Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.front());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());
    }
}
