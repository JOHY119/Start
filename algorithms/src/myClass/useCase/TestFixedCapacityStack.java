package myClass.useCase;

import myClass.FixedCapacityStack;

/**
 * Created by Johnny on 2016/11/13.
 */
public class TestFixedCapacityStack {
    public static void main(String[] args) {
        FixedCapacityStack<Integer> a = new FixedCapacityStack<>();

        int n=1000000;
        long b1= System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            a.push(i);
        }
        System.out.println("push: "+(System.currentTimeMillis()-b1));
        long b2=System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            a.pop();
        }
        System.out.println("pop: "+(System.currentTimeMillis()-b2));



    }
}
