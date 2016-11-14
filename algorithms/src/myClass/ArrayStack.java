package myClass;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 定容栈
 * Created by Johnny on 2016/11/11.
 */
public class ArrayStack<Item> implements Iterable<Item> {
    private Item[] s;
    //    表示容量
    private int n;

    public ArrayStack() {
        s = (Item[]) new Object[1];
        n=0;
    }

    public int size() {
        return n;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        System.arraycopy(s, 0, temp, 0, n);
        s = temp;
    }

    public void push(Item s) {

        if (n == this.s.length) resize(2 * n);

        this.s[n] = s;
        n++;
    }

    public Item pop() {
        n--;
        Item temp = s[n];
        //避免对象游离
        s[n] = null;
        //如果现有元素数量为数组长度的1/4,数组缩短为原来的1/2
        //这样可以使数组长度减半后,维持在半满状态
        if (n == s.length / 4) resize(s.length / 2);
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
            return s[i];
        }
    }
}
