package com.ohgiraffers.section01;

import static com.ohgiraffers.section01.Template.getSqlSession;

public class Application {

    public static void main(String[] args) {

        // 싱글톤 확인
        System.out.println("session 1번 : " + getSqlSession().hashCode());
        System.out.println("session 2번 : " + getSqlSession().hashCode());
    }
}
