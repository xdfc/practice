package NiuKe;

/**
 * 2020.4.18
 * 二叉树的深度
 * 可以作为经典记忆一下
 * 思路：就是利用递归的思想，分为左右
 * 找到最大的深度，加1
 */

public class STreeDepth {
    public int TreeDepth(TreeNode root) {
        if(root==null)  //这个必须有，递归的结束条件
            return 0;
        int left_depth = TreeDepth(root.left);
        int right_depth = TreeDepth(root.right);
        return (left_depth<right_depth)?(right_depth+1):(left_depth+1);
    }
}
