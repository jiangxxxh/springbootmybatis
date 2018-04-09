package com.springbootmybatis.mapper;

import com.springbootmybatis.domain.Car;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * 映射器接口
 */
public interface CarMapper {

    @Select("select id,name,price,create_date from car")
    @Results({
            @Result(property = "createDate",column = "create_date")
    })
    List<Car> find();

    List<Car> findByParam(@Param("name")String name,
                          @Param("beginDate")Date beginDate,
                          @Param("endDate")Date endDate);

    @Select("select id,name,price,create_date createDate from car where id=#{id}")
    Car findById(Integer id);

    @Insert("insert into car (name,price,create_date) values (#{name},#{price},#{createDate})")
    int add(Car car);

    @Update("update car set name=#{name},price=#{price},create_date=#{createDate} where id=#{id}")
    int modify(Car car);

    @Delete("delete from car where id=#{id}")
    int remove(Integer id);
}
