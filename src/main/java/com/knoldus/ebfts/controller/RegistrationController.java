package com.knoldus.ebfts.controller;

import com.knoldus.ebfts.model.Employee;
import com.knoldus.ebfts.model.EmployeeRegistration;
import com.knoldus.ebfts.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

import java.util.Optional;

@RestController
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @PostMapping("/register")
    public Optional<EmployeeRegistration> register(@RequestBody Employee requestBody) {
        increaseCount(requestBody.getId(), "register");
      return registrationService.register(requestBody);
    }

    private void increaseCount(String partnerId, String requestType) {
        // Counter class stores the measurement name and the tags and
        // their values
        Counter counter =Metrics.counter("request.register",  "Id",
                partnerId, "requestType", requestType);
        counter.increment();
    }
}
