package io.github.dps0340.paramstoquerydslexample.repository;

import io.github.dps0340.paramstoquerydslexample.entity.Car;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long>, QuerydslPredicateExecutor<Car> {
}
