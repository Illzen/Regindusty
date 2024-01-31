package com.zen.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zen.commons.PageResult;
import com.zen.dao.DistrictsDao;
import com.zen.domain.District;
import com.zen.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImp implements DistrictService {

    @Autowired
    private DistrictsDao districtsDao;

    @Override
    public District findByAdCode(Integer adCode) {
        return districtsDao.selectByAdCode(adCode);
    }

    @Override
    public List<District> findAll() {
        return districtsDao.selectAll();
    }

    @Override
    public PageResult findByPage(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<District> list = districtsDao.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        PageResult pageResult = new PageResult(pageInfo.getPageNum(), pageInfo.getPageSize(), (int) pageInfo.getTotal(), list);
        return pageResult;
    }

}
