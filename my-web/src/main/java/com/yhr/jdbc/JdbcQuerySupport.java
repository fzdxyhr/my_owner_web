package com.yhr.jdbc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yhr
 * @version latest
 * @date 2017/1/25
 * @description
 */
public class JdbcQuerySupport {

    public static final int DEFAULT_PAGE_NO = 0;
    public static final int DEFAULT_PAGE_SIZE = 10;
    List<Criterion> criterions = new ArrayList();
    List<Order> orders = new ArrayList();
    Pager pager = new Pager(0, 10);
    List<String> selects = new ArrayList();
    Result result;
    
}
