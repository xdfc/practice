package LeetCode;

/**
 * 两数相加
 * 需要判断链表是否为空
 * 相加的数是否大于10
 * 可以写的更加简洁
 */


 class ListNode {
     int val;
      ListNode next;
     ListNode(int x) { val = x; }
 }


public class Exercise2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);  //建立一个头结点
        ListNode pIndex = head;
        int sum = 0;
        int flag = 0;  //标志相加的数有没有超过10,0表示没有，1表示有
        while((l1!=null)||(l2!=null)||(flag==1)){
            ListNode addList = new ListNode(0);
            if(l1==null&&l2!=null){
                if(flag == 1){
                    addList.val = l2.val + 1;
                }else{
                    addList.val = l2.val;
                }
                if(addList.val >= 10){
                    addList.val = addList.val - 10;
                    flag = 1;
                }else{
                    flag = 0;
                }
                l2 = l2.next;
            }else if(l1!=null&&l2==null){
                if(flag == 1){
                    addList.val = l1.val + 1;
                }else{
                    addList.val = l1.val;
                }
                if(addList.val >= 10){
                    addList.val = addList.val - 10;
                    flag = 1;
                }else{
                    flag = 0;
                }
                l1 = l1.next;
            }else if(l1==null&&l2==null&&flag==1){
                addList.val = 1;
                flag = 0;
            }else{
                System.out.println(l1.val);
                System.out.println(l2.val);
                sum = l1.val + l2.val;
                if(sum<10){
                    if(flag == 0){
                        addList.val = sum;
                        flag = 0;
                    }else{
                        addList.val = sum + 1;
                        if(addList.val >= 10){
                            addList.val = addList.val - 10;
                            flag = 1;
                        }else{
                            flag = 0;
                        }
                    }

                }
                if(sum>=10){
                    if(flag == 0){
                        addList.val = sum - 10;
                    }else {
                        addList.val = sum - 10 + 1;
                        if(addList.val >= 10){
                            addList.val = addList.val - 10;
                        }
                    }
                    flag = 1;
                }
                l1 = l1.next;
                l2 = l2.next;
                System.out.println("flag"+flag);
            }
            pIndex.next = addList;
            pIndex = pIndex.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(9);
        ListNode h2 = new ListNode(9);
//        ListNode h3 = new ListNode(3);
        h1.next = h2;
//        h2.next = h3;

        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
//        ListNode n3 = new ListNode(4);
        n1.next = n2;
 //       n2.next = n3;

        ListNode node = addTwoNumbers(h1,n1);

        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }



    }
}
