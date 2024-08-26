package me.kzv.datastructure.queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    // 기본적으로 큐와 사용법은 동일
    // 자동으로 정렬되는 큐 -> 다익스틀라 알고리즘에서 사용
    // 값을 꺼낼 때 가장 작은 값부터 오름차순으로 값이 나온다
    // 우선순위 큐는 힙을 사용하여 구성하며 내부구조는 이진트리 형태이다.
    // 이진트리이므로 출력할 때는 정렬되지 않았을 수도 있다.

    // 일반적인 큐처럼 선입선출이 아니라 오름차순으로 꺼내지는 큐

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 1. add
        pq.add(5);
        pq.add(4);
        pq.add(1);
        pq.add(3);
        pq.add(2);

        // 2. peek
        System.out.println(pq.peek());
        System.out.println(pq);

        // 3. poll
        System.out.println(pq.poll()); // 1
        System.out.println(pq);

        // 4. size
        System.out.println(pq.size());

        // 5. clear
        pq.clear();

        // 6. isEmpty
        System.out.println(pq.isEmpty());


        // 내림차순으로 구현하고 싶다면?
        PriorityQueue<Integer> reversePq = new PriorityQueue<>(Collections.reverseOrder());
        reversePq.add(1);
        reversePq.add(2);

        System.out.println(reversePq.poll()); // 2
    }
}
