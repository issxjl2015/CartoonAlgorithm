package chapter1_base;

public class MyArray {

    private int[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 数组插入元素
     * */
    public void insert(int index, int element) throws Exception {
        // 判断访问下标是否超出范围
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出了数组实际元素范围");
        }
        if (size >= array.length) {
            resize();
        }
        // 从右往左循环，将元素逐个向右挪1位
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        // 腾出的位置放入新元素
        array[index] = element;
        size++;
    }

    /**
     *  数组扩容
     * */
    public void resize() {
        int[] arrayNew = new int[array.length * 2];
        // 从旧数组复制到新数组
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    /**
     * 数组删除元素
     * */
    public void delete(int index) throws Exception {
        // 判断访问下标是否超出范围
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        // 从左到右循环，将元素逐个向左挪1位
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i+1];
        }
        size--;
    }

    /**
     * 输出数组
     * */
    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyArray myArray = new MyArray(10);
        myArray.insert(0, 3);
        myArray.insert(1, 7);
        myArray.insert(2, 9);
        myArray.insert(3, 5);
        myArray.insert(1, 6);
        myArray.output();
        System.out.println("-------------------");
        myArray.delete(1);
        myArray.output();
    }
}
