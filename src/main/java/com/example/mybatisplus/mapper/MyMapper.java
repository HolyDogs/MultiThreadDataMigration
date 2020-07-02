package com.example.mybatisplus.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * mapper
 */
@Mapper
public interface MyMapper {
    /**
     * @return
     */
    //List<HashMap<String, Object>> findData();

    /**
     * @description ->重点企业财务状况主要经济指标
     * @author -> xufeng
     * @date ->
     **/
    List<HashMap<String, String>> selectNeedData();

    /**
     * @description -> 分行业工业企业主要经济指标
     * @author -> xufeng
     * @date ->
     **/
    List<HashMap<String, String>> selectFHYGYJJData();

    /**
     * @description -> 分行业工业生产者出厂价格指数
     * @author -> xufeng
     * @date ->
     **/
    List<HashMap<String, String>> selectFHYSCZData();

    /**
     * @description -> 全社会用电分类（全口径）
     * @author -> xufeng
     * @date ->
     **/
    List<HashMap<String, String>> selectQSHYDFLData();

    /**
     * @description -> 中国制造业采购经理指数
     * @author -> xufeng
     * @date ->
     **/
    List<HashMap<String, String>> selectZGZZCGData();

    /**
     * @description -> 重点工业园区主要经济指标
     * @author -> xufeng
     * @date ->
     **/
    List<HashMap<String, String>> selectZDGYYQData();

    /**
     * @description -> 重点企业产销总值及主要产品产量
     * @author -> xufeng
     * @date ->
     **/
    List<HashMap<String, String>> selectZDQYCXData();

    /**
     * @description -> 重点企业主要产品销售、库存、订货及价格
     * @author -> xufeng
     * @date ->
     **/
    List<HashMap<String, String>> selectZDQYCPXSData();

    /**
     * @description -> 重点企业主要经济指标月报表
     * @author -> xufeng
     * @date ->  2020/6/30
     **/
    List<HashMap<String, String>> selectZDQYJJZBData();

    /**
     * @description -> 园区工业企业主要经济指标
     * @author -> xufeng
     * @date ->  2020/6/30
     **/
    List<HashMap<String, String>> selectYQGYQYJJZBData();

    /**
     * @description -> 各设区市主要经济指标
     * @author -> xufeng
     * @date ->
     **/
    List<HashMap<String, String>> selectSQJJZBData11();

    /**
     * @description -> 工业企业主要经济指标
     * @author -> xufeng
     * @date ->
     **/
    List<HashMap<String, String>> selectGYQYZYJJZBData12();

    /**
     * @description -> 工业园区主要经济指标
     * @author -> xufeng
     * @date ->  2020/7/1
     **/
    List<HashMap<String, String>> selectGYYQZYJJZBData13();

    /**
     * @description -> 工业增加值完成情况
     * @author -> xufeng
     * @date ->  2020/7/1
     **/
    List<HashMap<String, String>> selectGYZJZData14();
    
    /**
     * @description -> 工业主要产品产量
     * @author -> xufeng
     * @date ->
     **/
    List<HashMap<String, String>> selectGYZYCPCLData15();

    /**
     * @description -> 江西省工业分县（市、区）主要经济指标
     * @author -> xufeng
     * @date -> 0701
     **/
    List<HashMap<String, String>> selectJXSGYFXJJZBData16();

    /**
     * @description -> 全国各地区工业增加值（只抽江西的）
     * @author -> xufeng
     * @date ->  0701
     **/
    List<HashMap<String, String>> selectQGGDQGYZJZSevenTData17();

    /**
     * @description -> 全国各地区工业产品销售率（只抽江西的）
     * @author -> xufeng
     * @date -> 0701
     **/
    List<HashMap<String, String>> selectQGGDQGYCPXSLData18();

    /**
     * @description -> 全国分地区工业增加值和产品销售率完成情况
     * @author -> xufeng
     * @date -> 0701
     **/
    List<HashMap<String, String>> selectGYZJZCPXSLData19();

    /**
     * @description -> 全国分地区主要工业产品生产完成情况（一）
     * @author -> xufeng
     * @date ->
     **/
    List<HashMap<String, String>> selectZYGYCPWCQKData20();

    /**
     * @description -> 全国分地区主要工业产品生产完成情况（二）
     * @author -> xufeng
     * @date -> 0702
     **/
    List<HashMap<String, String>> selectZYGYCPWCQKTwoData21();
}
