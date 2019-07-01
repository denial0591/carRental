package com.novikov.carrental.service.impl;

import com.novikov.carrental.entity.Car;
import com.novikov.carrental.repository.CarRepository;
import com.novikov.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public List<Car> findAllByFilter() {
        return carRepository.findAll();
    }
}
