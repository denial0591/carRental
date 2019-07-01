package com.novikov.carrental.projection;

public interface CarProjection {

    Integer getId();

    String getNumber();

    CarModelProjection getModel();

    interface CarModelProjection {
        Integer getId();

        CarBrandProjection getBrand();

        interface CarBrandProjection {
            Integer getId();

            String getName();
        }
    }
}
