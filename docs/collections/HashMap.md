# HashMap 源码分析
> 基于JDK1.7

![]()

如图所示，HashMap是基于 Entry<K,V> 数组和 Entry<K,V> 单向链表实现的。其中参数为：

- 默认初始容量（**DEFAULT_INITIAL_CAPACITY**）
- 最大容量（**MAXIMUM_CAPACITY**）
- 默认重载因子（**DEFAULT_LOAD_FACTOR** 赋值到 **loadFactor**）
- 可自定义重载因子（**loadFactor**）
- 容量（**size**）
- HashMap扩容阈值（**threshold**）

当 **size * loadFactor>threshold** 时就会发生扩容

