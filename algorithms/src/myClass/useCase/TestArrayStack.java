package myClass.useCase;

import myClass.ArrayStack;

/**
 * Created by Johnny on 2016/11/13.
 */
public class TestArrayStack {
    public static void main(String[] args) {
        ArrayStack<Integer> a = new ArrayStack<>();

        int n = 1000000;
        long b1 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            a.push(i);
        }
        System.out.println("push: " + (System.currentTimeMillis() - b1));
        long b2 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            a.pop();
        }
        System.out.println("pop: " + (System.currentTimeMillis() - b2));
    }
}
