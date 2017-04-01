package InnerClassAndInterface;

/**
 * Created by Johnny on 2017/2/21.
 */
public class InnerClassTest {
    public static class Pair{
        private int max;
        private int min;

        public Pair(int max, int min) {
            this.max=max;
            this.min=min;
        }

        public int getMax() {
            return max;
        }

        public int getMin() {
            return min;
        }
    }

    public static Pair minMax(int[] a) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i : a) {
            if (i < min) {
                min=i;
            }
            if (i > max) {
                max=i;
            }
        }
        return new Pair(min, max);
    }
}


