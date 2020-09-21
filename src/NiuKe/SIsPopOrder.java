package NiuKe;

import java.util.Stack;
/**
 * 2020.4.3
 * 栈的压入、弹出序列
 * 思路：用另外一个栈实现就很简单
 * 注意：注意空栈的时候，不能取出元素
 * 最后的返回值可以用栈是否为空表示
 */
public class SIsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0||popA.length==0||pushA==null||popA==null)
            return false;
        Stack<Integer> stack = new Stack();
        int j = 0;
        for(int i = 0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while(stack.size()!=0&&stack.peek() == popA[j]){
                    stack.pop();
                    j++;
            }
        }
       // return stack.isEmpty(); //也可以这么返回
        if(j==popA.length)
            return true;
        else
            return false;
    }
}
