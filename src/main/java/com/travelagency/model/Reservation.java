package com.travelagency.model;

import java.time.LocalDate;

public class Reservation extends Serialized {
    private final Client client;
    private final CustomerServiceSpecialist customerServiceSpecialist;
    private final Tour tour;
    private final double price;
    private final LocalDate date;

    public Reservation(RegisteredClient registeredClient, CustomerServiceSpecialist customerServiceSpecialist, Tour tour, double price, LocalDate date) {
        this.client = registeredClient;
        this.customerServiceSpecialist = customerServiceSpecialist;
        this.tour = tour;
        this.price = price;
        this.date = date;
        tour.getReservationsList().add(this);
        registeredClient.getReservationList().add(this);
        customerServiceSpecialist.getReservationList().add(this);
    }

    public Reservation(UnregisteredClient unregisteredClient, Tour tour, double price, LocalDate date) {
        this.client = unregisteredClient;
        customerServiceSpecialist = null;
        this.tour = tour;
        this.price = price;
        this.date = date;
        tour.getReservationsList().add(this);
    }

    public Client getClient() {
        return client;
    }

    public CustomerServiceSpecialist getCustomerServiceSpecialist() {
        return customerServiceSpecialist;
    }

    public Tour getTour() {
        return tour;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "client=" + client +
                ", customerServiceSpecialist=" + customerServiceSpecialist +
                ", tour=" + tour +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}

