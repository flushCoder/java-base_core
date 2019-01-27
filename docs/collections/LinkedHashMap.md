# LinkedHashMap底层分析

由[HashMap底层分析](https://github.com/changeandlove/java-base_core/tree/master/docs/collections/HashMap.md)得知,因为每次 **put** 操作是根据 **key** 的 **hashcode** 映射到 **Entry** 数组上，所以遍历出来的顺序并不是写入的顺序。  
LinkedHashMap是基于HashMap实现的有序Map,LinkedHashMap继承于HashMap,是在Entry中增加了after和before形成双向链表来维护Entry的顺序。  

LinkedHashMap的排序方式有两种:
- 根据写入顺序
- 根据访问顺序

### 数据结构
如图,在HashMap结构基础上,LinkedHashMap用双向链表维护它的有序性:
![](https://github.com/changeandlove/java-base_core/blob/master/picture/collection/linkedHashMap_data_strcture.jpg)

```java
public class LinkedHashMap<K,V>
    extends HashMap<K,V>
    implements Map<K,V>
{

    private static final long serialVersionUID = 3801124242820219131L;

    /**
     * The head of the doubly linked list.
     */
    private transient Entry<K,V> header;
    
    //此处省略......
    
}
private static class Entry<K,V> extends HashMap.Entry<K,V> { 
    // These fields comprise the doubly linked list used for iteration.
    Entry<K,V> before, after;

    Entry(int hash, K key, V value, HashMap.Entry<K,V> next) {
        super(hash, key, value, next); 
    }
    
    //此处省略......
}
```

其中 **Entry** 继承于 **HashMap** 的 **Entry**，并新增了上下节点的指针(**before**, **after**)，也就形成了双向链表。  
还有一个 **header** 的成员变量，是这个双向链表的头结点。
### 构造方法
```java
 @Override
 void init() {
     header = new Entry<>(-1, null, null, null);
     header.before = header.after = header;
 }
```
在无参构造方法中**LinkedHashMap**和**HashMap**完全一样,只是重写和**init**方法,初始化一个空的**header**。  
根据**accessOrder**参数可设置**LinkedHashMap**的顺序:
为true时:根据访问顺序  
为false时:根据写入顺序
### PUT方法

### GET方法

### 两种排序方式

### 使用LinkedHashMap实现LRU算法
- LRU算法 ：  
LRU（**Least recently used**，最近最少使用）算法根据数据的历史访问记录来进行淘汰数据，其核心思想是: 如果数据最近被访问过，那么将来被访问的几率也更高 

