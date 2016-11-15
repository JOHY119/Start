package programSolution;

import myClass.Stack;

/**
 * 短除法十进制转2进制
 * Created by Johnny on 2016/11/15.
 */
public class Dec2Bin {
    public static void main(String[] args) {
        int decNum = 50;


        Stack<Integer> s = new Stack<>();
        assert decNum >= 0;
        while (decNum > 0) {
            s.push(decNum % 2);
            decNum /= 2;
        }

        s.forEach(System.out::print);
    }
}
