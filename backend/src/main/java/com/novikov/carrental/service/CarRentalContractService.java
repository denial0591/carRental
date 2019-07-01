package com.novikov.carrental.service;

import com.novikov.carrental.entity.CarRentalContract;
import com.novikov.carrental.filter.CarRentalContractFilter;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Сервис договоров на аренду автомобилей
 */
public interface CarRentalContractService {

    /**
     * Возвращяет все договоры на аренду автомобилей по заданному фильтру и сортировке
     *
     * @param filter фильтр
     * @param sort   сортировка
     * @return список договоров на аренду автомобилей
     */
    List<CarRentalContract> findAllByFilter(CarRentalContractFilter filter, Sort sort);

    /**
     * Возвращяет строку, показывающую среднюю продолжительность аренды по модели автомобиля
     *
     * @param modelId идентификатор модели автомобиля
     * @return строка, показывающая среднюю продолжительность
     */
    String getAvgInterval(int modelId);

    /**
     * Сохраняет договор на аренду автомобиля
     *
     * @param carRentalContract договор на аренду
     */
    CarRentalContract save(CarRentalContract carRentalContract);
}
