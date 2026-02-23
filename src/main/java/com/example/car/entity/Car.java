package com.example.car.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
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

}
