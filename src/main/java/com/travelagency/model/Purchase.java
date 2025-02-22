package com.travelagency.model;

import java.time.LocalDate;

public class Purchase extends Serialized{

    private final Client client;
    private final CustomerServiceSpecialist customerServiceSpecialist;
    private final Tour tour;
    private double price;
    private final LocalDate date;

    public Purchase(RegisteredClient registeredClient, CustomerServiceSpecialist customerServiceSpecialist, Tour tour, double price, LocalDate date) {
        this.client = registeredClient;
        this.customerServiceSpecialist = customerServiceSpecialist;
        this.tour = tour;
        this.price = price;
        this.date = date;
        tour.getPurchaseList().add(this);
        registeredClient.getPurchaseList().add(this);
    }

    public Purchase(UnregisteredClient unregisteredClient, Tour tour, double price, LocalDate date) {
        this.client = unregisteredClient;
        customerServiceSpecialist = null;
        this.tour = tour;
        this.price = price;
        this.date = date;
        tour.getPurchaseList().add(this);
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
        return "Purchase{" +
                "client=" + client +
                ", customerServiceSpecialist=" + customerServiceSpecialist +
                ", tour=" + tour +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
