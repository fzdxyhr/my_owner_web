package com.yhr.jdbc;

/**
 * @author yhr
 * @version latest
 * @date 2017/1/25
 * @description
 */
public enum Result {

    LIST("list"),
    PAGER("pager"),
    COUNT("count");

    private String value;

    private Result(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
