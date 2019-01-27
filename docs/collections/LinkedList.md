# LinkedList底层分析
如图LinkedList是基于双向链表实现的:  
![](https://github.com/changeandlove/java-base_core/blob/master/picture/collection/linkedList_structure.jpg)

### 新增方法
源码如下:
```java
public boolean add(E e) {
    linkLast(e);
    return true;
}

void linkLast(E e) {
    final Node<E> l = last;
    final Node<E> newNode = new Node<>(l, e, null);
    last = newNode;
    if (l == null)
        first = newNode;
    else
        l.next = newNode;
    size++;
    modCount++;
}
```
根据代码得知,新增元素是直接插入到双向链表的**last**位置,相对于数组插入元素扩容时复制元素到新的数组中效率要高
### 查询方法
源码如下:
```java
public E get(int index) {
    checkElementIndex(index);
    return node(index).item;
}

Node<E> node(int index) {
    // assert isElementIndex(index);

    if (index < (size >> 1)) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    } else {
        Node<E> x = last;
        for (int i = size - 1; i > index; i--)
            x = x.prev;
        return x;
    }
}
```
根据源码得知,在查询时如果靠近头部或者尾部则从对应头部或者遍历链表获取元素,相对于数组直接取数组元素效率要低,特别是index在中间位置时
### 删除方法
```java
//直接删除first节点
public E remove() {
    return removeFirst();
}
    
//从某个位置删除
public E remove(int index) {
    checkElementIndex(index);
    return unlink(node(index));
}

//删除特定元素
public boolean remove(Object o) {
    if (o == null) {
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.item == null) {
                unlink(x);
                return true;
            }
        }
    } else {
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item)) {
                unlink(x);
                return true;
            }
        }
    }
    return false;
}

E unlink(Node<E> x) {
    // assert x != null;
    final E element = x.item;
    final Node<E> next = x.next;
    final Node<E> prev = x.prev;

    if (prev == null) {
        first = next;
    } else {
        prev.next = next;
        x.prev = null;
    }

    if (next == null) {
        last = prev;
    } else {
        next.prev = prev;
        x.next = null;
    }

    x.item = null;
    size--;
    modCount++;
    return element;
}
```
在删除元素时也需要遍历链表,所以有时删除链表元素要比数组慢