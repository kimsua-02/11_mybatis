package com.ohgiraffers.section03.remix.model;

import com.ohgiraffers.dto.MenuDTO;

import java.util.List;

public interface MenuMapper {
    List<MenuDTO> selectAllMenu();
}
