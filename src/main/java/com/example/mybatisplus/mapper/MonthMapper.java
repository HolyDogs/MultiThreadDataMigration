package com.example.mybatisplus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author xf
 * @version 1.0
 * @date 2020/7/2 上午 11:24
 **/
@Mapper
public interface MonthMapper {
    /**
     * @description ->重点企业财务状况主要经济指标
     * @author -> xufeng
     * @date ->
     **/
    List<HashMap<String, String>> findByTimeDataOne(@Param("start") String start);

}
