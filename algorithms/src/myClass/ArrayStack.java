package myClass;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 定容栈
 * Created by Johnny on 2016/11/11.
 */
public class ArrayStack<Item> implements Iterable<Item> {
    private Item[] a;
    //    表示容量
    private int n;

    public ArrayStack() {
        a = (Item[]) new Object[1];
        n=0;
    }

    public int size() {
        return n;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        System.arraycopy(a, 0, temp, 0, n);
        a = temp;
    }

    public void push(Item s) {

        if (n == a.length) resize(2 * n);

        a[n] = s;
        n++;
    }

    public Item pop() {
        n--;
        Item temp = a[n];
        //避免对象游离
        a[n] = null;
        //如果现有元素数量为数组长度的1/4,数组缩短为原来的1/2
        //这样可以使数组长度减半后,维持在半满状态
        if (n == a.length / 4) resize(a.length / 2);
        return temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }


    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            i--;
            return a[i];
        }
    }
}
