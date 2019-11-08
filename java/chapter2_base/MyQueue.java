package chapter2_base;

/**
 * 队列
 * Noel： (队尾下标 + 1) % 数组长度 = 对头下标， 表示此队列已经满了
 * */
public class MyQueue {

    private int[] array;
    // 队头
    private int front;
    // 队尾
    private int rear;

    public MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 入队
     * */
    public void enQueue(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
           throw new Exception("队列满了");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    /**
     * 出队
     * */
    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已经为空");
        }
        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    /**
     * 输出队列
     * */
    public void output() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception{
        MyQueue myQueue = new MyQueue(6);
        myQueue.enQueue(4);
        myQueue.enQueue(3);
//        myQueue.enQueue(7);
        myQueue.enQueue(9);
        myQueue.enQueue(2);
        myQueue.enQueue(1);
        myQueue.output();
        System.out.println("------------");
        myQueue.deQueue();
        myQueue.output();
    }
}
