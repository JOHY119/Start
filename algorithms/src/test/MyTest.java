package test;

import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

/**
 * Created by Johnny on 2016/11/8.
 */


public class MyTest {
    public static void main(String[] args) {
        Stack<Double> sNumber = new Stack<>();
        Stack<String> sOp = new Stack<>();


        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            switch (s) {
                case "(":
                    break;
                case "+":
                    sOp.push(s);
                    break;
                case "-":
                    sOp.push(s);
                    break;
                case "*":
                    sOp.push(s);
                    break;
                case "/":
                    sOp.push(s);
                    break;
                case ")":
                    String op= sOp.pop();
                    double num1=sNumber.pop();
                    double num2=sNumber.pop();
                    double result=0;
                    switch (op) {
                        case "+":
                            result=num1+num2;
                            break;
                        case "-":
                            result=num1-num2;
                            break;
                        case "*":
                            result=num1*num2;
                            break;
                        case "/":
                            result=num1/num2;
                            break;
                    }
                    sNumber.push(result);
                    break;
                default:
                    sNumber.push(Double.parseDouble(s));
                    break;
            }
        }
        System.out.println(sNumber.pop());




    }
}
