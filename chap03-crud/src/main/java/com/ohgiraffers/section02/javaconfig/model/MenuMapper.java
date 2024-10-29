package com.ohgiraffers.section02.javaconfig.model;

import com.ohgiraffers.dto.MenuDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MenuMapper {

    @Results(id = "menuResultMap", value = {
            @Result(id = true, property = "code", column = "MENU_CODE"),
            @Result(property = "name", column = "MENU_NAME"),
            @Result(property = "price", column = "MENU_PRICE"),
            @Result(property = "categoryCode", column = "COTEGORY_CODE"),
            @Result(property = "orderableStatus", column = "ORDERABLESTATUS")

    })

    @Select("SELECT MENU_CODE, MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS ,FROM TBL_MENU, WHERE ORDERABLE_STATUS = 'Y'")
    List<MenuDTO> selectAllMenu();

    @Select("SELECT MENU_CODE, MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS ,FROM TBL_MENU, WHERE ORDERABLE_STATUS = 'Y', AND MENU_CODE = #{ code }")
    @ResultMap("menuResultMap")
    MenuDTO selcetMenuByCode(int code);

    @Insert("INSERT INTO TBL_MENU (" +
            "MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS " +
            ")VALUES (" +
            "  #{name}, #{price}, #{categoryCode}, 'Y')")
    int insertMenu(MenuDTO menu);


    @Update("UPDATE TBL_MENU " +
            "SET MENU_NAME = #{name}," +
            "    MENU_PRICE = #{price}," +
            "    CATEGORY_CODE = #{ categoryCode } " +
            "WHERE MENU_CODE = #{code}")
    int updateMenu(MenuDTO menu);


    @Delete("DELETE FROM TBL_MENU WHERE MENU_CODE = #{code}")
    int deleteMenu(int code);
}
