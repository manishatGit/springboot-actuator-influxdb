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
}
