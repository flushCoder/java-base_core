# HashMap确定数组下标计算方式

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