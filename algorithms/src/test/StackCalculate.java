package test;

import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

/**
 * 双栈法计算表达式.
 * 对于依靠括号区分优先级的表达式,只需要一个栈,方法不变,即可计算表达式.
 * 每个符号之间用空格隔开.
 * Created by Johnny on 2016/11/8.
 */


public class StackCalculate {
    public static void main(String[] args) {

//双栈法
        //        Stack<Double> sNumber = new Stack<>();
        //        Stack<String> sOp = new Stack<>();
        //        while (!StdIn.isEmpty()) {
        //            String s = StdIn.readString();
        //
        //            switch (s) {
        //                case "(":
        //                    break;
        //                case "+":
        //                    sOp.push(s);
        //                    break;
        //                case "-":
        //                    sOp.push(s);
        //                    break;
        //                case "*":
        //                    sOp.push(s);
        //                    break;
        //                case "/":
        //                    sOp.push(s);
        //                    break;
        //                case ")":
        //                    String op= sOp.pop();
        //                    double num1=sNumber.pop();
        //                    double num2=sNumber.pop();
        //                    double result=0;
        //                    switch (op) {
        //                        case "+":
        //                            result=num1+num2;
        //                            break;
        //                        case "-":
        //                            result=num1-num2;
        //                            break;
        //                        case "*":
        //                            result=num1*num2;
        //                            break;
        //                        case "/":
        //                            result=num1/num2;
        //                            break;
        //                    }
        //                    sNumber.push(result);
        //                    break;
        //                default:
        //                    sNumber.push(Double.parseDouble(s));
        //                    break;
        //            }
        //        }
        //        System.out.println(sNumber.pop());

        Stack<String> ss = new Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            switch (s) {
                case "(":
                    break;
                case "+":
                    ss.push(s);
                    break;
                case "-":
                    ss.push(s);
                    break;
                case "*":
                    ss.push(s);
                    break;
                case "/":
                    ss.push(s);
                    break;
                case ")":
                    double num2 = Double.parseDouble(ss.pop());
                    String op = ss.pop();
                    double num1 = Double.parseDouble(ss.pop());
                    double result = 0;
                    switch (op) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            result = num1 / num2;
                            break;
                    }
                    ss.push(result + "");
                    break;
                default:
                    ss.push(s);
                    break;
            }
        }


        System.out.println(ss.pop());


    }
}
