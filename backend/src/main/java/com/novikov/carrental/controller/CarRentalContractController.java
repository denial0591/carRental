package com.novikov.carrental.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.novikov.carrental.entity.CarModel;
import com.novikov.carrental.entity.CarRentalContract;
import com.novikov.carrental.filter.CarRentalContractFilter;
import com.novikov.carrental.projection.CarRentalContractProjection;
import com.novikov.carrental.service.CarRentalContractService;
import com.novikov.carrental.spring.RequestParamEditor;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.domain.Sort.Direction.ASC;

@RestController
@AllArgsConstructor
public class CarRentalContractController {
    private final ObjectMapper objectMapper;
    private final CarRentalContractService carRentalContractService;
    private final ProjectionFactory projectionFactory;

    @InitBinder
    public void init(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(CarRentalContractFilter.class, new RequestParamEditor(CarRentalContractFilter.class, objectMapper));
        binder.registerCustomEditor(CarModel.class, new RequestParamEditor(CarModel.class, objectMapper));
    }

    /**
     * Возвращяет все договоры на аренду по фильтру
     */
    @GetMapping("/rest/carRentalContracts")
    public List<CarRentalContractProjection> findAll(@RequestParam(required = false) CarRentalContractFilter filter) {
        return carRentalContractService.findAllByFilter(filter, Sort.by(ASC, "startDate"))
                .stream().map(carRentalContract ->
                        projectionFactory.createProjection(CarRentalContractProjection.class, carRentalContract)
                ).collect(Collectors.toList());
    }

    /**
     * Возвращяет среднюю продолжительность аренды по модели автомобиля
     */
    @GetMapping("/rest/carRentalContract/avgInterval")
    public String getAvgInterval(@RequestParam int modelId) {
        return carRentalContractService.getAvgInterval(modelId);
    }

    /**
     * Сохраняет договор на аренду автомобиля
     */
    @PostMapping("/rest/carRentalContract/save")
    public CarRentalContractProjection save(@RequestBody CarRentalContract carRentalContract) {
        return projectionFactory.createProjection(CarRentalContractProjection.class,
                carRentalContractService.save(carRentalContract)
        );
    }
}
