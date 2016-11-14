package myClass;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 数组循环队列.
 * Created by Johnny on 2016/11/14.
 */
public class ArrayQueue<Item> implements Iterable<Item> {
    //队列中元素数量
    private int n;
    //头指针
    private int head;
    //尾指针
    private int tail;

    private Item[] q;

    public ArrayQueue() {
        q = (Item[]) new Object[1];

        head = tail = 0;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int capacity) {
        //必须大于等于n,否则将丢失元素
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = q[(head + i) % q.length];
        }
        q = temp;
        head = 0;
        tail = n;

    }

    public void enqueue(Item item) {
        //如果队列满
        if (n == q.length)
            resize(2 * q.length);

        q[tail] = item;
        tail = (tail + 1) % q.length;
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item temp = q[head];
        q[head] = null;
        n--;
        head = (head + 1) % q.length;

        if (n == q.length / 4)
            resize(q.length / 2);
        return temp;
    }

    public Item peek() {
        return q[head];
    }


    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < n;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = q[(head + i) % q.length];
            i++;
            return item;

        }
    }

}
