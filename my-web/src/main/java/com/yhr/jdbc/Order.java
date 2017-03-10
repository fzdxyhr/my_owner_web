package com.yhr.jdbc;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yhr
 * @version latest
 * @date 2017/1/25
 * @description
 */
@Data
public class Order implements Serializable {

    private boolean ascending;
    private String propertyName;

    public static Order asc(String propertyName) {
        return new Order(propertyName, true);
    }

    public static Order desc(String propertyName) {
        return new Order(propertyName, false);
    }

    protected Order(String propertyName, boolean ascending) {
        this.propertyName = propertyName;
        this.ascending = ascending;
    }

}
