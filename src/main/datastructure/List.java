package datastructure;

import org.junit.Test;

public class List<T> {

    static class Node<T> {
        Node<T> next = null;
        T data;
        public Node(T data) {
            this.data = data;
        }
    }
    Node<T> head = null;

    public void insert(T data) {
        var node = new Node<>(data);
        node.next = head;
        head = node;
    }

    @Test
    public void test_insert() {
        var list = new List<Integer>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        var p = list.head;
        for (int i = 3; p != null; i--) {
            System.out.println(p.data);
            p = p.next;
        }
    }
}
