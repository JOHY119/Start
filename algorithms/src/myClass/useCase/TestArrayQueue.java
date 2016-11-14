package myClass.useCase;

import myClass.ArrayQueue;

/**ArrayQueue测试用例.
 * Created by Johnny on 2016/11/14.
 */
public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue<Integer> q = new ArrayQueue<>();

        int n=10;
        for (int i = 0; i < n; i++) {
            q.enqueue(i);
        }

        q.dequeue();

        q.enqueue(121);
        q.enqueue(122);
        q.enqueue(123);
        q.enqueue(124);
        q.enqueue(125);
        q.enqueue(126);
        q.enqueue(127);

        q.dequeue();
        q.enqueue(128);

        q.forEach(System.out::println);
    }
}
