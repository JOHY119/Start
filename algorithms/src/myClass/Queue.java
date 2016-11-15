package myClass;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 链表队列.
 * Created by Johnny on 2016/11/14.
 */
public class Queue<Item> implements Iterable<Item> {
    private class Node {

        Item item;
        Node next;
    }

    private Node head;

    private Node tail;
    private int n;

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return head == null;
        //或者
        //return n==0;
    }

    public void enqueue(Item item) {
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        if (isEmpty()) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
        n++;
    }

    public Item dequeue() {
        //判断进行操作时队列是否为空
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Overflow");
        }

        Item temp = head.item;
        head = head.next;
        n--;
        //判断操作结束后队列是否为空,为空则tail需手动置为0
        if (isEmpty()) {
            tail = null;
        }

        return temp;
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
        Queue<String> q = new Queue<>();

        //        while (!StdIn.isEmpty()) {
        //            String item= StdIn.readString();
        //
        //            if (!item.equals("-")) {
        //                q.enqueue(item);
        //            } else {
        //                System.out.print(q.dequeue()+" ");
        //            }
        //
        //        }
        //
        //        System.out.println("(" +q.size() + " left on queue)");


        int n=100;
        for (int i = 0; i < n; i++) {
            q.enqueue(i+"");
        }

        q.forEach(System.out::println);

    }
}
