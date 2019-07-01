package com.novikov.carrental.controller;

import com.novikov.carrental.projection.CarProjection;
import com.novikov.carrental.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CarController {
    private final CarService carService;
    private final ProjectionFactory projectionFactory;

    @GetMapping("/rest/cars")
    public List<CarProjection> findAll() {
        return carService.findAllByFilter().stream()
                .map(car -> projectionFactory.createProjection(CarProjection.class, car)).collect(Collectors.toList());
    }
}
