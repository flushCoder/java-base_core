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
  select name from user where username like 'zhang%';
  ```
  上面两条都不使用索引(MySQL5.7版本)  
  建议可以考虑使用 **Lucene**,**Elasticsearch** 等全文索引工具来代替频繁的模糊查询。
    
- 在字段上进行计算不能命中索引  
    ```sql
    select name from user where FROM_UNIXTIME(create_time) < CURDATE();
    ```
    应修改为:
    ```sql
    select name from user where create_time < FROM_UNIXTIME(CURDATE());
    ```
### 复合索引的最左前缀  
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

### 如果明确只有一条记录返回  
 ```sql
select name from user where username = 'zhangsan' limit 1;
 ```
   如果确定只有一条记录**limit**会停止继续向下扫描,效率会大幅度提升
 
 ### 字段的默认值不要为 null
   这样会带来和预期不一致的查询结果。