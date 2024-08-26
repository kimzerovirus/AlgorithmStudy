package me.kzv.datastructure.queue;

import java.util.*;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // 1. add - enqueue
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q);

        for (Integer i : q) { // iterator
            System.out.println(i);
        }

        // 2. peek - 맨 앞의 원소를 삭제하지 않고 보여줌
        System.out.println(q.peek());
        System.out.println(q);

        // 3. poll - dequeue
        System.out.println(q.poll());
        System.out.println(q);

        // 4. size
        System.out.println(q.size());

        // 5. clear - queue 비우기
        q.clear();

        // 6. isEmpty
        System.out.println(q.isEmpty());
    }
}
