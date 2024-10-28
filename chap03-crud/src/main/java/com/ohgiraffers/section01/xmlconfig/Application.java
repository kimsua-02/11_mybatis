package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.section01.xmlconfig.controller.MenuController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do {
            System.out.println("==== 메뉴 관리 ====");
            System.out.println("1. 메뉴 전체 조회");
            System.out.println("2. 메뉴 코드로 메뉴 조회");
            System.out.println("3. 메뉴 등록");
            System.out.println("4. 메뉴 수정 ");
            System.out.println("5. 메뉴 삭제");
            System.out.println("번호를 입력하세요. :  ");

            int no = scr.nextInt();

            switch (no) {
                case 1 : menuController.selectAllMenu(); break;
                case 2 : menuController.selectMenuByCode(inputMenuCode()); break;
                case 3 : menuController.registMenu(inputMenu()); break;
                case 4 : menuController.modifyMenu(inputModifyMenu()); break;
                case 5 : menuController.deleteMenu(inputMenuCode()); break;
                default:
                    System.out.println("잘못된 메뉴 선택 "); break;
            }
        } while (true);
    }

    private static Map<String,String> inputMenuCode(){
        Scanner scr = new Scanner(System.in);
        System.out.println("메뉴 코드를 입력해주세요. : ");
        String code = scr.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("code",code);
        return parameter;
    }

    private static Map<String,String> inputMenu(){
        Scanner scr = new Scanner(System.in);
        System.out.println("메뉴 이름을 입력해주세요. : ");
        String name = scr.nextLine();
        System.out.println("메뉴 가격을 입력해주세요 : ");
        String price = scr.nextLine();
        System.out.println("카테고리 코드를 입력해주세요. : ");
        String categoryCode = scr.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("name",name);
        parameter.put("price",price);
        parameter.put("categoryCode",categoryCode);
        return parameter;
    }

    private static Map<String,String> inputModifyMenu(){
        Scanner scr = new Scanner(System.in);
        System.out.println("수정할 메뉴 코드를 입력 해주세요 : ");
        String code = scr.nextLine();
        System.out.println("수정할 메뉴 이름을 입력 해주세요. : ");
        String name = scr.nextLine();
        System.out.println("수정할 메뉴 가격을 입력 해주세요. : ");
        String price = scr.nextLine();
        System.out.println("수정할 메뉴 카테고리 코드를 입력 해주세요. : ");
        String categoryCode = scr.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("code",code);
        parameter.put("name",name);
        parameter.put("price",price);
        parameter.put("categoryCode",categoryCode);

        return parameter;
    }

    private static Map<String,String> inputdeleteMenu(){
        Scanner scr = new Scanner(System.in);
        System.out.println("삭제할 메뉴 코드를 입력 해주세요. : ");
        String code = scr.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("code",code);

        return parameter;
    }

}
