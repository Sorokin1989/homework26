package com.example.car.controller;

import com.example.car.entity.Car;
import com.example.car.repository.CarRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    Faker faker;

    @Autowired
    CarRepository carRepository;

    @GetMapping("/hi")
    public String test(Model model, String sortBy) {
        model.addAttribute("cars", carRepository.findAll());
        return "pages/car/index";
    }

    @PostMapping("/create")
    public String create(Model model, Car car) {
        carRepository.save(car);
        return "redirect:/car/hi";
    }

    @GetMapping("/addAll")
    public String addAll(RedirectAttributes redirectAttributes) {
        boolean isAdd = false;
        if (carRepository != null && carRepository.count() == 0) {
            add_10_cars();
            isAdd = true;
        }
//        model.addAttribute("status",isAdd);
        redirectAttributes.addFlashAttribute("status", isAdd);
        return "redirect:/car/hi";
    }

    @GetMapping("/deleteAll")
    public String delete(Model model) {
        carRepository.deleteAll();
        return "pages/car/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("title", "Create page");
        model.addAttribute("car", new Car());
        return "pages/car/create";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id, Model model) {
        carRepository.deleteById(id);
        return "redirect:/car/hi";

    }

    @GetMapping("/edit/{id}")
    public String updateById(@PathVariable Long id, Model model) {
        Optional<Car> findCar = carRepository.findById(id);
        model.addAttribute("title", "Update Page");
        model.addAttribute("car", findCar.get());
        return "pages/car/edit";
    }


    public void add_10_cars() {

        for (int i = 0; i < 10; i++) {
            Car car = new Car();

            String brand = faker.vehicle().make();
            String model = faker.vehicle().model();
            Integer year = faker.number().numberBetween(2000, 2025);
            String color = faker.color().name();

            car.setBrand(brand);
            car.setModel(model);
            car.setYear(year);
            car.setColor(color);

            carRepository.save(car);
        }


    }


}
