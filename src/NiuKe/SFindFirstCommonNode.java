package NiuKe;

import java.util.Stack;

/**
 * 2020.4.18
 * 两个链表的第一个公共节点
 * 思路1：暴力循环，循环比较直到找到公共的节点；
 * 思路2：因为是单向链表，有一个公共节点，说明公共之后都一样
 *       那么从后往前找，用两个辅助栈，链表元素全放入栈
 *       然后依次出栈比较，直到最后一个相同的节点
 */

public class SFindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //思路2
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode node1 = pHead1; //头结点作为保留
        ListNode node2 = pHead2;
        while(node1!=null){  //两个链表放入两个栈之中
            stack1.push(node1);
            node1 = node1.next;
        }
        while(node2!=null){
            stack2.push(node2);
            node2 = node2.next;
        }
        //判断栈顶是否相等
        //注意空栈
        while(!stack1.isEmpty()&&!stack2.isEmpty()&&stack1.peek()==stack2.peek()){
            stack1.pop();
            stack2.pop();
        }
        //        while(stack1.pop()==stack2.pop()){}
        if(stack1.isEmpty()){
            return pHead1;
        }else if(stack2.isEmpty()){
            return pHead2;
        }else{
            return stack1.peek().next;
        }

        //思路1
        /*
        ListNode L1,L2;
        L1 = pHead1;
        while(L1!=null){
            L2 = pHead2;
            while(L2!=null){
                if(L1==L2)
                    return L1;
                L2 = L2.next;
            }
            L1 = L1.next;
        }
        return null;

         */
    }
}
