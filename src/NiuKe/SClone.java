package NiuKe;

/**
 * 复杂链表的复制
 * 2020.6.20
 * 有错误
 * 复制一个带有随机指针的链表
 * 先复制每一个结点，连接成一个上链表
 * 然后复制随机指针
 * 最后将指定的链表重新指向下一个结点
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class SClone {
    public static RandomListNode Clone(RandomListNode pHead){
        if(pHead==null){
            return null;
        }
        RandomListNode pIndex = pHead;
        RandomListNode pIndex1 = pHead;
        RandomListNode pIndex2 = pHead;


        while(pIndex != null){
            RandomListNode cloneIndex = new RandomListNode(pIndex.label);
            cloneIndex.next = pIndex.next;
            pIndex.next = cloneIndex;
            pIndex = cloneIndex.next;
        }

        while(pIndex1 != null) {
            if(pIndex1.random != null){
                pIndex1.next.random = pIndex1.random.next;
            }
            pIndex1 = pIndex1.next.next;
        }

        while(pIndex2 != null){
            if( pIndex2.next.next != null){
                pIndex2.next.next = pIndex2.next.next.next;
            }
            pIndex2 = pIndex2.next.next;
        }
        return pHead.next;
    }

    public static void main(String[] args) {
        RandomListNode L1 = new RandomListNode(2);
        RandomListNode L2 = new RandomListNode(4);
        RandomListNode L3 = new RandomListNode(8);
        L1.next = L2;
        L2.next = L3;
        L3.random = L1;
        RandomListNode clone = Clone(L1);
        while(clone!=null){
            System.out.println(clone.label);
            if(clone.random!=null){
                System.out.println(clone.random.label);
            }
            clone = clone.next;
        }
    }
}
