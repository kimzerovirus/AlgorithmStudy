package me.kzv;

public class SinglyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.retrieve();
        head.delete(2); // 첫번쨰 시작 노드가 대표값이라 삭제 안되는 이슈 있음... -> LinkedList 클래스로 Node 클래스를 감싸는 방법으로 해결할거임
        head.retrieve();
    }
}

class Node {
    int data;
    Node next = null;

    Node(int data) {
        this.data = data;
    }

    void append(int data) {
        Node end = new Node(data);
        Node node = this;
        while (node.next != null) {
            node = node.next;
        }
        node.next = end;
    }

    void delete(int data) {
        Node node = this;
        while (node.next != null) {
            if (node.next.data == data) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }

    void retrieve(){
        Node node = this;
        while (node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
    }
}


