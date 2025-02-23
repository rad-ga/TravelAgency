package com.travelagency.model;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString(callSuper = true, exclude = {"reservationList","purchaseList"})
public class CustomerServiceSpecialist extends Employee {

    private final Map<Integer, List<Employee>> ranking;
    private final List<Reservation> reservationList;
    private final List<Purchase> purchaseList;


    public CustomerServiceSpecialist(String name, String surname, String email, String phone, int hoursWorked, EmploymentType employmentType) {
        super(name, surname, email, phone, hoursWorked, employmentType);
        this.ranking = new HashMap<>();
        this.reservationList = new ArrayList<>();
        this.purchaseList = new ArrayList<>();
    }

    public Map<Integer, List<Employee>> getRanking() {
        return ranking;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }
}
