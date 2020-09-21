package DataStructure;

/**
 * 二叉排序树的简单实现版本
 * 建立最简单的二叉排序树其实需要一个Node内部私有类，然后实现添加的方法就可以了
 * 实现toArray方法，中序遍历可以返回有序数据
 * 这个程序只是实现了最简单的添加以及返回数据的功能
 */

public class BinTreeSimple {
    private class Node {
        private Comparable data;
        private Node left;
        private Node right;
        public Node(Comparable data){
            this.data = data;
        }
        public void addNode(Node newNode){  //添加节点到左右子树
            if(this.data.compareTo(newNode.data) < 0){
                if(this.right == null){
                    this.right = newNode;
                }else{
                    this.right.addNode(newNode);
                }
            }else{
                if(this.left == null){
                    this.left = newNode;
                }else{
                    this.left.addNode(newNode);
                }
            }
        }
        public void toArrayNode() {   //中序遍历
            if(this.left != null){
                this.left.toArrayNode();
            }
            BinTreeSimple.this.retobj[BinTreeSimple.this.foot++] = this.data;
            if(this.right != null){
                this.right.toArrayNode();
            }
        }
    }

    private Node root;
    private int count;
    private int foot;
    private Object[] retobj;
    public void add(Object data){   //实现添加节点功能
        Comparable com = (Comparable) data;
        Node newNode = new Node(com);
        if(this.root == null){  //判断根节点是否为空
            this.root = newNode;
        }else{
            this.root.addNode(newNode);
        }
        this.count++;
    }
    public Object[]  toArray(){    //返回所有数据，利用中序遍历的思想返回就是有序数据
        if(this.root == null){
            return null;
        }else{
            this.foot = 0;
            this.retobj = new Object[this.count];
            this.root.toArrayNode();
            return this.retobj;
        }
    }
}
