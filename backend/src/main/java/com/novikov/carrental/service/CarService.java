package com.novikov.carrental.service;

import com.novikov.carrental.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> findAllByFilter();
}
