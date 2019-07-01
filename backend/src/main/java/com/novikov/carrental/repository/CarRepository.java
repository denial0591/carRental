package com.novikov.carrental.repository;

import com.novikov.carrental.entity.Car;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Override
    @EntityGraph(attributePaths = {"model", "model.brand"})
    List<Car> findAll();
}
