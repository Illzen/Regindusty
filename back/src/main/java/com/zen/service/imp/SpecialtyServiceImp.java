package com.zen.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zen.commons.PageResult;
import com.zen.dao.SpecialtyDao;
import com.zen.domain.District;
import com.zen.domain.Specialty;
import com.zen.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyServiceImp implements SpecialtyService {

    @Autowired
    private SpecialtyDao specialtyDao;

    @Override
    public Specialty findById(Integer id) {
        return specialtyDao.selectById(id);
    }

    @Override
    public List<Specialty> findAll() {
        return specialtyDao.selectAll();
    }

    @Override
    public Integer addSpecialty(Specialty specialty) {
        return specialtyDao.insertSpecialty(specialty);
    }

    @Override
    public Integer deleteById(Integer id) {
        return specialtyDao.deleteById(id);
    }

    @Override
    public List<Specialty> findByName(String name) {
        return specialtyDao.selectByName(name);
    }

    @Override
    public PageResult findByPage(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<Specialty> list = specialtyDao.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        PageResult pageResult = new PageResult(pageInfo.getPageNum(), pageInfo.getPageSize(), (int) pageInfo.getTotal(), list);
        return pageResult;
    }

    @Override
    public Integer updateSpecialtyById(Specialty specialty) {
        return specialtyDao.updateSpecialtyById(specialty);
    }

}