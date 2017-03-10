package com.yhr.jdbc;

/**
 * @author yhr
 * @version latest
 * @date 2017/1/25
 * @description
 */
public enum Operator {

    EQ("="),
    NE("!="),
    LIKE("like"),
    LT("<"),
    GT(">"),
    LE("<="),
    GE(">=");

    private String value;

    private Operator(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
