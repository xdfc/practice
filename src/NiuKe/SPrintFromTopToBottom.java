package NiuKe;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 2020.4.5
 * 从上往下打印二叉树
 * 思路：用一个LinkedList存放各个节点，
 * 思考：因为LinkedList类似一个队列，需要一个先进先出的数据结构，将各个节点放入队列里面
 */
public class SPrintFromTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root == null){
            return arrayList;  //注意空的时候返回相同的空的数据类型
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode currentNOde;
        linkedList.add(root);
        while(!linkedList.isEmpty()){
            currentNOde = linkedList.poll();  //取出LinkedList的第一个元素，并且删除
            arrayList.add(currentNOde.val);
            if(currentNOde.left!=null){
                linkedList.add(currentNOde.left);
            }
            if(currentNOde.right!=null){
                linkedList.add(currentNOde.right);
            }
        }
        return arrayList;
    }
}
