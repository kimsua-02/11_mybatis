package com.ohgiraffers.section01.xmlconfig.service;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.model.MenuDAO;
import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {

    private final MenuDAO menuDAO;

    public MenuService(){
        menuDAO = new MenuDAO();
    }

    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();
        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);
        sqlSession.close();
        return menuList;
    }

    // MenuDTO = 메소드 리턴 타입이랑께 꼭 기억하쇼.
    public MenuDTO selectMenuByCode(int code) {
        SqlSession sqlSession = getSqlSession();
        MenuDTO menu = menuDAO.selectMenuByCode(sqlSession, code);
        sqlSession.close();
        return menu;
    }

    public boolean registMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.insertMenu(sqlSession,menu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

}
