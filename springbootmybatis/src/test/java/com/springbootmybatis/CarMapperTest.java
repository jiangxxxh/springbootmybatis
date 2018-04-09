package com.springbootmybatis;

import com.springbootmybatis.domain.Car;
import com.springbootmybatis.mapper.CarMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarMapperTest {

    @Autowired
    private CarMapper carMapper;

    @Test
    public void find() {
        for(Car car:carMapper.find()){
            System.out.println(car);
        }
    }

    @Test
    public void findById() {
        Car car = carMapper.findById(4);
        System.out.println(car);
    }

    @Test
    public void findByParam() {
        String name = "大";
        Date begin = null;
        Date end = null;
        List<Car> cars = carMapper.findByParam(name,begin,end);
        for (Car c:cars){
            System.out.println(c);
        }
    }
}
