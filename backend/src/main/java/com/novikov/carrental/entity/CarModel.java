package com.novikov.carrental.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

/**
 * Модель автомобиля
 */
@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@Immutable
public class CarModel extends AbstractSequenceIdEntity<Integer> {

    /**
     * Название модели
     */
    @Column(nullable = false)
    private String name;

    /**
     * Марка автомобиля
     */
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CarBrand brand;
}
