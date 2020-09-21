package LinkListTest;

interface Ilink<T>{   //设置泛型避免安全隐患
    public void add(T t);// 增加数据
    public int size(); //获取链表长度
    public boolean isEmpty();//判断是否是空集合
    public Object[] toArray(); //返回元素
}

class LinkImpl<T> implements Ilink<T>{
    class Node{    //保存节点的数据关系
        private T data;   //保存数据
        private Node next;   //保存下一个引用
        public Node (T data){
            this.data = data;
        }
        public void addNode(Node newNode){ //保存新的节点数据
            if(this.next == null){
                this.next = newNode;
            }else{
                this.next.addNode(newNode);
            }
        }
        public void toArrayNode(){
            LinkImpl.this.returnData[LinkImpl.this.foot++] = this.data;
            if(this.next != null){
                this.next.toArrayNode();
            }

        }

    }

    //Link类中定义成员属性
    private Node root;//根节点
    private int count = 0;
    private int foot;
    private Object[] returnData;
    //Link类中的方法
    public void add(T t){
        if(t == null)
            return;
        Node newNode = new Node(t);
        if(this.root == null){
            this.root = newNode;
        }else{
            this.root.addNode(newNode);
        }
        this.count++;
    }
    public int size(){
        return this.count;
    }
    public boolean isEmpty(){
        return this.count == 0;
    }
    public Object[] toArray(){
        if(this.isEmpty())
            return null;
        this.foot = 0;
        this.returnData = new Object[this.count];
        this.root.toArrayNode();
        return this.returnData;
    }

}


public class Test {
    public static void main(String arg[]) throws Exception {
        LinkImpl<String> l = new LinkImpl<>();
        l.add("123");
        l.add("456");
        l.add("12");
        l.add("46");
        System.out.println(l.size());
        Object[] result = l.toArray();
        for(Object obj:result){
            System.out.println(obj);
        }
    }
}


