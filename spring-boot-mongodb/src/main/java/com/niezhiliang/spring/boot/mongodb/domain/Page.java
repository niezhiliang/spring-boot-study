package com.niezhiliang.spring.boot.mongodb.domain;

import lombok.Data;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/5/28 上午9:45
 */
@Data
public class Page {

    private Integer pageNo;

    private Integer pageSize;
}
