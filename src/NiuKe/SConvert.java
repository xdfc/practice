package NiuKe;

import java.util.LinkedList;

/**
 * 二叉搜索树与双向链表
 * 本地IDE能通过，但是在牛客上会报错
 * 在LeetCode上改成双向循环链表，但是因为全局变量会出错
 *
 */

public class SConvert {
    static LinkedList<TreeNode> list = null;

    public static TreeNode Convert(TreeNode pRootOfTree) {
        list = new LinkedList<>();
        //中序遍历
        inOrderTraverse(pRootOfTree);
        //二叉搜索树没有元素或者只有1个元素
        if(list.size()==0||list.size()==1){
            return pRootOfTree;
        }
        //二叉搜索树只有2个元素
        if(list.size()==2){
            list.getFirst().left = list.getLast();
            list.getFirst().right = list.getLast();
            list.getLast().left = list.getFirst();
            list.getLast().right = list.getFirst();
            return list.getFirst();
        }
        //二叉搜索树有3个及以上元素
        TreeNode node0 = list.get(0);
        node0.left = list.getLast();
        node0.right = list.get(1);
        for(int i = 1;i<list.size()-1;i++){
            TreeNode node = list.get(i);
            node.left = list.get(i-1);
            node.right = list.get(i+1);
        }
        TreeNode lastNode = list.getLast();
        lastNode.left = list.get(list.size()-2);
        lastNode.right = list.getFirst();
        return list.getFirst();
    }

    public static void inOrderTraverse(TreeNode node){
        if(node == null)
            return;
        inOrderTraverse(node.left);
        list.add(node);
        inOrderTraverse(node.right);
    }


    public static void main(String[] args) {
        /*
        TreeNode node = new TreeNode(8);
        TreeNode node1 = new TreeNode(10);
        node.right = node1;

         */

        TreeNode node = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(11);
        TreeNode node12 = new TreeNode(8);
        TreeNode node121 = new TreeNode(6);
        node.right = node2;
        node.left = node1;
        node1.right = node12;
        node12.left = node121;

        TreeNode n = Convert(node);
        /*
        while(n!=null){
            System.out.println(n.val);
            n = n.left;
        }

         */
        for(int i = 0;i<5;i++){
            System.out.println(n.val);
            n = n.left;
        }
    }
}
