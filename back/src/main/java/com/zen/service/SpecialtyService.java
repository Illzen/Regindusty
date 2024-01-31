package com.zen.service;

import com.zen.commons.PageResult;
import com.zen.domain.Specialty;

import java.util.List;

public interface SpecialtyService {
    Specialty findById(Integer id);

    List<Specialty> findAll();

    Integer addSpecialty(Specialty specialty);

    Integer deleteById(Integer id);

    List<Specialty> findByName(String name);

    PageResult findByPage(Integer pageSize, Integer pageNum);

    Integer updateSpecialtyById(Specialty specialty);
}
