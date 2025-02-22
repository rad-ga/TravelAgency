package com.travelagency.model;

import lombok.ToString;

@ToString(callSuper = true)
public class AbroadTour extends Tour {
    private final String country;
    private String transport;

    public AbroadTour(String tourId, double price, TourType tourType, double review, TourInfoCard tourInfoCard,String country, String transport) {
        super(tourId, price, tourType, review,tourInfoCard);
        this.country = country;
        this.transport = transport;
    }

    public String getCountry() {
        return country;
    }

    public String getTransport() {
        return transport;
    }

    public String getCity(){
        return "";
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

}
