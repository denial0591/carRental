package com.novikov.carrental.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Договор на аренду машины
 */
@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@Immutable
public class CarRentalContract extends AbstractSequenceIdEntity<Integer> {

    /**
     * Клиент
     */
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    /**
     * Автомобиль
     */
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

    /**
     * Дата взятия автомобиля в прокат
     */
    @Column(nullable = false)
    private LocalDateTime startDate;

    /**
     * Дата возврата автомобиля
     */
    @Column(nullable = false)
    private LocalDateTime endDate;
}
