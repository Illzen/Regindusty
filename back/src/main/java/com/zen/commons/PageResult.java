package com.zen.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;


import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class PageResult<T> {

    private Integer currentPage;

    private Integer pageSize;

    private Integer total;

    private List<T> data;

    public PageResult(Integer currentPage, Integer pageSize, Integer total, List<T> data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
    }

}
