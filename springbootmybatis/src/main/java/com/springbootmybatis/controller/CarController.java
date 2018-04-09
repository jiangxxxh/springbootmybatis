package com.springbootmybatis.controller;

import com.springbootmybatis.domain.Car;
import com.springbootmybatis.domain.CustomType;
import com.springbootmybatis.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/cars",method = RequestMethod.GET)
    public ResponseEntity<?> getCars(){
        List<Car> cars = carService.find();
        if(cars.isEmpty()){
            return new ResponseEntity<>(new CustomType(400,"没有匹配的结果"),HttpStatus.OK);
        }
        return new ResponseEntity<>(cars,HttpStatus.OK);
    }

    @RequestMapping(value = "/cars/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getCar(@PathVariable("id")Integer id){
        Car car = carService.find(id);
        if(car == null){
            return new ResponseEntity<>(new CustomType(400,"没有匹配的结果"),HttpStatus.OK);
        }
        return new ResponseEntity<>(car,HttpStatus.OK);
    }

    @RequestMapping(value = "/cars",method = RequestMethod.POST)
    public ResponseEntity<?> addCar(@RequestBody Car car){
        int count = 0;
        System.out.println("car:"+car);
        count = carService.add(car);
        CustomType customType = new CustomType(400,"增加失败");
        if(count>0){
            customType.setCode(200);
            customType.setMessage("增加成功");
            return new ResponseEntity<>(customType,HttpStatus.OK);
        }
        return new ResponseEntity<>(customType,HttpStatus.OK);
    }

    @RequestMapping(value = "/cars",method = RequestMethod.PUT)
    public ResponseEntity<?> updateCar(@RequestBody Car car){
        int count = 0;
        System.out.println("car:"+car);
        count = carService.modify(car);
        CustomType customType = new CustomType(400,"修改失败");
        if(count>0){
            customType.setCode(200);
            customType.setMessage("修改成功");
            return new ResponseEntity<>(customType,HttpStatus.OK);
        }
        return new ResponseEntity<>(customType,HttpStatus.OK);
    }

    @RequestMapping(value = "/cars/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> removeCar(@PathVariable("id")Integer id){
        int count = 0;
        count = carService.remove(id);
        CustomType customType = new CustomType(400,"删除失败");
        if(count>0){
            customType.setCode(200);
            customType.setMessage("删除成功");
            return new ResponseEntity<>(customType,HttpStatus.OK);
        }
        return new ResponseEntity<>(customType,HttpStatus.OK);
    }

}
