package programSolution;

import edu.princeton.cs.algs4.StdIn;
import myClass.Stack;

/**中序表达式变为后序表达式.
 * 单栈,适合于表达式的优先级由括号确定
 * Created by Johnny on 2016/11/15.
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();

        while (!StdIn.isEmpty()) {
            String temp = StdIn.readString();


            switch (temp) {
                case "(":
                    break;
                case "+":
                    s.push(temp);
                    break;
                case "-":
                    s.push(temp);
                    break;
                case "*":
                    s.push(temp);
                    break;
                case "/":
                    s.push(temp);
                    break;
                case ")":
                    String num2 = s.pop();
                    String opt=s.pop();
                    String num1 = s.pop();
                    s.push(num1+" "+num2+" "+opt+" ");
                    break;

                default:s.push(temp);
            }

        }
        System.out.println(s.pop());
    }
}
