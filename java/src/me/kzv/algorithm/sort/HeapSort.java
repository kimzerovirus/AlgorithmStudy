package me.kzv.algorithm.sort;

import java.util.Arrays;

/**
 * 힙정렬 - 힙 트리 구조를 이용한 정렬 기법
 * <p>
 * 최대힙 - 부모 노드가 자식 노드보다 큼
 * 최소힙 - 부모 노드가 자식 노드보다 작음
 * <p>
 * 힙 구조 생성시 연산 수는 힙의 높이와 동일하므로 o(logN)
 * 따라서 힙 정렬의 전체 시간 복잡도는
 * o(log N) * 전체 데이터 수 N = o(N * logN)
 */
public class HeapSort {
    static int[] heap = new int[]{1, 6, 10, 4, 3, 9, 5, 8, 2, 7};

    public static void main(String[] args) {
        // 트리 구조를 최대힙으로 변경
        for (int i = 1; i < heap.length; i++) {
            int c = i;
            while (c != 0) {
                int root = (c - 1) / 2; // 부모 노드 .. 완전이진트리이고 0에서 부터 시작하므로
                if (heap[root] < heap[c]) { // 부모의 값보다 자식이 더 큰 경우 바꿔치기
                    int temp = heap[root];
                    heap[root] = heap[c];
                    heap[c] = temp;
                }
                c = root;
            }
        }

        System.out.println(Arrays.toString(heap));


        // 크기를 줄여가며 반복적으로 힙을 구성
        for (int i = heap.length - 1; i >= 0; i--) {
            System.out.println();
            System.out.println("가장 큰 값 힙의 맨끝으로 보내기 - 부모 : " + heap[0] + " -> 자식 : " + heap[i]);
            int temp = heap[0]; // 최대힙이므로 0번째가 가장 큰 값
            heap[0] = heap[i];
            heap[i] = temp; // 가장 큰 값을 맨 뒤로 보낸다.
            int root = 0;
            int c = 1;
            while (c < i) { // i-- 이므로 힙의 규모를 줄여간다
                c = 2 * root + 1;
                // 자식 중에 더 큰 값을 찾기
                if (c < i - 1 && heap[c] < heap[c + 1]) {
                    c++;
                }
                // 루트보다 자식이 더 크다면 교환
                if (c < i && heap[root] < heap[c]) {
                    System.out.println("최대힙으로 재정렬시키기 - 부모 : " + heap[root] + " -> 자식 : " + heap[c]);
                    temp = heap[root];
                    heap[root] = heap[c];
                    heap[c] = temp;
                }
                root = c;
            }
        }

        System.out.println(Arrays.toString(heap));
    }
}


