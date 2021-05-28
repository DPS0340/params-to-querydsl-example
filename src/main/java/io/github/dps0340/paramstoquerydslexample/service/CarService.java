package io.github.dps0340.paramstoquerydslexample.service;

import com.querydsl.core.types.Predicate;
import io.github.dps0340.paramstoquerydslexample.entity.Car;
import io.github.dps0340.paramstoquerydslexample.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getCarsByPredicate(Predicate predicate) {
        List<Car> cars = new ArrayList<>();

        carRepository.findAll(predicate).iterator().forEachRemaining(cars::add);

        return cars;
    }

}
