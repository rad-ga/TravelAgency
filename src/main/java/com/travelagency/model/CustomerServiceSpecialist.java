package com.travelagency.model;

import lombok.ToString;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString(callSuper = true)
public class CustomerServiceSpecialist extends Employee {

    private final Map<Integer,List<Employee>>ranking;


    public CustomerServiceSpecialist(String name, String surname, String email, String phone, int hoursWorked, EmploymentType employmentType) {
        super(name, surname, email, phone, hoursWorked, employmentType);
        this.ranking = new HashMap<>();
    }

    public Map<Integer, List<Employee>> getRanking() {
        return ranking;
    }

}
