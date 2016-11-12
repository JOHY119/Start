package myClass.useCase;

import edu.princeton.cs.algs4.StdRandom;
import myClass.Accumulator;

/**Accumulator测试用例.
 * Created by Johnny on 2016/11/9.
 */
public class TestAccumulator {
    public static void main(String[] args) {
        int n=10000;

        Accumulator accumulator = new Accumulator();

        for (int i = 0; i < n; i++) {
            accumulator.addDataValue(StdRandom.uniform());
        }
        System.out.println(accumulator);
    }
}
