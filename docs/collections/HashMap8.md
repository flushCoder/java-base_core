# HashMap源码分析
> 基于JDK1.8  

![]()

相对于JDK1.7而言，当 Hash 冲突严重时，在桶上形成的链表会变的越来越长，这样在查询时的效率就会越来越低；时间复杂度为 O(N)。  
JDK1.8 当链表的长度达到8时，会转成红黑树，红黑树最大节点数是64，当节点小于6时又转成链表结构，红黑树的查询时间复杂度是O(logN)  
JDK1.8的链表采用尾插发，避免了扩容时头插法形成链表结构  

[HashMap确定数组下标计算方式与HashMap1.8扩容Entry数组转移原理](https://github.com/changeandlove/java-base_core/tree/master/docs/collections/IndexFor.md)