package NiuKe;
/**
 * 2020.3.24
 * 包含min函数的栈
 * 思路：用两个栈实现，另外一个栈minStack存放每一次存放进来的最小数
 * 如果出栈的元素正好和minStack的栈顶元素相等，则同时出栈
 * 最后只要返回最小栈的栈顶元素即可
 */
import java.util.Stack;

public class SMin {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min;
    static int flag = 1;
    public void push(int node) {
        s.push(node);
        if(flag==1){
            min = node;  //初始化min，第一次进栈的值作为最小值
            minStack.push(min);
            flag++;   //作为标志，第一次之后不运行这个代码块了
        }else{
            if(min>=node){
                min = node;
                minStack.push(min);  //每次有新元素进栈比较是否是更小的，是就进栈
            }
        }
    }

    public void pop() {
        if(s.peek()==minStack.peek()){
            minStack.pop();   //如果出栈的时候，栈顶元素和最小栈的栈顶元素相等，同时出栈
        }
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return minStack.peek();  //返回最小栈的栈顶元素就是最小值
    }
}