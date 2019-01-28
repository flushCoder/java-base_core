# HashSet底层分析

**HashSet**是一个不允许存储重复元素的集合,下面是HashSet的全局变量和构造方法
```java
private transient HashMap<E,Object> map;

// Dummy value to associate with an Object in the backing Map
private static final Object PRESENT = new Object();

/**
 * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has
 * default initial capacity (16) and load factor (0.75).
 */
public HashSet() {
    map = new HashMap<>();
}
```
HashSet底层维护了一个HashMap,[HashMap底层分析](https://github.com/changeandlove/java-base_core/tree/master/docs/collections/HashMap.md)

### add方法
```java
public boolean add(E e) {
    return map.put(e, PRESENT)==null;
}
```
add方法实际上是把要存储的元素当做**key**,**value**为**PRESENT**(全局变量定义为空)保存到**HashMap**中,因为**HashMap**当**key**相同时,新值会覆盖老值,所以**HashSet**的元素是不重复的。  
因此,HashMap存在的问题HashSet也存在。