package com.example.mybatisplus.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xf
 * @version 1.0
 * @date 2020/6/23 下午 4:56
 **/
public class NullValueHandler implements TypeHandler<String> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        if ((s == null || "".equals(s)) && jdbcType == JdbcType.VARCHAR){
            preparedStatement.setString(i, " ");
        }else {
            preparedStatement.setString(i, s);
        }
    }

    @Override
    public String getResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getString(s);
    }

    @Override
    public String getResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getString(i);
    }

    @Override
    public String getResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getString(i);
    }
}
