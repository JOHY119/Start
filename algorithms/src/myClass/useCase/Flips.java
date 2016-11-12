package myClass.useCase;

import edu.princeton.cs.algs4.StdRandom;
import myClass.Counter;

/**counter测试用例
 * Created by Johnny on 2016/11/8.
 */
public class Flips {
    public static void main(String[] args) {
        int n=100000;

        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        for (int i = 0; i < n; i++) {
            if (StdRandom.bernoulli(0.5)) {
                heads.increment();
            }else{
                tails.increment();
            }
        }
        System.out.println(heads);
        System.out.println(tails);
        System.out.println("d: "+Math.abs(heads.tally()-tails.tally()));
    }
}
