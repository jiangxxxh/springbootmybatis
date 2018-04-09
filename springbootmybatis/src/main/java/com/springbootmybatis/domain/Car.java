package com.springbootmybatis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {
    private static final long serialVersionUID = -8544485790318776429L;

    private Integer id;
    private String name;
    private Double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 前端表单到后台
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8") // 后台到前端
    private Date createDate;

    public Car() {
    }

    public Car(Integer id, String name, Double price, Date createDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createDate=" + createDate +
                '}';
    }
}
