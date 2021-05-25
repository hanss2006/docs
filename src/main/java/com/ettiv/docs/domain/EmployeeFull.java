package com.ettiv.docs.domain;

import org.springframework.data.rest.core.config.Projection;

@Projection(
        name = "EmployeeFull",
        types = { Employee.class })
public interface EmployeeFull {
    Long getId();

    String getFio();
    String getAddress();
    String getPhone();

    Post getPost();
    Unit getUnit();
}
