package com.cx.designpatterns.templatemethod;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 模板方法模式:
 * 定义一个操作中的算法的结构,将一些步骤延迟到子类中,
 * 使得子类不改变算法的结构即可重新定义该算法某些特定的步骤
 *
 * @author wuming
 * @date 2019/3/1 10:40
 */
public class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws  Exception{
        return this.dataSource.getConnection();
    }

    private PreparedStatement createPreparedStatement(Connection conn,String sql) throws  Exception{
        return  conn.prepareStatement(sql);
    }


    private ResultSet executeQuery(PreparedStatement pstmt,Object [] values) throws  Exception{
        for (int i = 0; i <values.length; i ++){
            pstmt.setObject(i,values[i]);
        }
        return  pstmt.executeQuery();
    }

    private void closeStatement(PreparedStatement preparedStatement) throws  Exception{
        preparedStatement.close();
    }

    private void closeResultSet(ResultSet resultSet) throws  Exception{
        resultSet.close();
    }

    private void closeConnection(Connection conn) throws  Exception{
        //通常把它放到连接池回收
    }



    public List<?> excuteQuery(String sql, Object[] values, RowMapper<?> rowMapper) {
        try {
            //获取连接
            Connection connection = this.getConnection();

            //创建语句集
            PreparedStatement preparedStatement = this.createPreparedStatement(connection, sql);

            //执行语句,并获得结果
            ResultSet resultSet = this.executeQuery(preparedStatement, values);


            //解析语句集
            List<Object> objects = this.parseResultSet(resultSet, rowMapper);
            //关闭结果集
            this.closeResultSet(resultSet);

            //关闭语句集
            this.closeStatement(preparedStatement);

            //关闭连接
            this.closeConnection(connection);

            return objects;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Object> parseResultSet(ResultSet resultSet, RowMapper<?> rowMapper) throws Exception {

        List<Object> list = new ArrayList<>();
        int rowNum = 1;
        while(resultSet.next()){
            list.add(rowMapper.mapRow(resultSet, rowNum++));
        }
        return list;
    }


}
