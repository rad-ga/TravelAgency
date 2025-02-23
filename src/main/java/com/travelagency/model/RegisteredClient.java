package com.travelagency.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegisteredClient extends Client {
    private final String clientId;
    private final List<Purchase> purchaseList;
    private final List<Reservation> reservationList;

    public RegisteredClient(String name, String surname, String email, String phone, String clientId) {
        super(name, surname, email, phone);
        this.clientId = clientId;
        this.purchaseList = new ArrayList<>();
        this.reservationList = new ArrayList<>();
    }

    public String getClientId() {
        return clientId;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    @Override
    public String toString() {
        return "RegisteredClient{" + getName() + " " + getSurname() + " " + getEmail() + " " + getPhone() +
                " clientId='" + clientId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisteredClient that)) return false;
        return Objects.equals(clientId, that.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }
}
