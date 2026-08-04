package com.knoldus.ebfts.service;

import com.knoldus.ebfts.model.Employee;
import com.knoldus.ebfts.model.EmployeeRegistration;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.Optional;

@Service
public class RegistrationService {
    public Optional<EmployeeRegistration> register(Employee employee) {
        if (employee != null) {
            EmployeeRegistration employeeRegistration = new EmployeeRegistration();
            employeeRegistration.setId(java.util.UUID.randomUUID());
            employeeRegistration.setCreatedOn(Date.from(Instant.now()));
            employeeRegistration.setEmployeeId(employee.getId());
            return Optional.of(employeeRegistration);
        } else {
            return Optional.empty();
        }
    }
}
