package com.example.mybatisplus.entity;

import lombok.Getter;

/**
 * @author xf
 * @version 1.0
 * @date 2020/7/1 上午 10:46
 **/
@Getter
public enum EnrolEnum {

    QSTJ("360000", "全省总计"),

    ZHONGYANG("100020", "中央企业"),

    NANC("360100", "南昌市"),

    JINGDZ("360200", "景德镇市"),

    PINGX("360300", "萍乡市"),

    JIUJ("360400", "九江市"),

    GONGQCS("361200", "共青城市"),

    XINY("360500", "新余市"),

    YINGT("360600", "鹰潭市"),

    GANZ("360700", "赣州市"),

    RUIJ("361300", "瑞金市"),

    JIAN("360800", "吉安市"),

    ANFU("361400", "安福县"),

    YIC("360900", "宜春市"),

    FENGC("361500", "丰城市"),

    FUZ("361000", "抚州市"),

    NANCHENG("361600", "南城县"),

    SHANGR("361100", "上饶市"),

    POY("361700", "鄱阳县");


    private String enrolId;

    private String enrolName;

    EnrolEnum(String enrolId, String enrolName) {
        this.enrolId = enrolId;
        this.enrolName = enrolName;
    }

    public static EnrolEnum get(String key){
        if ( key != null) {
            EnrolEnum[] enrolEnums = EnrolEnum.values();
            for (EnrolEnum enrolEnum : enrolEnums) {
                if (key.equals(enrolEnum.getEnrolId())) {
                    return enrolEnum;
                }
            }
        }
        return null;
    }

}
