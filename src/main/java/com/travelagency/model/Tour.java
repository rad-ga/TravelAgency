package com.travelagency.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Tour extends Serialized {
    private String tourId;
    private double price;
    private TourType tourType;
    private double review;
    private TourInfoCard tourInfoCard;
    private final List<Guide> guides;
    private final List<Purchase> purchaseList;
    private final List<Reservation> reservationsList;

    public Tour(String tourId, double price, TourType tourType, double rating, TourInfoCard tourInfoCard) {
        this.tourId = tourId;
        this.price = price;
        this.tourType = tourType;
        this.review = rating;
        this.tourInfoCard = tourInfoCard;
        guides = new ArrayList<>();
        purchaseList = new ArrayList<>();
        reservationsList = new ArrayList<>();
    }

    public void addGuide(Guide guide) {
        if (!guides.contains(guide)) {
            guides.add(guide);
            guide.getTourList().add(this);
        }
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public double getReview() {
        return review;
    }

    public void setReview(double review) {
        this.review = review;
    }

    public List<Guide> getGuides() {
        return guides;
    }

    public TourInfoCard getTourInfoCard() {
        return tourInfoCard;
    }

    public void setTourInfoCard(TourInfoCard tourInfoCard) {
        this.tourInfoCard = tourInfoCard;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public List<Reservation> getReservationsList() {
        return reservationsList;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourId='" + tourId + '\'' +
                ", price=" + price +
                ", tourType=" + tourType +
                ", rating=" + review +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour tour)) return false;
        return Objects.equals(tourId, tour.tourId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourId);
    }
}
