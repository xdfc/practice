package NiuKe;

/**
 * 2020.5.1
 * 平衡二叉树
 * 有一个方法遍历节点的最大深度
 * 然后递归判断每个节点
 */
public class SIsBalanced_Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null)
            return true;
        int l = TreeDepth(root.left);
        int r = TreeDepth(root.right);
        if(l-r>1||r-l>1)
            return false;
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }
    public int TreeDepth(TreeNode root) { //节点深度
        if(root==null)  //这个必须有，递归的结束条件
            return 0;
        int left_depth = TreeDepth(root.left);
        int right_depth = TreeDepth(root.right);
        return (left_depth<right_depth)?(right_depth+1):(left_depth+1);
    }
}
