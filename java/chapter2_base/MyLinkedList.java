package chapter2_base;

public class MyLinkedList {

    /**
     * 链表节点
     * */
    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    // 头结点指针
    private Node head;
    // 尾结点指针
    private Node last;
    // 链表实际长度
    private int size;

    /**
     * 链表插入元素
     * */
    public void insert(int data, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超过链表节点范围！");
        }
        Node insertedNode = new Node(data);
        if (size == 0) {
            // 空链表
            head = insertedNode;
            last = insertedNode;
        } else if (index == 0) {
            // 插入头部
            insertedNode.next = head;
            head = insertedNode;
        } else if (size == index) {
            // 插入尾部
            last.next = insertedNode;
            last = insertedNode;
        } else {
            // 插入中间
            Node prevNode = get(index - 1); // 查找链表的元素
            insertedNode.next = prevNode.next;
            prevNode.next = insertedNode;
        }
        size++;
    }

    /**
     * 删除链表元素
     * */
    public Node remove(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出了链表节点的范围");
        }
        Node removedNode = null;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else if (index  == size - 1) {
            // 删除尾结点
            Node prevNode = get(index - 1);
            removedNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {
            // 删除中间节点
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            removedNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removedNode;
    }

    /**
     * 查找链表元素
     * */
    public Node get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出了链表节点的范围");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表
     * */
    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws Exception{
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(3, 0);
        myLinkedList.insert(7, 1);
        myLinkedList.insert(9, 2);
        myLinkedList.insert(6, 3);
        myLinkedList.insert(4, 4);
        myLinkedList.insert(2, 5);
        myLinkedList.remove(0);
        myLinkedList.output();

    }

}
