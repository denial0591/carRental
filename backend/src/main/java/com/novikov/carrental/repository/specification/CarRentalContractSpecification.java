package com.novikov.carrental.repository.specification;

import com.novikov.carrental.entity.Car;
import com.novikov.carrental.entity.CarRentalContract;
import com.novikov.carrental.entity.Customer;
import com.novikov.carrental.filter.CarRentalContractFilter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * {@link Specification} для формирования условий запроса по фильтру {@link CarRentalContractFilter}
 */
@RequiredArgsConstructor
public class CarRentalContractSpecification implements Specification<CarRentalContract> {
    private final CarRentalContractFilter filter;

    private List<Predicate> predicates = new ArrayList<>();
    private Join<CarRentalContract, Customer> customerJoin;
    private Join<CarRentalContract, Car> carJoin;

    @Override
    public Predicate toPredicate(Root<CarRentalContract> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (filter != null) {
            if (filter.getModel() != null && filter.getModel().getId() != null) {
                predicates.add(cb.equal(joinCar(root).join("model").get("id"), filter.getModel().getId()));
            }
            if (filter.getStartDate() != null) {
                predicates.add(cb.equal(cb.function("date", LocalDate.class, root.get("startDate")), filter.getStartDate()));
            }
            if (filter.getEndDate() != null) {
                predicates.add(cb.equal(cb.function("date", LocalDate.class, root.get("endDate")), filter.getEndDate()));
            }
            if (!isEmpty(filter.getCustomerFirstName())) {
                predicates.add(cb.like(joinCustomer(root).get("firstName"), "%" + filter.getCustomerFirstName() + "%"));
            }
            if (!isEmpty(filter.getCustomerLastName())) {
                predicates.add(cb.like(joinCustomer(root).get("lastName"), "%" + filter.getCustomerLastName() + "%"));
            }
            if (!isEmpty(filter.getCustomerMiddleName())) {
                predicates.add(cb.like(joinCustomer(root).get("middleName"), "%" + filter.getCustomerMiddleName() + "%"));
            }
            if (!isEmpty(filter.getCarNumber())) {
                predicates.add(cb.like(joinCar(root).get("number"), "%" + filter.getCarNumber() + "%"));
            }
            if (!predicates.isEmpty()) {
                return cb.or(predicates.toArray(new Predicate[0]));
            }
        }
        return null;
    }

    private Join<CarRentalContract, Customer> joinCustomer(Root<CarRentalContract> root) {
        if (customerJoin == null) {
            customerJoin = root.join("customer");
        }
        return customerJoin;
    }

    private Join<CarRentalContract, Car> joinCar(Root<CarRentalContract> root) {
        if (carJoin == null) {
            carJoin = root.join("car");
        }
        return carJoin;
    }
}
