package com.ohgiraffers.common;

/*
* 검색 엔진 클래스 - 검색 기준과 내용을 담을 객체
* */

public class SearchCriteria {
    private String condition;
    private String value;

    public SearchCriteria() {
    }

    public SearchCriteria(String condition, String value) {
        this.condition = condition;
        this.value = value;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "condition='" + condition + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
