package NiuKe;
/**
 * 2020.3.24
 * 重建二叉树
 * 思路：递归调用
 * 找出第一个根节点，分为左右两个新的数列
 * 再找出新的数列的根节点
 * 再分为两个新的数列
 */

import java.util.Arrays;

//Definition for binary tree

public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0){
            return null;
        }
        if(pre.length==1){
            return new TreeNode(pre[0]);
        }
        TreeNode root = new TreeNode(pre[0]);
        int i=0,j=0;
        while(pre[i]!=in[j]){
            j++;
        }
        int[] preLeft = Arrays.copyOfRange(pre,1,j+1);
        int[] inLeft = Arrays.copyOfRange(in,0,j);
        int[] preRight = Arrays.copyOfRange(pre,j+1,pre.length);
        int[] inRight = Arrays.copyOfRange(in,j+1,in.length);

        root.left = reConstructBinaryTree(preLeft,inLeft);
        root.right = reConstructBinaryTree(preRight,inRight);

        return root;
    }
}
