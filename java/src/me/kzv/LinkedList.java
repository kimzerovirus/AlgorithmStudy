package me.kzv;

class LinkedList {
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    LinkedList() {
        this.header = new Node();
    }

    void append(int data) {
        Node end = new Node();
        end.data = data;
        Node node = this.header;
        while (node.next != null) {
            node = node.next;
        }
        node.next = end;
    }

    void delete(int data) {
        Node node = this.header;
        while (node.next != null) {
            if (node.next.data == data) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }

    void retrieve() {
        Node node = this.header.next;
        while (node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
    }

    // 포인터를 이용해 중복값 제거해보기
    // 공간 활용면에서는 다른 버퍼를 사용하지 않으므로 좋음o(1)
    // 하지만 node순회 * runner 순회로 제곱이 되므로 시간면에서는 느림 o(n^2)
    void removeDups() {
        Node node = this.header;
        while (node.next != null) {
            Node runner = node;
            while (runner.next != null) {
                if (node.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            node = node.next;
        }
    }
}

class LinkedListNode {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.delete(1);
        ll.retrieve();
    }
}

class RemoveDups {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(2);
        ll.append(2);
        ll.append(2);
        ll.append(2);
        ll.append(3);
        ll.retrieve();
        ll.removeDups();
        ll.retrieve();
    }
}