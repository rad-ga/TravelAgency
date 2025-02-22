package com.travelagency.model;

public class TourInfoCard extends Serialized {
    private String description;
    private String restrictions;
    private String additionalInfo;

    public TourInfoCard(String description, String restrictions, String additionalInfo) {
        this.description = description;
        this.restrictions = restrictions;
        this.additionalInfo = additionalInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "TourInfoCard{" +
                "description='" + description + '\'' +
                ", restrictions='" + restrictions + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}
