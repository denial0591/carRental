package com.novikov.carrental.service.impl;

import com.novikov.carrental.entity.CarRentalContract;
import com.novikov.carrental.filter.CarRentalContractFilter;
import com.novikov.carrental.repository.CarRentalContractRepository;
import com.novikov.carrental.repository.specification.CarRentalContractSpecification;
import com.novikov.carrental.service.CarRentalContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarRentalContractServiceImpl implements CarRentalContractService {

    private final CarRentalContractRepository carRentalContractRepository;

    @Override
    public List<CarRentalContract> findAllByFilter(CarRentalContractFilter filter, Sort sort) {
        return carRentalContractRepository.findAll(new CarRentalContractSpecification(filter), sort);
    }

    @Override
    public String getAvgInterval(int modelId) {
        return carRentalContractRepository.getAvgInterval(modelId);
    }

    @Override
    @Transactional
    public CarRentalContract save(CarRentalContract carRentalContract) {
        return carRentalContractRepository.save(carRentalContract);
    }
}
