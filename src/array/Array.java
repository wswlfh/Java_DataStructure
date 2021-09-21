package array;

public class Array<E> {
    private int size;  //当前元素个数
    private E data[];

    Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    Array() {
        this(10); //调用有参构造函数
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed! index is illegal");
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed! index is illegal");
        data[index] = e;
    }

    //末尾添加元素
    public void addLast(E e) {

//        if (size == data.length)
//            throw new IllegalArgumentException("AddLast failed,stack.Array is full");
//        data[size] = e;
//        size++;
        //复用
        add(size, e);
    }

    public void addFirst(E e) {

//        if (size == data.length)
//            throw new IllegalArgumentException("AddLast failed,stack.Array is full");
//        data[size] = e;
//        size++;
        //复用
        add(0, e);
    }

    //任意位置添加：要插入的位置之后的元素全部向后移动一位（向后赋值），腾出空间插入，更新size
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed,Require index >=0 and index <= size");
        if (size == data.length)
            resize(2 * data.length);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed,Require index >=0 and index <= size");
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; //不是内存泄漏，是个闲逛的资源，可以被回收
        if (size < getCapacity() / 2)
            resize(getCapacity()/2);
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    //删除指定元素 缺陷：只能删除找到的第一个元素
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }
        return false;
    }

    public int find(E e) { //只能找到第一个元素
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    @Override //覆盖父类写法：当使用println(arr)时默认使用toString函数，这里重写使用StringBuilder自定义输出数组内容
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format(
                "stack.Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i == size - 1)
                res.append(']');
            else
                res.append(',');
        }
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
