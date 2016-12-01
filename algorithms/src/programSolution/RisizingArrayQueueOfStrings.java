package programSolution;

import java.util.Iterator;

/**
 * 数组实现变容String队列.
 * Created by Johnny on 2016/11/26.
 */
public class RisizingArrayQueueOfStrings implements Iterable<String> {

    private String[] q = new String[1];

    private int head;
    private int tail;
    private int n;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int capacity) {
        String[] temp = new String[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = q[(head + i) % q.length];
        }
        head=0;
        tail=n;
        q = temp;
    }

    public void enqueue(String item) {
        if (n == q.length) {
            resize(2 * q.length);
        }
        q[tail] = item;
        tail = (tail + 1) % q.length;
        n++;
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("队列已空");
            return "";
        }

        String item = q[head];
        head = (head + 1) % q.length;
        n--;

        if (n == q.length / 4) {
            resize(q.length/20);
        }

        return item;
    }

    @Override
    public Iterator<String> iterator() {
        return new ArrayQueueIterator();
    }

    private class ArrayQueueIterator implements Iterator<String> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < n;
        }

        @Override
        public String next() {
            String item = q[(head + i) % q.length];
            i++;
            return item;
        }
    }

}
