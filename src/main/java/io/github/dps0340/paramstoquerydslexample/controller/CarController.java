package io.github.dps0340.paramstoquerydslexample.controller;

import com.querydsl.core.types.Predicate;
import io.github.dps0340.paramstoquerydslexample.entity.Car;
import io.github.dps0340.paramstoquerydslexample.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    List<Car> getCars(@QuerydslPredicate Predicate predicate) {
        return carService.getCarsByPredicate(predicate);
    }
}
