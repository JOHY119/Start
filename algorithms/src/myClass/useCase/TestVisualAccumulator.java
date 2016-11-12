package myClass.useCase;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import myClass.VisualAccumulator;

/**visualAccumulator测试.
 * Created by Johnny on 2016/11/9.
 */
public class TestVisualAccumulator {

    public static void main(String[] args) {
        int n=10000;
        VisualAccumulator a = new VisualAccumulator(n, 1);

        StdDraw.line(0,0.5,n,0.5);

        for (int i = 0; i < n; i++) {
            a.addDataValue(StdRandom.uniform());
        }

        StdOut.println(a);
    }
}
