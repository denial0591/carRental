package com.novikov.carrental.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Марка автомобиля
 */
@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@Immutable
public class CarBrand extends AbstractSequenceIdEntity<Integer> {

    /**
     * Название марки
     */
    @Column(nullable = false)
    private String name;
}
