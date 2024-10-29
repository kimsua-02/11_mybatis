package com.ohgiraffers.section03.remix.service;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section03.remix.model.MenuMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getRemixSqlSession;

public class MenuService {

    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getRemixSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuList = menuMapper.selectAllMenu();

        sqlSession.close();

        return menuList;
    }

}
