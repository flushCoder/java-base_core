# ArrayList底层分析
**ArrayList** 是实现 **List** 接口和 **RandomAccess** 接口,支持插入空数据和随机访问。

```java
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
{

    //列表的默认容量,也是列表的最小容量
    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData; // non-private to simplify nested class access

    private int size;

}
```
**elementData** 是列表底层数组,**size** 是列表的列表的大小(元素个数)  
列表的默认初始容量是10

### 构造方法:初始化 **elementData** 数组
```java
public ArrayList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}
```
### add()方法

1、直接add元素
 - 首先进行扩容校验。
 - 将插入的值放到尾部，并将 size + 1。
```java
public boolean add(E e) {
    ensureCapacityInternal(size + 1);  // Increments modCount!!
    elementData[size++] = e;
    return true;
}
```
2、向某个位置add元素
- 首先进行扩容校验。
- 将index之后的元素移动到index+1之后的位置,空出index位置
- 将插入的值放到尾部，并将 size + 1。
 
```java
//指定位置add元素
public void add(int index, E element) {
    //位置是否越界判断
    rangeCheckForAdd(index);

    ensureCapacityInternal(size + 1);  // Increments modCount!!
    System.arraycopy(elementData, index, elementData, index + 1,
                     size - index);
    elementData[index] = element;
    size++;
}
```
列表的扩容其实就是将原来列表容量扩大一半 **int newCapacity = oldCapacity + (oldCapacity >> 1);**,将原数组的数据转移到新的数组中。

```java
private void ensureCapacityInternal(int minCapacity) {
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
    }

    ensureExplicitCapacity(minCapacity);
}

private void ensureExplicitCapacity(int minCapacity) {
    modCount++;

    // overflow-conscious code
    //如果size+1比数组长度大则进行列表扩容
    if (minCapacity - elementData.length > 0)
        grow(minCapacity);
}

//列表扩容
private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    // minCapacity is usually close to size, so this is a win:
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```
### RandomAccess接口

**RandomAccess**是一个空接口，而空接口的作用一般是起到一个标识的作用。   
通俗点讲，就是判断一个list是否实现了**RandomAcess**接口，如果实现了，采用简单的**for**循环进行访问速度比较快。 
如果未实现RandomAcess接口，则采用iterator循环访问速度比较快。

### 序列化
**elementData** 数组是用**transient**修饰的,可以防止被自动序列化
```java
transient Object[] elementData; // non-private to simplify nested class access
```
>当对象中自定义了 writeObject 和 readObject 方法时(必须要实现serilizebal接口)，JVM 会调用这两个自定义方法来实现序列化与反序列化。  

所以可以看出ArrayList 只序列化了被使用的元素
```java
private void writeObject(java.io.ObjectOutputStream s)
    throws java.io.IOException{
    // Write out element count, and any hidden stuff
    int expectedModCount = modCount;
    s.defaultWriteObject();

    // Write out size as capacity for behavioural compatibility with clone()
    s.writeInt(size);

    // Write out all elements in the proper order.
    for (int i=0; i<size; i++) {
        s.writeObject(elementData[i]);
    }

    if (modCount != expectedModCount) {
        throw new ConcurrentModificationException();
    }
}

/**
 * Reconstitute the <tt>ArrayList</tt> instance from a stream (that is,
 * deserialize it).
 */
private void readObject(java.io.ObjectInputStream s)
    throws java.io.IOException, ClassNotFoundException {
    elementData = EMPTY_ELEMENTDATA;

    // Read in size, and any hidden stuff
    s.defaultReadObject();

    // Read in capacity
    s.readInt(); // ignored

    if (size > 0) {
        // be like clone(), allocate array based upon size not capacity
        ensureCapacityInternal(size);

        Object[] a = elementData;
        // Read in all elements in the proper order.
        for (int i=0; i<size; i++) {
            a[i] = s.readObject();
        }
    }
}

```
