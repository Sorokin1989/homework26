package com.example.car.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "cars")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Поле обязательно для заполнения!")
    private String brand;
    @NotBlank(message = "Поле обязательно для заполнения!")
    private String model;
    @Min(value = 1900, message = "Год не может быть меньше 1900")
    @Max(value = 2026, message = "Год не может быть больше 2026")
    private Integer year;
    @NotBlank(message = "Поле обязательно для заполнения!")
    private String color;

    public Car() {
    }

    public Long getId() {
        return id;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
