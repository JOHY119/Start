package programSolution;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1.3链表练习题
 * Created by Johnny on 2016/12/1.
 */
public class LinkedList<Item> implements Iterable<Item> {
    private class Node {

        private Item item;
        private Node next;

        private Node(Item item) {
            this.item = item;
        }

        private Node() {
        }

    }

    public Node first;

    /**
     * 添加节点到链表后.
     *
     * @param item 节点中数据
     */
    public void add(Item item) {
        if (first == null) {
            first = new Node(item);
        } else {
            //找到最后一个节点
            Node tail = first;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = new Node(item);
        }
    }


    /**
     * 1.3.19删除尾节点.
     * 找到尾节点的前一个节点,将其next域置为null.
     *
     * @return 返回尾节点的值.
     */
    public Item deleteTail() {
        //        if (first.next == null) {
        //            Item item = first.item;
        //            first = null;
        //            return item;
        //        } else {
        //            Node preTail=first;
        //            while (preTail.next.next != null) {
        //                preTail = preTail.next;
        //            }
        //            Item item = preTail.next.item;
        //            preTail.next=null;
        //            return item;
        //        }

        Node preTail = null;
        Node tail = first;
        while (tail.next != null) {
            preTail = tail;
            tail = tail.next;
        }
        Item item = tail.item;
        //如果尾节点的前一个为节点为null,则说明尾节点即为头结点
        if (preTail == null) {
            first = null;
        } else {
            preTail.next = null;

        }
        return item;
    }

    /**
     * 删除链表的第k个元素(k小于链表长度).
     *
     * @param k 第k个元素
     * @return 被删除元素内容
     */
    public Item delete(int k) {
        //.next!=null
        //1~<k

        if (k <= 0) {
            throw new NoSuchElementException("k不得小于1");

        }

        Node p = first;
        Node prev = null;

        for (int i = 1; i < k; i++) {
            if (p.next == null) {
                throw new NoSuchElementException("k超出范围");
            }

            prev = p;
            p = p.next;
        }
        Item item = p.item;
        if (prev == null) {
            first = null;
        } else {
            prev.next = p.next;
        }
        return item;

    }

    /**
     * 是否有item域为key的节点.
     *
     * @param key 关键字
     * @return 找到 true 否则false
     */
    public boolean find(Item key) {
        Node p = first;
        while (p != null) {
            if (p.item.equals(key))
                return true;
            p = p.next;
        }
        return false;
    }

    public Node findNode(Item key) {
        Node p = first;
        while (p != null) {
            if (p.item.equals(key)) {
                return p;
            }
            p = p.next;
        }
        return null;

    }

    /**
     * 删除给定节点的后续节点
     *
     * @param current 给定节点
     */
    public void removeAfter(Node current) {
        if (current != null && current.next != null) {
            current.next = current.next.next;
        }
    }

    /**
     * 将新节点插入指定节点之后
     *
     * @param p 指定节点
     * @param q 新节点
     */

    public void insertAfter(Node p, Node q) {
        if (p != null && q != null) {
            q.next = p.next;
            p.next = q;
        }
    }

    /**
     * 删除item域为key的节点
     *
     * @param key item域值
     */
    public void remove(Item key) {
        Node prev = null;
        Node cur = first;

        while (cur != null) {
            if (cur.item == key) {
                if (prev == null) {
                    first = cur.next;
                } else {
                    prev.next = cur.next;
                }
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
    }

    /**
     * 寻找链表中最大值.
     *
     * @return 最大值
     */
    public Item max() {
        Node cur = first;
        Item max = first.item;

        while (cur != null) {
            if (((Integer) cur.item) > (Integer) max) {
                max = cur.item;
            }
            cur = cur.next;
        }
        return max;
    }

    /**
     * 递归查找链表中最大值.
     *
     * @param p 链表头结点.
     * @return 最大值
     */
    public Item recursiveMax(Node p) {
        if (p.next == null) {
            return p.item;
        }
        Item temp = recursiveMax(p.next);
        return ((Integer) p.item) > ((Integer) temp) ? p.item : temp;
    }




    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {
        private Node current = first;

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
        LinkedList<Integer> l = new LinkedList<>();

        l.add(10);
        l.add(3);
        l.add(4);
        l.add(7);
        l.add(4);
        l.add(4);
        l.add(5);
        //        int n = 1;
        //        for (int i = 0; i < n; i++) {
        //            l.add(i + 1);
        //        }

        for (Integer integer : l) {
            System.out.println(integer);
        }
        System.out.println();

        System.out.println(l.recursiveMax(l.first));

    }


}
