package com.knoldus.ebfts.service;

import com.knoldus.ebfts.model.Employee;
import com.knoldus.ebfts.model.EmployeeRegistration;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRegistrationServiceTest {

    @Test
    public void givenEmployeeAsNullShouldReturnEmpty() {
        RegistrationService sut = new RegistrationService();
        Optional<EmployeeRegistration> actualResult = sut.register(null);
        Optional<EmployeeRegistration> expectedResult = Optional.empty();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void givenValidEmployeeShouldReturnRegistrationObject() {
        String testId = "Test";
        RegistrationService sut = new RegistrationService();
        Employee validEmployee = new Employee();
        EmployeeRegistration employeeRegistration = new EmployeeRegistration();
        employeeRegistration.setEmployeeId(testId);
        validEmployee.setId(testId);
        Optional<EmployeeRegistration> actualResult = sut.register(validEmployee);
        Optional<EmployeeRegistration> expectedResult = Optional.of(employeeRegistration);
        assertEquals(expectedResult.get().getEmployeeId(), testId);
    }

}