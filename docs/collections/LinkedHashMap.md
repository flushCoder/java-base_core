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
源码为:
```java
public V put(K key, V value) {
    if (table == EMPTY_TABLE) {
        inflateTable(threshold);
    }
    if (key == null)
        return putForNullKey(value);
    int hash = hash(key);
    int i = indexFor(hash, table.length);
    for (Entry<K,V> e = table[i]; e != null; e = e.next) {
        Object k;
        if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
            V oldValue = e.value;
            e.value = value;
            //当进行value覆盖时,LinkedHashMap对此方法进行了重写
            e.recordAccess(this);
            return oldValue;
        }
    }

    modCount++;
    addEntry(hash, key, value, i);
    return null;
}
```
主体的实现都是借助于 **HashMap** 来完成的，只是对其中的 **recordAccess()**, **addEntry()**, **createEntry()** 进行了重写。

```java
//LinkedHashMap对此方法进行了重写
//当accessOrder为true时,将此节点在原来的位置删除,并且把此节点插入到头结点处
//当accessOrder为false时,不删除此节点,此节点位置不变,只是值发生改变
void recordAccess(HashMap<K,V> m) {
    LinkedHashMap<K,V> lm = (LinkedHashMap<K,V>)m;
    if (lm.accessOrder) {
        lm.modCount++;
        remove();
        addBefore(lm.header);
    }
}

private void remove() {
    before.after = after;
    after.before = before;
}

private void addBefore(Entry<K,V> existingEntry) {
    after  = existingEntry;
    before = existingEntry.before;
    before.after = this;
    after.before = this;
}
```

```java
//HashMap的addEntry方法
void addEntry(int hash, K key, V value, int bucketIndex) {
    if ((size >= threshold) && (null != table[bucketIndex])) {
        resize(2 * table.length);
        hash = (null != key) ? hash(key) : 0;
        bucketIndex = indexFor(hash, table.length);
    }

    createEntry(hash, key, value, bucketIndex);
}

//此createEntry方法是LinkedHashMap方法进行了重写
void createEntry(int hash, K key, V value, int bucketIndex) {
    HashMap.Entry<K,V> old = table[bucketIndex];
    Entry<K,V> e = new Entry<>(hash, key, value, old);
    table[bucketIndex] = e;
    //将新的节点插入到头结点处
    e.addBefore(header);
    size++;
}

//LinkedHashMap的addEntry方法对HashMap的addEntry方法进行了重写
void addEntry(int hash, K key, V value, int bucketIndex) {
    super.addEntry(hash, key, value, bucketIndex);
    // Remove eldest entry if instructed
    //获取链表尾节点
    Entry<K,V> eldest = header.after;
    //LinkedHashMap中默认为false,不对尾节点进行删除,可自行重写此方法实现LRU
    if (removeEldestEntry(eldest)) {
        removeEntryForKey(eldest.key);
    }
}
```
### GET方法
```java
//次方法重写了HashMap的get方法
public V get(Object key) {
    Entry<K,V> e = (Entry<K,V>)getEntry(key);
    if (e == null)
        return null;
    e.recordAccess(this);
    return e.value;
}

//当accessOrder为true时,将此节点从原来节点处删除,并加到头节点
void recordAccess(HashMap<K,V> m) {
    LinkedHashMap<K,V> lm = (LinkedHashMap<K,V>)m;
    if (lm.accessOrder) {
        lm.modCount++;
        remove();
        addBefore(lm.header);
    }
}
```
### 两种排序方式
根据**accessOrder**参数可设置**LinkedHashMap**的顺序:  
为true时:根据访问顺序  
为false时:根据写入顺序
### 使用LinkedHashMap实现LRU算法
- LRU算法 ：  
LRU（**Least recently used**，最近最少使用）算法根据数据的历史访问记录来进行淘汰数据，其核心思想是: 如果数据最近被访问过，那么将来被访问的几率也更高   
可继承**LinkedHashMap**中的**removeEldestEntry**方法,返回为true即可

