package programSolution;

import edu.princeton.cs.algs4.StdIn;
import myClass.Stack;

/**1.3.9
 * 对缺少左括号的表达式进行补全.
 * 方法同使用栈计算表达式值.
 * Created by Johnny on 2016/11/15.
 */
public class CompleteLeft {
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
                    s.push("( "+num1+" "+opt+" "+num2+" )");
                    break;

                default:s.push(temp);
            }

        }
        System.out.println(s.pop());
    }
}
