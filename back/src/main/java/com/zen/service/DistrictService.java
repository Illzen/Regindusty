package com.zen.service;

import com.zen.commons.PageResult;
import com.zen.domain.District;

import java.util.List;

public interface DistrictService {
    District findByAdCode(Integer adCode);

    List<District> findAll();

    PageResult findByPage(Integer pageSize, Integer pageNum);

}
