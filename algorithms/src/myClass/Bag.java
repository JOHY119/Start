package myClass;

import java.util.Iterator;

/**
 * 链表背包.
 * Created by Johnny on 2016/11/15.
 */
public class Bag<Item> implements Iterable<Item> {

    private class Node {
        private Item item;
        private Node next;
    }

    private Node head;

    private int n;

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(Item item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        n++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Bag<Integer> b = new Bag<>();

        int n=100;
        for (int i = 0; i < n; i++) {
            b.add(i);
        }

        b.forEach(System.out::println);
    }
}
