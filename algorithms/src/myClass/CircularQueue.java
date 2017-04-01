package myClass;

/**
 * 循环队列.
 * Created by Johnny on 2016/12/18.
 */
public class CircularQueue<Item> {
    private class Node {
        private Item item;
        private Node next;

        private Node() {}

        private Node(Item item) {
            this.item = item;
            next = null;
        }
    }

    private Node last;

    public boolean isEmpty() {
        return last == null;
    }

    public void enqueue(Item item) {
        Node n = new Node(item);

        if (last == null) {
            last = n;
        } else {
            n.next=last.next;
        }
        last.next=n;
    }

    public Item dequeue() {
        Item item;
        if (last.next == last) {
            item = last.item;
            last = null;
        } else {
            item=last.next.item;
            last.next = last.next.next;
        }
        return item;
    }
}
