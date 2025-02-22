package com.travelagency.model;

import lombok.ToString;

@ToString(callSuper = true)
public class DomesticTour extends Tour {
    private final String city;

    public DomesticTour(String tourId, double price, TourType tourType, double review,TourInfoCard tourInfoCard, String city) {
        super(tourId, price, tourType, review,tourInfoCard);
        this.city = city;
    }

    public String getCity() {
        return city;
    }
    public String getCountry() {
        return "";
    }

}
