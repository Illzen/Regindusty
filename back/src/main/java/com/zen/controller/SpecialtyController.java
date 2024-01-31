package com.zen.controller;

import com.zen.commons.PageResult;
import com.zen.commons.ResponseResult;
import com.zen.domain.Specialty;
import com.zen.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("/specialty/{id}")
    public ResponseResult findById(@PathVariable Integer id) {
        Specialty specialty = specialtyService.findById(id);

        if (specialty == null) {
            return new ResponseResult(500, "没有该产品");
        } else {
            return new ResponseResult(200, "查询成功", specialty);
        }
    }

    @GetMapping("/specialty/{name}")
    public ResponseResult findByName(@PathVariable String name){
        List<Specialty> list = specialtyService.findByName(name);
        if (list == null) {
            return new ResponseResult(500,"没有该产品");
        } else {
            return new ResponseResult(200,"查询成功",list);
        }
    }

    @GetMapping("/specialties")
    public ResponseResult findAll() {
        List<Specialty> list = specialtyService.findAll();
        return new ResponseResult(200, "查询成功", list);
    }

    @PostMapping("/specialty/add")
    public ResponseResult addSpecialty(@RequestBody Specialty specialty){
        Integer num = specialtyService.addSpecialty(specialty);
        return new ResponseResult(200,"添加产品成功",num);
    }

    @PutMapping("specialty/update/id")
    public ResponseResult updateSpecialtyById(@RequestBody Specialty specialty){
        Integer num = specialtyService.updateSpecialtyById(specialty);
        return new ResponseResult(200,"更新产品成功",num);
    }

    @DeleteMapping("/specialty/delete/{id}")
    public ResponseResult deleteById(@PathVariable Integer id){
        Integer num = specialtyService.deleteById(id);
        if (num == 0){
            return new ResponseResult(500,"删除失败");
        } else {
            return new ResponseResult(200, "删除成功",num);
        }
    }

    @GetMapping("/specialty/{pageSize}/{pageNum}")
    public ResponseResult findByPage(@PathVariable("pageSize") Integer pageSize,
                                     @PathVariable("pageNum") Integer pageNum) {
        PageResult pageResult = specialtyService.findByPage(pageSize, pageNum);
        return new ResponseResult(200, "查询页成功", pageResult);
    }
}
