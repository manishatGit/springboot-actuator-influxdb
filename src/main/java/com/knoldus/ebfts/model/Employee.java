package com.knoldus.ebfts.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    @JsonProperty("id")
    private String id;

    @JsonProperty("joiningDate")
    private String joiningDate;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer workedYears() {
        String[] dateParts = joiningDate.split("-");
        int joiningYear = Integer.parseInt(dateParts[0]);
        int currentYear = java.time.LocalDate.now().getYear();
        return currentYear - joiningYear;
    }

    /**
     * Calculates the gratuity based on the number of worked years.
     * Gratuity is calculated as 1000 units for each year worked.
     *
     * @return the calculated gratuity amount
     */
    public Integer calculateGratuity() {
        return workedYears() * 1000;
    }

    /**
     * Calculates the salary based on the number of worked years.
     * Gratuity is calculated as 1000 units for each year worked
     * Salary is calculated as 15000 units for each year worked.
     *
     * @return the calculated salary amount
     */
    public Integer calculateSalary() {
        return workedYears() * 15000;
    }
}
