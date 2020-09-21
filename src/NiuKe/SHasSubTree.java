package NiuKe;

/**
 * 2020.3.24
 * 树的子结构
 * 思路：递归调用
 *
 */

public class SHasSubTree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null)
            return false;
        if(root1==null&&root2!=null)
            return false;
        boolean flag = false;
        if(root1.val==root2.val){
            flag = isSubTree(root1,root2);
        }
        if(!flag){
            flag = HasSubtree(root1.left,root2);
            if(!flag){
                flag = HasSubtree(root1.right,root2);
            }
        }
        return flag;
    }
    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if(root2==null) return true;
        if(root1==null && root2!=null) return false;
        if(root1.val==root2.val){
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }else{
            return false;
        }
    }
}
