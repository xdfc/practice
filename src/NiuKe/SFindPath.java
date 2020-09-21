package NiuKe;

import java.util.ArrayList;

/**
 * 2020.4.20
 * 二叉树中和为某一值的路径
 * 思路：利用二叉树的前序遍历，
 *     当遍历到叶节点的时候，判断路径和是否等于target
 */

public class SFindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(root == null)
            return arrayLists;
        ArrayList<Integer> alist = new ArrayList<>();
        int sum = 0;
        findPath(root,target,arrayLists,alist,sum);
        return arrayLists;
    }
    public void findPath(TreeNode node,int target,ArrayList<ArrayList<Integer>> arrayLists,ArrayList<Integer> alist,int sum){
        if(node==null)
            return ;
        sum += node.val;
        if(node.left==null&&node.right==null){//当前是一个叶节点
            if(sum==target){  //相等
                alist.add(node.val);
                arrayLists.add(new ArrayList<Integer>(alist));   //新实例化一个对象放入
                alist.remove(alist.size()-1);  //去除最后一个元素
            }
            return;
        }
        alist.add(node.val);
        //前序遍历
        findPath(node.left,target,arrayLists,alist,sum);
        findPath(node.right,target,arrayLists,alist,sum);
        //去除最后一个元素
        alist.remove(alist.size()-1);
    }
}
