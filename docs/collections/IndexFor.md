## HashMap确定数组下标计算方式

- 源码如下

```
int i = indexFor(hash, table.length);

static int indexFor(int h, int length) {
    // assert Integer.bitCount(length) == 1 : "length must be a non-zero power of 2";
    return h & (length-1);
}
```

因为**HashMap**的容量都是2的幂次方，可以用位运算  
举个例子：  
length:   0001 0000  16  
length-1: 0000 1111  15  
h:        0001 1111  31  
&         0000 1111  15  

总结：**length** 为数组的大小，所以索引范围为 **length-1** ，所以要保证计算出的**hash**值要在这个范围  
比如15的二进制数是 1111 不管计算出的hash值是多少最终 **h & (length-1)** 都在0-15

## HashMap1.8扩容Entry数组转移原理

- 1.8源码如下

```java
for (int j = 0; j < oldCap; ++j) {
    Node<K,V> e;
    if ((e = oldTab[j]) != null) {
        oldTab[j] = null;
        if (e.next == null) //单个元素的转移
            newTab[e.hash & (newCap - 1)] = e;
        else if (e instanceof TreeNode) //树结构的转移
            ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
        else { // 链表结构的转移
            Node<K,V> loHead = null, loTail = null;
            Node<K,V> hiHead = null, hiTail = null;
            Node<K,V> next;
            do {
                next = e.next;
                if ((e.hash & oldCap) == 0) {
                    if (loTail == null)
                        loHead = e;
                    else
                        loTail.next = e;
                    loTail = e;}else {
                    if (hiTail == null)
                        hiHead = e;
                    else
                        hiTail.next = e;
                    hiTail = e;}} while ((e = next) != null);
            if (loTail != null) {
                loTail.next = null;
                newTab[j] = loHead;}if (hiTail != null) {
                hiTail.next = null;
                newTab[j + oldCap] = hiHead;}}}}

```
- 1.7源码
```java
void transfer(Entry[] newTable, boolean rehash) {
    int newCapacity = newTable.length;
    for (Entry<K,V> e : table) {
        while(null != e) {
            Entry<K,V> next = e.next;
            if (rehash) {
                e.hash = null == e.key ? 0 : hash(e.key);
            }
            int i = indexFor(e.hash, newCapacity);
            e.next = newTable[i];
            newTable[i] = e;
            e = next;
        }
    }
}
```
JDK1.7中使用遍历数组和遍历链表进行元素转移,这样会导致链表中的元素会形成环装结构,形成死循环,前面已经分析过了,这里不做赘述.  
本次侧重分析JDK1.8链表结构的转移

比如现在的HashMap的数组长度是16,通过[HashMap确定数组下标计算方式](#HashMap确定数组下标计算方式)得知最终得到的index只取决于hashCode二进制的后四位,那么扩容之后hashCode对应的index只取决于后五位,由于二进制的特殊性,如果扩容之后hashCode对应的二进制的第五位是1,则对应的index就是原容量的index+原HashMap容量,
如果扩容之后hashCode对应二进制的第五位是0,则对应的index就是原容量的index

举个例子:(hashmap长度16)   
扩容前:   
hashCode : 0000 0101  
tableSize-1: 0000 1111  
index:0101 5  
扩容后:  (因为第五位是0,所以扩容之前,扩容之后的index相同)  
hashCode : 0000 0101  
tableSize-1: 0001 1111  
index:0101 5  

如果第五位是1:  
扩容前:  
hashCode: 0001 0101  
tableSize-1:0000 1111  
index:0101 5  
扩容后:  
hashCode: 0001 0101  
tableSize-1:0001 1111  
index:10101 21 (原index+原容量)

