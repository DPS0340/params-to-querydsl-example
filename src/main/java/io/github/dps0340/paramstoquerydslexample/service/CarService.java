package io.github.dps0340.paramstoquerydslexample.service;

import com.querydsl.core.types.Predicate;
import io.github.dps0340.paramstoquerydslexample.entity.Car;
import io.github.dps0340.paramstoquerydslexample.repository.CarRepository;
import io.reactivex.rxjava3.core.Observable;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getCarsByPredicate(Predicate predicate) {
        val it = carRepository.findAll(predicate);
        return Observable.fromIterable(it).toList().blockingGet();
    }

}
