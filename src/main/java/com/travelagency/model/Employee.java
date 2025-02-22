package com.travelagency.model;

import java.util.Objects;

public abstract class Employee extends Serialized {
    private static double MINIMAL_SALARY = 3000;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private double wage;
    private int hoursWorked;
    private EmploymentType employmentType;

    public Employee(String name, String surname, String email, String phone, int hoursWorked, EmploymentType employmentType) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.hoursWorked = hoursWorked;
        this.employmentType = employmentType;
    }

    public static double getMinimalSalary() {
        return MINIMAL_SALARY;
    }

    public static void setMinimalSalary(double minimalSalary) {
        MINIMAL_SALARY = minimalSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(EmploymentType employmentType) {
        this.employmentType = employmentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Double.compare(wage, employee.wage) == 0 && hoursWorked == employee.hoursWorked && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(email, employee.email) && Objects.equals(phone, employee.phone) && employmentType == employee.employmentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email, phone, wage, hoursWorked, employmentType);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", wage=" + wage +
                ", hoursWorked=" + hoursWorked +
                ", employmentType=" + employmentType +
                '}';
    }
}
