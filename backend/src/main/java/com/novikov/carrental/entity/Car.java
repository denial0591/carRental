package com.novikov.carrental.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Set;

/**
 * Автомобиль
 */
@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@Immutable
public class Car extends AbstractSequenceIdEntity<Integer> {

    /**
     * Номер автомобиля
     */
    @Column(nullable = false)
    private String number;

    /**
     * Модель автомобиля
     */
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CarModel model;

    /**
     * Список договоров на прокат автомобиля
     */
    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<CarRentalContract> carRentalContracts;
}