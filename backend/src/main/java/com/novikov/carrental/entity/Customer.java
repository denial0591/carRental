package com.novikov.carrental.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Set;

/**
 * Клиент
 */
@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@Immutable
public class Customer extends AbstractSequenceIdEntity<Integer> {

    /**
     * Имя
     */
    @Column(nullable = false)
    private String firstName;

    /**
     * Фамилия
     */
    @Column(nullable = false)
    private String lastName;

    /**
     * Отчество
     */
    @Column(nullable = false)
    private String middleName;

    /**
     * Список договоров на прокат автомобилей
     */
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<CarRentalContract> carRentalContracts;
}
