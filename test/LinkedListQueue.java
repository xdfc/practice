import java.util.NoSuchElementException;

/**
 * 使用单向链表实现的先进先出（FIFO）队列。
 */
public class LinkedListQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }
    }

    /** 在队尾添加元素。 */
    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    /** 删除并返回队头元素。 */
    public T dequeue() {
        ensureNotEmpty();

        T value = head.value;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }

        return value;
    }

    /** 返回队头元素，但不删除。 */
    public T peek() {
        ensureNotEmpty();
        return head.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void ensureNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("队列为空");
        }
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("队头元素: " + queue.peek());
        System.out.println("出队元素: " + queue.dequeue());
        System.out.println("出队元素: " + queue.dequeue());
        System.out.println("队列长度: " + queue.size());
        System.out.println("队列是否为空: " + queue.isEmpty());
    }
}
