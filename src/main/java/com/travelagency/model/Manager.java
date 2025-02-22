package com.travelagency.model;

import lombok.ToString;

@ToString(callSuper = true)
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, String surname, String email, String phone, int hoursWorked, EmploymentType employmentType, double bonus) {
        super(name, surname, email, phone, hoursWorked, employmentType );
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

}
