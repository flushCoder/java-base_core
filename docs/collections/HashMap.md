# HashMap源码分析
> 基于JDK1.7

![]()

如图所示，HashMap是基于 Entry<K,V> 数组和 Entry<K,V> 单向链表实现的，是线程不安全的。其中参数为：

- 默认初始容量（**DEFAULT_INITIAL_CAPACITY**）
- 最大容量（**MAXIMUM_CAPACITY**）
- 默认重载因子（**DEFAULT_LOAD_FACTOR** 赋值到 **loadFactor**）
- 可自定义重载因子（**loadFactor**）
- 容量（**size**）
- HashMap扩容阈值（**threshold**）

当 **size * loadFactor > threshold** 时就会发生扩容，默认初始容量为16，重载因子为0.75
# 构造方法

- 自定义初始值和重载因子的构造方法
```
     public HashMap(int initialCapacity, float loadFactor) {
            if (initialCapacity < 0)
                throw new IllegalArgumentException("Illegal initial capacity: " +
                                                   initialCapacity);
            if (initialCapacity > MAXIMUM_CAPACITY)
                initialCapacity = MAXIMUM_CAPACITY;
            if (loadFactor <= 0 || Float.isNaN(loadFactor))
                throw new IllegalArgumentException("Illegal load factor: " +
                                                   loadFactor);
    
            this.loadFactor = loadFactor;
            threshold = initialCapacity;
            init();
 }
```

- 自定义初始值的构造方法，重载因子为默认的0.75(因为每次hashMap扩容消耗还是比较大的，所以最好在确定放入元素多少的情况下指定初始值)
```
    public HashMap(int initialCapacity) {
            this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }
```
# PUT方法  
- 允许key和value均为null
- 如果key相同，新值覆盖老值，将老值返回
- 将传入的 Key 做 hash 运算计算出 hashcode,然后根据数组长度取模计算出在数组中的 index 下标。
  
  由于在计算中位运算比取模运算效率高的多，所以 HashMap 规定数组的长度为 2^n 。这样用 2^n - 1 做位运算与取模效果一致，并且效率还要高出许多。
  
  由于数组的长度有限，所以难免会出现不同的 Key 通过运算得到的 index 相同，这种情况可以利用链表来解决，HashMap 会在 table[index]处形成链表，采用头插法将数据插入到链表中。
- 如下为 JDK1.7 的put方法的源码，做逐步解析
```java
    public V put(K key, V value) {
        if (table == EMPTY_TABLE) {
            inflateTable(threshold);
        }
        if (key == null)
            return putForNullKey(value);
        int hash = hash(key); //计算出对应的hash值，不同的key计算出相同的hash值可以用再次hash法或者链表法，这里用链表法
        int i = indexFor(hash, table.length);
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }

        modCount++;
        addEntry(hash, key, value, i);
        return null;
    }
```
- Entry<K,V>数组为空时，把初始容量置为大于等于当前初始值的最小2的幂次方，重置重载阈值大小，重置数组容量
```
    inflateTable(threshold);
    
    private void inflateTable(int toSize) {
        // Find a power of 2 >= toSize
        int capacity = roundUpToPowerOf2(toSize);

        threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);
        table = new Entry[capacity];
        initHashSeedAsNeeded(capacity);
    }

```

- HashMap确定数组下标计算方式
  [HashMap确定数组下标计算方式](https://github.com/changeandlove/java-base_core/tree/master/docs/collections/hashmap/IndexFor.md)
- 当Key是null时，插在 **table[0]** 位置
```
    putForNullKey(value);
    
    private V putForNullKey(V value) {
        for (Entry<K,V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        modCount++;
        addEntry(0, null, value, 0);
        return null;
    }

```
- 当容量大于等于扩容阈值并且数组中的元素不为null时，进行扩容（在并发情况下进行扩容单项链表会出现环形结构）
- 扩容大致流程：  
  1、初始化原长度2倍的数组  
  2、循环旧的数组，因为是链表，将下一个节点赋值到临时变量  
  3、根据新的数组长度，重新计算数组下标，用头插法把节点插入链表中  
```
    void addEntry(int hash, K key, V value, int bucketIndex) {
        if ((size >= threshold) && (null != table[bucketIndex])) {
            resize(2 * table.length);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }

        createEntry(hash, key, value, bucketIndex);
    }

    void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable, initHashSeedAsNeeded(newCapacity));
        table = newTable;
        threshold = (int)Math.min(newCapacity * loadFactor, MAXIMUM_CAPACITY + 1);
    }
    
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
    
    void createEntry(int hash, K key, V value, int bucketIndex) {
        Entry<K,V> e = table[bucketIndex];
        table[bucketIndex] = new Entry<>(hash, key, value, e);
        size++;
    }

```

- 在并发情况下，transfer 方法中会出现链表，快速失败法见：  
  [HashMap死循环和fail-fast](http://www.importnew.com/22011.html)
  出现死循环见如下 [GET方法注释](#GET方法)
 
# GET方法

get 和 put 类似，也是将传入的 Key 计算出 index ，如果该位置上是一个链表就需要遍历整个链表，通过 key.equals(k) 来找到对应的元素

```java
    public V get(Object key) {
        if (key == null)
            return getForNullKey();
        Entry<K,V> entry = getEntry(key);

        return null == entry ? null : entry.getValue();
    }

    final Entry<K,V> getEntry(Object key) {
        if (size == 0) {
            return null;
        }

        int hash = (key == null) ? 0 : hash(key);
        for (Entry<K,V> e = table[indexFor(hash, table.length)];
             e != null;
             e = e.next) {//在形成死循环时e=e.next永远不为空
            Object k;
            if (e.hash == hash &&
                ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }
```