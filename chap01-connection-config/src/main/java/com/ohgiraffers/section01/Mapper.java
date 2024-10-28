package com.ohgiraffers.section01;

import org.apache.ibatis.annotations.Select;

import java.sql.Date;

public interface Mapper {

    @Select("SELECT CURDATE() FROM DUAL")
    Date selectSysDate();
}
