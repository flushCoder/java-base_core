package com.cx.designpatterns.templatemethod;

import java.sql.ResultSet;

/**
 * @author wuming
 * @date 2019/3/2 21:39
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs, int rowNum) throws Exception;

}
