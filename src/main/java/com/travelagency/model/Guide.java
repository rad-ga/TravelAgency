package com.travelagency.model;

import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true, exclude = "tourList")
public class Guide extends Employee {
    private final List<String> languages;
    private final List<Tour> tourList;

    public Guide(String name, String surname, String email, String phone, int hoursWorked, EmploymentType employmentType, List<String> languages) {
        super(name, surname, email, phone, hoursWorked, employmentType);
        this.languages = languages;
        this.tourList = new ArrayList<>();
    }

    public Guide(String name, String surname, String email, String phone, int hoursWorked, EmploymentType employmentType) {
        this(name,surname,email,phone,hoursWorked,employmentType,new ArrayList<>());
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void addLanguage(String language) {
        if (!languages.contains(language)) {
            languages.add(language);
        }
    }

    public void addTour(Tour tour) {
        if(!tourList.contains(tour)){
            tourList.add(tour);
            tour.getGuides().add(this);
        }
    }

    public List<Tour> getTourList() {
        return tourList;
    }

}
