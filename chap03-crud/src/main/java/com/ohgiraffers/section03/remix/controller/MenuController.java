package com.ohgiraffers.section03.remix.controller;

import com.ohgiraffers.common.PrintResult;
import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section03.remix.service.MenuService;

import java.util.List;

public class MenuController {

    private final PrintResult printResult;

    private final MenuService menuService;

    public MenuController(){
        printResult = new PrintResult();
        menuService = new MenuService();
    }

    public void selectAllMenu(){
        List<MenuDTO> menuList = menuService.selectAllMenu();

        if (menuList != null){
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }
}
