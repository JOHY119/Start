package programSolution;

import edu.princeton.cs.algs4.StdIn;
import myClass.Stack;

/**1.3.4
 * 匹配括号是否完整
 * Created by Johnny on 2016/11/15.
 */
public class Parentheses {
    public static void main(String[] args) {
        Stack<String> s=new Stack<>();

        String[] p= StdIn.readAll().split("");
        //p中最后一个字符为\n  需去掉

        boolean isMatch=true;
        for (int i = 0; i < p.length-1&&isMatch; i++) {
            if (p[i].equals("(") || p[i].equals("[") || p[i].equals("{")) {
                s.push(p[i]);
            } else {
                String temp=s.pop();
                switch (p[i]) {
                    case ")":
                        isMatch = temp.equals("(");
                        break;
                    case "]":
                        isMatch = temp.equals("[");
                        break;
                    case "}":
                        isMatch = temp.equals("{");
                        break;
                }
            }
        }

        System.out.println(isMatch);



    }
}
