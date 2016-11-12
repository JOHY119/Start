package myClass;

/**
 * 定容栈
 * Created by Johnny on 2016/11/11.
 */
public class FixedCapacityStack<Item> {
    private Item[] a;
    //    表示容量
    private int n;

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public int size() {
        return n;
    }

    public void push(Item s) {

        if (n == a.length) resize(2 * n);

        a[n] = s;
        n++;
    }

    public Item pop() {
        n--;
        return a[n];
    }
}
