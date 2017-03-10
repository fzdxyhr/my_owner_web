package com.yhr.jdbc;

import lombok.NoArgsConstructor;

/**
 * @author yhr
 * @version latest
 * @date 2017/1/25
 * @description
 */

@NoArgsConstructor
public class Restrictions {

    public static Criterion eq(String propertyName, Object value) {
        return new Criterion(propertyName, value, Operator.EQ);
    }

    public static Criterion ne(String propertyName, Object value) {
        return new Criterion(propertyName, value, Operator.NE);
    }

    public static Criterion like(String propertyName, Object value) {
        return new Criterion(propertyName, value, Operator.LIKE);
    }

    public static Criterion gt(String propertyName, Object value) {
        return new Criterion(propertyName, value, Operator.GT);
    }

    public static Criterion lt(String propertyName, Object value) {
        return new Criterion(propertyName, value, Operator.LT);
    }

    public static Criterion le(String propertyName, Object value) {
        return new Criterion(propertyName, value, Operator.LE);
    }

    public static Criterion ge(String propertyName, Object value) {
        return new Criterion(propertyName, value, Operator.GE);
    }
}
