package com.cx.designpatterns.templatemethod;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author wuming
 * @date 2019/3/2 20:48
 */
public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public List<?> query(){
        String sql = "";
        return jdbcTemplate.excuteQuery(sql, null, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                member.setAddr(rs.getString("addr"));
                return member;
            }
        });
    }
}
