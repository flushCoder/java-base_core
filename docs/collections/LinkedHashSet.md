# LinkedHashSet底层分析

LinkedHashSet是有序的不允许重复的集合,继承于HashSet,LinkedHashSet中只有构造方法,只是把HashSet中的map初始化为LinkedHashMap,其他方法完全沿用HashSet的方法。

```java
//LinkedHashSet继承于HashSet
public class LinkedHashSet<E>
    extends HashSet<E>
    implements Set<E>, Cloneable, java.io.Serializable {
    
    public LinkedHashSet() {
        super(16, .75f, true);
    }
    
}

//HasSet的构造方法,初始化LinkedHashSet其实是初始化一个LinkedHashMap
public class HashSet<E>
    extends AbstractSet<E>
    implements Set<E>, Cloneable, java.io.Serializable{
    
    HashSet(int initialCapacity, float loadFactor, boolean dummy) {
        map = new LinkedHashMap<>(initialCapacity, loadFactor);
    }
    
}
```