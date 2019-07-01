package com.novikov.carrental.repository;

import com.novikov.carrental.entity.CarRentalContract;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRentalContractRepository extends JpaRepository<CarRentalContract, Integer>, JpaSpecificationExecutor<CarRentalContract> {

    /**
     * Возвращяет список договоров на аренду авто согласно заданному {@link Specification} и сортировке
     */
    @Override
    @EntityGraph(attributePaths = {"customer", "car", "car.model", "car.model.brand"})
    List<CarRentalContract> findAll(Specification<CarRentalContract> spec, Sort sort);

    /**
     * Возвращяет строку, показывающую среднюю продолжительность аренды по модели автомобиля
     *
     * @param modelId идентификатор модели автомобиля
     * @return строка, показывающая среднюю продолжительность
     */
    @Query(value = "select to_char(avg(end_date - start_date), 'DD\"day\" HH12\"h\" MI\"m\" SS\"s\"') as avg_interval from car_rental_contract c " +
            "join car on c.car_id = car.id " +
            "where car.model_id = ?1",
            nativeQuery = true)
    String getAvgInterval(int modelId);
}
