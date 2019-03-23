# Sort相关
### Comparable
**Comparable** 是一个只包含一个抽象方法 **compareTo** 的接口,   
c1.compareTo(c2) 返回值为 **int**:  
1、若 **c1 > c2**, 返回正数  
2、若 **c1 < c2**, 返回负数  
3、若 **c1 = c2**, 返回 0  
方法 : **Collections.sort(List<T>  list)**, 若**T**实现Comparable接口,则自动排序.
  
### Comparator比较器

**Comparator** 接口里面有一个 **compare** 方法，方法有两个参数**T o1**和**T o2**，是泛型的表示方式，分别表示待比较的两个对象，方法返回值和**Comparable**接口一样是**int**，有三种情况：
1、o1大于o2，返回正整数  
2、o1等于o2，返回0  
3、o1小于o3，返回负整数  

方法 : **Collections.sort(List<T> list, Comparator<? super T> c)**, **T**不需要实现**Comparable**接口