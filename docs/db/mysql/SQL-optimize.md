# SQL优化总结
    
可以用 EXPLAIN 命令捕捉性能问题,查看是否命中索引  
[EXPLAIN 命令详解](https://www.cnblogs.com/gomysql/p/3720123.html)
### 不能使用索引归纳  
- 负向查询不使用索引  
  ```sql
  select name from user where id not in (1,3,5);
  ```
  应改为
  ```sql
  select name from user where id in (2,4);
  ```
- 前导模糊查询不使用索引
  ```sql
  select name from user where username like '%san';
  ```
  ```sql
  select name from user where username like 'zhang%'; --后导模糊查询可能会使用到索引
  ```
  建议可以考虑使用 **Lucene**,**Elasticsearch** 等全文索引工具来代替频繁的模糊查询。
    
- 在字段上进行计算不能命中索引  
    ```sql
    select name from user where FROM_UNIXTIME(create_time) < CURDATE();
    ```
    应修改为:
    ```sql
    select name from user where create_time < FROM_UNIXTIME(CURDATE());
    ```
### 复合索引
- 复合索引数据结构  
复合索引在文件中的存储方式是按照索引字段从左到右依次排序  
 ![](https://github.com/flushCoder/java-base_core/blob/master/picture/db/JointIndex.jpg)
 
    
- 最左前缀  
复合索引中的字段需要从左到右出现在查询条件中，中间字段不能存在范围查询的字段(**<**,**like**,**not in()**等,可以使用**in()**)，这样的sql可以使用该多列索引。  
根据业务场景条件中使用最频繁的字段放到符合索引的第一位  
如果给 user 表中的 (username pwd age) 字段创建了复合索引那么使用以下SQL 都是可以命中索引:
    ```sql
    select username from user where username='zhangsan' and pwd ='axsedf1sd' and age = 16; --顺序条件任意

    select username from user where username='zhangsan';
    ```
    以下不能命中索引:  
    ```sql
    select username from user where pwd ='axsedf1sd'; --不含有符合索引的第一个元素
    ```
- 复合索引可以让第二个索引字段排序  
当以第一个符合索引字段为查询条件，以第二个字段为排序字段，以下例子是(age,create_time符合索引
  ```sql
  select * from test where age = 20 order by create_time;
  ```
### 如果明确只有一条记录返回  
 ```sql
select name from user where username = 'zhangsan' limit 1;
 ```
   如果确定只有一条记录**limit**会停止继续向下扫描,效率会大幅度提升
 
### 字段的默认值不要为 null
   这样会带来和预期不一致的查询结果。
   
   
### join / order by / group by
- JOIN  
永远是小结果集驱动大结果集  
保证被驱动表上的Join条件字段已经被索引  
调join_buffer_size大小(查看大小 **show VARIABLES like 'join%';** 单位字节,默认256K)  

  ![](https://github.com/flushCoder/java-base_core/blob/master/picture/db/join_action.jpg)

  join原理:当两个表join查询时,经过mysql查询优化器查询出小的结果集,根据结果集的join条件轮询查询另外表的数据  
  当联合查询的表超过3个时,前两个表查询出的结果会放到join_buffer中供和第三个表关联,如果join_buffer_size过小会导致临时表存在磁盘上,造成I/O  
  
- ORDER BY  

  当ORDER BY的字段是索引时,根据B+ Tree 特点(叶子节点相互指向且有序的),查询出的数据已经是排好序的 

  ORDER BY字段不是索引(birthday)字段时:  
  ![](https://github.com/flushCoder/java-base_core/blob/master/picture/db/order_by_action.png)
  **双路排序:**  
  读取行指针和order by列到Sort buffer中,对他们进行排序,然后扫描已经排序好的指针,按照指针的地址再次去列表中读取对应的数据输出  
  双路排序开销相对较大,因为两次从列表中读取数据,地址不连续,会有大量随机I/O  
  
  **单路排序:**  
  读取所有要返回的字段放到Sort buffer中, 然后把行指针和排序字段放到单独的内存空间中进行排序,排序之后再去Sort buffer中按照指针顺序进行排序,这样就保证了只有一次I/0没有随机访问,但是会使用更多的空间  
  
  如果需要排序的列的总大小加上order by列的大小超过了 max_length_for_sort_data定义的字节，mysql就会使用双路排序
  
  **优化策略:**
  1、当ORDER BY的字段是索引时,根据B+ Tree 特点(叶子节点相互指向且有序的),查询出的数据已经是排好序的  
  2、增加max_length_for_sort_data使用单路排序  
  3、去掉不必要的返回字段  
  4、增加sort_buffer_size(减少在排序过程中对需要排序的数据进行分段)
  
- GROUP BY  
  ORDER BY前提是ORDER BY