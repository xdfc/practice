package Demo;

/**
 * 搜索二叉树（Binary Search Tree, BST）实现
 * 
 * 特性：
 * 1. 左子树上所有节点的值均小于它的根节点的值
 * 2. 右子树上所有节点的值均大于它的根节点的值
 * 3. 左右子树也分别为搜索二叉树
 */
public class BinarySearchTree {

    // 节点类
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * 插入节点
     * @param val 要插入的值
     */
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode node, int val) {
        // 如果当前节点为空，创建新节点
        if (node == null) {
            return new TreeNode(val);
        }

        // 根据值的大小决定插入到左子树还是右子树
        if (val < node.val) {
            node.left = insertRec(node.left, val);
        } else if (val > node.val) {
            node.right = insertRec(node.right, val);
        }
        // 如果值相等，不插入（可根据需求修改）

        return node;
    }

    /**
     * 搜索节点
     * @param val 要搜索的值
     * @return 是否找到
     */
    public boolean search(int val) {
        return searchRec(root, val);
    }

    private boolean searchRec(TreeNode node, int val) {
        // 基础情况：节点为空，未找到
        if (node == null) {
            return false;
        }

        // 找到目标值
        if (node.val == val) {
            return true;
        }

        // 根据值的大小决定搜索左子树还是右子树
        if (val < node.val) {
            return searchRec(node.left, val);
        } else {
            return searchRec(node.right, val);
        }
    }

    /**
     * 删除节点
     * @param val 要删除的值
     */
    public void delete(int val) {
        root = deleteRec(root, val);
    }

    private TreeNode deleteRec(TreeNode node, int val) {
        if (node == null) {
            return null;
        }

        // 找到要删除的节点
        if (val < node.val) {
            node.left = deleteRec(node.left, val);
        } else if (val > node.val) {
            node.right = deleteRec(node.right, val);
        } else {
            // 找到要删除的节点

            // 情况1：节点没有子节点或只有一个子节点
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // 情况2：节点有两个子节点
            // 找到右子树中的最小节点（中序后继）
            node.val = findMin(node.right);
            // 删除右子树中的最小节点
            node.right = deleteRec(node.right, node.val);
        }

        return node;
    }

    /**
     * 查找最小值
     * @param node 起始节点
     * @return 最小值
     */
    private int findMin(TreeNode node) {
        int minVal = node.val;
        while (node.left != null) {
            node = node.left;
            minVal = node.val;
        }
        return minVal;
    }

    /**
     * 查找树中的最小值
     * @return 最小值，如果树为空则返回 -1
     */
    public int findMinimum() {
        if (root == null) {
            return -1;
        }
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.val;
    }

    /**
     * 查找树中的最大值
     * @return 最大值，如果树为空则返回 -1
     */
    public int findMaximum() {
        if (root == null) {
            return -1;
        }
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.val;
    }

    /**
     * 中序遍历（升序输出）
     */
    public void inorderTraversal() {
        System.out.print("中序遍历: ");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(TreeNode node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.val + " ");
            inorderRec(node.right);
        }
    }

    /**
     * 前序遍历
     */
    public void preorderTraversal() {
        System.out.print("前序遍历: ");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    /**
     * 后序遍历
     */
    public void postorderTraversal() {
        System.out.print("后序遍历: ");
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(TreeNode node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.val + " ");
        }
    }

    // 测试方法
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // 插入数据
        System.out.println("=== 插入数据 ===");
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) {
            bst.insert(val);
            System.out.println("插入: " + val);
        }

        // 遍历
        System.out.println("\n=== 遍历结果 ===");
        bst.inorderTraversal();      // 中序遍历（升序）
        bst.preorderTraversal();     // 前序遍历
        bst.postorderTraversal();    // 后序遍历

        // 搜索
        System.out.println("\n=== 搜索测试 ===");
        int[] searchValues = {40, 25, 70};
        for (int val : searchValues) {
            boolean found = bst.search(val);
            System.out.println("搜索 " + val + ": " + (found ? "找到" : "未找到"));
        }

        // 删除节点
        System.out.println("\n=== 删除测试 ===");
        System.out.println("删除 20 (叶子节点)");
        bst.delete(20);
        bst.inorderTraversal();

        System.out.println("删除 30 (有一个子节点)");
        bst.delete(30);
        bst.inorderTraversal();

        System.out.println("删除 50 (有两个子节点)");
        bst.delete(50);
        bst.inorderTraversal();

        System.out.println("\n=== 最终结果 ===");
        bst.inorderTraversal();

        // 最值查找测试
        System.out.println("\n=== 最值查找测试 ===");
        System.out.println("最小值: " + bst.findMinimum());
        System.out.println("最大值: " + bst.findMaximum());
    }
}
