package com.ohgiraffers.section01.xmlconfig.controller;

import com.ohgiraffers.common.PrintResult;
import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.service.MenuService;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class MenuController {

    // view 대신 사용할 객체

    private final PrintResult printResult;
    // 컨트롤러의 명령을 받을 객체

    private final MenuService menuService;

    // 컨트롤러가 생성될 때
    public MenuController(){
        printResult = new PrintResult();
        menuService = new MenuService();
    }


    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selectAllMenu();

        if (menuList != null) {
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectMenuByCode(Map<String, String> map) {
        int code = Integer.parseInt(map.get("code"));

        MenuDTO menuDTO = menuService.selectMenuByCode(code);

        if (menuDTO != null) {
            printResult.printErrorMessage("code");
        } else {
            printResult.printSuccessMessage("code");
        }

    }

    public void registMenu(Map<String, String> parameter) {

        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);
        if (menuService.registMenu(menu)){
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void updateMenu(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        int price = Integer.parseInt(parameter.get("price"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setCode(code);
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategoryCode(categoryCode);

        if (menuService != null) {
            printResult.printErrorMessage("update");
        } else {
            printResult.printSuccessMessage("update");
        }
    }

}
