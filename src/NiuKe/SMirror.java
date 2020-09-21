package NiuKe;
/**
 * 2020.3.24
 * 二叉树的镜像
 * 思路：交换节点的左右节点
 * 注意：递归调用的时候，一定要有递归结束的条件
 */

public class SMirror {
    public void Mirror(TreeNode root) {
        TreeNode node = root;
        if(node!=null){
            TreeNode tmp;
            tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        if(node==null)
            return;
        Mirror(node.left);
        Mirror(node.right);
    }
}
