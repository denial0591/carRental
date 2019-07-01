package com.novikov.carrental.filter;

import com.novikov.carrental.entity.CarModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Фильтр для поиска договоров на аренду автомобилей
 */
@Getter
@Setter
public class CarRentalContractFilter {
    private CarModel model;
    private LocalDate startDate;
    private LocalDate endDate;
    private String customerFirstName;
    private String customerLastName;
    private String customerMiddleName;
    private String carNumber;
}
