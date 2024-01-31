package com.zen.dao;


import com.zen.domain.District;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DistrictsDao {

    @Select("SELECT * FROM districts WHERE adcode=#{adCode}")
    District selectByAdCode(Integer adCode);

    @Select("SELECT * FROM districts")
    List<District> selectAll();


}
