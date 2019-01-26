# LinkedHashMap底层分析

由[HashMap底层分析](https://github.com/changeandlove/java-base_core/tree/master/docs/collections/HashMap.md)得知,因为每次 **put** 操作是根据 **key** 的 **hashcode** 映射到 **Entry** 数组上，所以遍历出来的顺序并不是写入的顺序。  
LinkedHashMap是基于HashMap实现的有序Map,LinkedHashMap继承于HashMap,是在Entry中增加了after和before形成双向链表来维护Entry的顺序。  

LinkedHashMap的排序方式有两种:
- 根据写入顺序
- 根据访问顺序

### 数据结构

### PUT方法

### GET方法

### 两种排序方式

### 使用LinkedHashMap实现LRU算法
- LRU算法 ：  
LRU（**Least recently used**，最近最少使用）算法根据数据的历史访问记录来进行淘汰数据，其核心思想是: 如果数据最近被访问过，那么将来被访问的几率也更高 

