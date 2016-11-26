package programSolution;

import myClass.Stack;

/**复制栈.
 * 使用辅助栈.
 * Created by Johnny on 2016/11/25.
 */
public class CopyStack {

    public static<Item> Stack<Item> copy(Stack<Item> src){
        Stack<Item> temp =new Stack<>();

        for (Item item : src) {
            temp.push(item);
        }

        Stack<Item> target = new Stack<>();

        for (Item item : temp) {
            target.push(item);
            temp.pop();
        }

        return target;
    }

    public static void main(String[] args) {
        Stack<String> src = new Stack<>();

        StringBuilder sb = new StringBuilder("lfjslkdajfdl;sajfdls;ajfsaj;");

        for (int i = 0; i < sb.length(); i++) {
            src.push(sb.charAt(i)+"");
        }

        Stack<String> target = copy(src);

        src.forEach(System.out::print);
        System.out.println();
        target.forEach(System.out::print);


    }
}
