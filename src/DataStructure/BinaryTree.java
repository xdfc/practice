package DataStructure;

import java.util.Arrays;

/**
 * 实现一个二叉排序树
 * 中序遍历输出有顺序的结果
 * 自定义类，有父节点
 * 对一个定义好的Person类进行排序
 * Person类实现Comparable接口进行比较
 */

public class BinaryTree {
    public static void main(String[] args){
        BTree tree = new BTree<Person>();
        tree.add(new Person("Jake-20",20));
        tree.add(new Person("Make-80",80));
        tree.add(new Person("Bobo-30",30));
        tree.add(new Person("Lily-29",29));
        tree.add(new Person("fang-24",24));
        System.out.println(Arrays.toString(tree.toArray()));

    }
}

class BTree<T extends Comparable<T>>{  //extends设置泛型上限，表示只允许设置Comparable的子类
    private class Node{
        private Comparable<T> data; //存放Comparable，可以比较大小
        private Node parent;  //保存父节点
        private Node left;  //保存左节点
        private Node right;  //保存右节点
        public Node(Comparable<T> data){   //构造方法直接进行数据的存储
            this.data = data;
        }

        /**
         * 实现节点数据的适当位置存储
         * @param newNode 创建的新节点
         */
        public void addNode(Node newNode){
            if(newNode.data.compareTo((T)this.data)<0){  //比当前节点小
                if(this.left == null){   //现在没有左子树
                    this.left = newNode; //保存到左子树
                    newNode.parent = this;   //保存父节点
                }else{  //继续向左判断
                    this.left.addNode(newNode);   //继续向下判断
                }
            }else{
                if(this.right == null){  //现在没有右子树
                    this.right = newNode;  //没有右子树
                    newNode.parent = this;  //保存父节点
                }else{
                    this.right.addNode(newNode); //继续向下判断
                }
            }

        }

        /**
         * 实现所有数据的获取处理，按照中序遍历的形式完成,左，根，右
         */
        public void toArrayNode(){
            if(this.left!=null){  //有左子树
                this.left.toArrayNode();  //递归调用，找到最左的叶子节点
            }
            BTree.this.returnData[BTree.this.foot++] = this.data;  //外部类.this.成员 调用的是外部类的属性
            if(this.right!=null){  //有右子树
                this.right.toArrayNode();
            }
        }
    }

    //以下为二叉树的功能实现
    private Node root;  //保存根节点
    private int count;  //保存数据个数
    private Object[] returnData; //返回数据
    private int foot;
    /**
     * 进行数据保存
     * @param data 要保存的数据内容
     */
    public void add(Comparable<T> data){
        if(data == null){
            throw new NullPointerException("保存数据不允许为空");
        }
        //所有的数据本身不具备节点关系的匹配，那么一定要将其包装在Node类中
        Node newNode = new Node(data);  //保存节点
        if(this.root == null){   //现在没有根节点，第一个节点作为根节点
            this.root = newNode;
        }else{  //需要保存到合适的节点
            this.root.addNode(newNode);  //交由Node节点去完成
        }
        this.count++;
    }

    /**
     * 以对象数组的形式返回数据，没有数据返回null
     * @return 返回的数据
     */

    public Object[] toArray(){
        if(count == 0){
            return null;
        }
        this.returnData = new Object[this.count];
        this.foot = 0;
        this.root.toArrayNode();  //直接通过Node类负责
        return this.returnData;
    }

}

class Person implements Comparable<Person>{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Person person) {
        return this.age - person.age;
    }
    public String toString(){
        return "name:"+this.name+"、age:"+this.age;
    }
}