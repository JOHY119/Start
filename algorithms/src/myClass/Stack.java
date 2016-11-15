package myClass;

import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 链表栈.
 * Created by Johnny on 2016/11/14.
 */
public class Stack<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node head;

    private int n;

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return head == null;
        //        或者
        //        return n==0;
    }

    public void push(Item item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        n++;
    }

    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack OverFlow");
        Item temp = head.item;
        head = head.next;
        n--;
        return temp;
    }

    public Item peek(){
        if (isEmpty()) {
            throw new NoSuchElementException("Stack OverFlow");
        }
        Item temp=head.item;
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
        Stack<String> s = new Stack<>();

        while (!StdIn.isEmpty()) {
            String in= StdIn.readString();

            if (!in.equals("-")) {
                s.push(in);
            } else {
                System.out.print(s.pop()+" ");
            }
        }

        System.out.println("("+s.size()+")");
    }

}
