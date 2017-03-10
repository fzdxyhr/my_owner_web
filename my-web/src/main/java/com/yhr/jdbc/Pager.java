package com.yhr.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yhr
 * @version latest
 * @date 2017/1/25
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pager {

    private int pageNo;
    private int pageSize;
}
