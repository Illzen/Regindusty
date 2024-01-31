package com.zen.dao;

import com.zen.domain.Specialty;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SpecialtyDao {
    @Select("SELECT * FROM specialty WHERE id=#{id}")
    Specialty selectById(Integer id);

    @Select("SELECT * FROM specialty")
    List<Specialty> selectAll();

    @Insert("INSERT INTO specialty VALUES(null,#{name},#{description})")
    Integer insertSpecialty(Specialty specialty);

    @Select("SELECT * FROM specialty WHERE name=#{name}")
    List<Specialty> selectByName(String name);

    @Delete("DELETE FROM specialty WHERE id=#{id}")
    Integer deleteById(Integer id);

    @Update("UPDATE specialty SET name=#{name},description=#{description}")
    Integer updateSpecialtyById(Specialty specialty);
}
