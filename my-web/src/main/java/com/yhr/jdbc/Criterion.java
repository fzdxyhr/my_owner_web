package com.yhr.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yhr
 * @version latest
 * @date 2017/1/25
 * @description
 */

@Data
@AllArgsConstructor
public class Criterion {

    private String propertyName;
    private Object value;
    private Operator operator;
}
