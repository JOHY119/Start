package fundamentals;

import myClass.Counter;

/**
 * 二分查找实现.
 * Created by Johnny on 2016/11/7.
 */
public class BinarySearch {
    /**
     * 二分查找递归实现.
     *
     * @param key
     * @param a
     * @return
     */
    public static int recursiveRank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    private static int rank(int key, int[] a, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;

        if (key < a[mid]) return rank(key, a, low, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, high);
        else return mid;
    }

    /**
     * 二分查找循环实现.
     *
     * @param key
     * @param a
     * @return
     */
    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            //是a[mid] 不是mid
            if (key < a[mid]) high = mid - 1;
            else if (key > a[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int lessKeyCount(int key, int[] a) {
        int t = rank(key, a);
        if (t < 0) {
            return t;
        }

        int i = t - 1;
        while (i >= 0 && a[i] == key) {
            i--;
        }
        return i + 1;
    }

    public static int count(int key, int[] a) {
        int t = lessKeyCount(key, a);

        if (t < 0)
            return t;
        int i = t + 1;
        while (i < a.length && a[i] == key) {
            i++;
        }
        return i - t;
    }


    public static int rankWithCounter(int key, int[] a, Counter counter) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            counter.increment();
            if (key < a[mid]) high = mid - 1;
            else if (key > a[mid]) low = mid + 1;
            else return mid;

        }
        return -1;
    }

    public static int getWeek(int y, int m, int d) {
        if (m == 1 || m == 2) {
            m = m + 12;
            y = y - 1;
        }

        return (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;
    }


    public static void main(String[] args) {
        int[] a = {3, 3, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 19, 20};

        Counter counter = new Counter("binarySearch");

        rankWithCounter(14, a, counter);
        System.out.println(counter);
    }
}
