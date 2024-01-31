package com.zen.controller;

import com.zen.commons.PageResult;
import com.zen.commons.ResponseResult;
import com.zen.domain.District;
import com.zen.service.DistrictService;
import com.zen.service.imp.DistrictServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @GetMapping("/districts")
    public ResponseResult findAll() {
        List<District> list = districtService.findAll();
        return new ResponseResult(200, "查询地区成功", list);
    }

    @GetMapping("/district/{adCode}")
    public ResponseResult findByAdCode(@PathVariable Integer adCode) {
        District district = districtService.findByAdCode(adCode);
        if (district == null) {
            return new ResponseResult(500, "没有该地区");
        } else {
            return new ResponseResult(200, "查询地区成功", district);
        }
    }

    @GetMapping("/district/{pageSize}/{pageNum}")
    public ResponseResult findByPage(@PathVariable("pageSize") Integer pageSize,
                                     @PathVariable("pageNum") Integer pageNum) {
        PageResult pageResult = districtService.findByPage(pageSize, pageNum);
        return new ResponseResult(200, "查询页成功", pageResult);
    }

}
