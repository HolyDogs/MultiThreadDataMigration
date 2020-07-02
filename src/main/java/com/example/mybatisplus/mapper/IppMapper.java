package com.example.mybatisplus.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.mybatisplus.entity.UserSpace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Mapper
@DS("slave")
public interface IppMapper {

    List<UserSpace> findData();

    int insertToDataMove(@Param("theMap") HashMap<String, String> dataMap);
}
