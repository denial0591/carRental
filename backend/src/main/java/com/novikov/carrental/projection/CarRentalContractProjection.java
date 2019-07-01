package com.novikov.carrental.projection;

import java.time.LocalDateTime;

public interface CarRentalContractProjection {

    Integer getId();

    CustomerProjection getCustomer();

    CarProjection getCar();

    LocalDateTime getStartDate();

    LocalDateTime getEndDate();

    interface CustomerProjection {

        Integer getId();

        String getFirstName();

        String getLastName();

        String getMiddleName();
    }
}
