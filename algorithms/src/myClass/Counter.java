package myClass;

import edu.princeton.cs.algs4.StdOut;

/**
 * 计数器.
 * Created by Johnny on 2016/11/8.
 */
public class Counter {
    private final String name;
    private int count;

    /**
     * 创建计数器.
     *
     * @param id
     */
    public Counter(String id) {
        name = id;
    }

    /**
     * 显示当前计数器值.
     *
     * @return 当前值.
     */
    public int tally() {
        return count;
    }

    /**
     * 自增1.
     */
    public void increment() {
        count++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Counter that = (Counter) obj;
        if (name.equals(that.name) && count == that.count) return true;
        return false;


    }

    /**
     * [number] [id]
     *
     * @return [number] [id]
     */
    @Override
    public String toString() {
        return count + " " + name;
    }

    public static void main(String[] args) {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        heads.increment();
        heads.increment();
        tails.increment();

        StdOut.println(heads + " " + tails);
        StdOut.println(heads.tally() + tails.tally());
    }
}
