package NiuKe;

/**
 * 2020.3.20
 * 合并两个排序的链表
 * 思路：首先对特殊情况进行判断
 * 然后利用合并两个数组的思想
 * 生成第三个链表
 * 但是也可以不生成第三个链表，直接把两个链表变成一个链表
 */
class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class SMerge {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode result = null;
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        if(list1.val < list2.val){
            result = list1;
            list1 = list1.next;
        }else{
            result = list2;
            list2 = list2.next;
        }
        ListNode head = result;
        while(list1!=null || list2!=null){
            if(list1 == null){
                result.next = list2;
                list2 = list2.next;
            }else if(list2 == null){
                result.next = list1;
                list1 = list1.next;
            }else if(list1.val < list2.val){
                result.next = list1;
                list1 = list1.next;
            }else{
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }
        return head;
    }
}
