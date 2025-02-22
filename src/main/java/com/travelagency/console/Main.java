package com.travelagency.console;

import com.travelagency.model.*;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        TravelAgencyService tas = new TravelAgencyService();

        //Wycieczki
        TourInfoCard abroadInfo1 = new TourInfoCard("Odkryj uroki Włoch", "Brak ograniczeń", "Nie wymagany paszport");
        AbroadTour abroadTour1 = new AbroadTour("AT001", 2000.0, TourType.LEISURE, 4.8, abroadInfo1, "Włochy", "Samolot");

        TourInfoCard abroadInfo2 = new TourInfoCard("Aktywna Hiszpania", "Dobra kondycja, minimum 15 lat", "Nie wymagany paszport");
        AbroadTour abroadTour2 = new AbroadTour("AT002", 3000.0, TourType.ACTIVITY, 4.4, abroadInfo2, "Hiszpania", "Samolot");

        TourInfoCard domesticInfo = new TourInfoCard("Zwiedzanie Warszawy", "Brak ograniczeń", "Koniecznie zabierz dowód osobisty");
        DomesticTour domesticTour1 = new DomesticTour("DT001", 500.0, TourType.SIGHTSEEING, 4.2, domesticInfo, "Warszawa");

        TourInfoCard abroadInfo3 = new TourInfoCard("Wakacje w Grecji", "Brak ograniczeń", "Ważny dokument tożsamości");
        AbroadTour abroadTour3 = new AbroadTour("AT003", 2500.0, TourType.SIGHTSEEING, 4.7, abroadInfo3, "Grecja", "Samolot");

        TourInfoCard domesticInfo2 = new TourInfoCard("Wycieczka w Tatry", "Dobra kondycja fizyczna", "Zabierz kurtkę i buty górskie");
        DomesticTour domesticTour2 = new DomesticTour("DT002", 800.0, TourType.ACTIVITY, 4.6, domesticInfo2, "Zakopane");

        tas.getTours().add(abroadTour1);
        tas.getTours().add(abroadTour2);
        tas.getTours().add(domesticTour1);
        tas.addTour(abroadTour3);
        tas.addTour(domesticTour2);


        // Klienci
        RegisteredClient registeredClient1 = new RegisteredClient("Anna", "Kowalska", "anna@example.com", "123-456-789", "RC001");
        RegisteredClient registeredClient2 = new RegisteredClient("Piotr", "Nowak", "pn@example.com", "325-456-789", "RC002");
        RegisteredClient registeredClient3 = new RegisteredClient("Ewa", "Zielińska", "ewa.z@example.com", "111-222-333", "RC003");
        RegisteredClient registeredClient4 = new RegisteredClient("Jan", "Pawlak", "jan.p@example.com", "111-222-444", "RC004");
        RegisteredClient registeredClient5 = new RegisteredClient("Maria", "Lewandowska", "m.lew@example.com", "111-222-555", "RC005");
        RegisteredClient registeredClient6 = new RegisteredClient("Adam", "Kozłowski", "a.koz@example.com", "111-222-666", "RC006");

        UnregisteredClient unregisteredClient1 = new UnregisteredClient("Tomasz", "Wisniewski", "t.wis@example.com", "987-654-321");
        UnregisteredClient unregisteredClient2 = new UnregisteredClient("Kamil", "Kowalczyk", "k.kow@example.com", "888-777-666");
        UnregisteredClient unregisteredClient3 = new UnregisteredClient("Daria", "Grabowska", "daria.g@example.com", "777-666-555");

        tas.addRegisteredClient(registeredClient1);
        tas.addRegisteredClient(registeredClient2);
        tas.addRegisteredClient(registeredClient3);
        tas.addRegisteredClient(registeredClient4);
        tas.addRegisteredClient(registeredClient5);
        tas.addRegisteredClient(registeredClient6);

        //Pracownicy
        CustomerServiceSpecialist css1 = new CustomerServiceSpecialist("Marek", "Wiśniewski", "marek@example.com", "555-555-555", 160, EmploymentType.FULL_TIME_B2B);
        Guide guide1 = new Guide("Karolina", "Maj", "k.maj@example.com", "999-888-777", 120, EmploymentType.FULL_TIME_CONTRACT);
        Manager manager1 = new Manager("Robert", "Krawczyk", "r.kra@example.com", "111-000-111", 160, EmploymentType.FULL_TIME_OTHER, 2000.0);
        CustomerServiceSpecialist css2 = new CustomerServiceSpecialist("Paweł", "Zieliński", "pawel@example.com", "222-333-444", 160, EmploymentType.FULL_TIME_B2B);

        tas.addEmployee(guide1);
        tas.addEmployee(manager1);
        tas.getEmployees().add(css1);
        tas.addEmployee(css2);

        //Zakupy
        tas.buyTourRegisteredClient(registeredClient1, css1, abroadTour1, 5000);
        tas.buyTourRegisteredClient(registeredClient2, css1, abroadTour2, 3000);
        tas.buyTourRegisteredClient(registeredClient1, css1, domesticTour1, 1500);
        tas.buyTourUnregisteredClient(unregisteredClient1, abroadTour1, 3000);
        tas.buyTourRegisteredClient(registeredClient3, css2, abroadTour3, 2800);
        tas.buyTourRegisteredClient(registeredClient4, css1, domesticTour2, 1000);
        tas.buyTourUnregisteredClient(unregisteredClient2, abroadTour2, 3500);
        tas.buyTourRegisteredClient(registeredClient5, css2, domesticTour1, 600);

        tas.makeReservationRegisteredClient(registeredClient6, css2, abroadTour3, 2700);
        tas.makeReservationUnregisteredClient(unregisteredClient3, domesticTour2, 700);


        System.out.println("Lista wszystkich zarejestrowanych klientów:");
        tas.getRegisteredClients().forEach(System.out::println);

        System.out.println("\nWycieczki zakupione przez RegisteredClient1 (Anna):");
        List<Tour> client1Tours = tas.searchForClientTours(registeredClient1);
        client1Tours.forEach(System.out::println);

        System.out.println("\nWycieczki zakupione przez UnregisteredClient (Tomasz):");
        List<Tour> unregisteredClientTours = tas.searchForClientTours(unregisteredClient1);
        unregisteredClientTours.forEach(System.out::println);

        System.out.println("\nWszyscy klienci (zarejestrowani + niezarejestrowani z zakupów):");
        List<Client> allClients = tas.getAllClients();
        allClients.forEach(System.out::println);

        System.out.println("\nKlient z najwyższymi wydatkami:");
        Client topClient = tas.getTopSpendingClient();
        System.out.println(topClient);

        //ObjectOutputStream ooo = new ObjectOutputStream();

        // Zapis do pliku
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            tas.saveSystemData(oos);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Odczyt z pliku (start nowej instancji serwisu z pliku)
        TravelAgencyService tas2 = new TravelAgencyService();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"))) {
            tas2.loadSystemData(ois);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- Porównanie przed i po imporcie ---");
        System.out.println("Zarejestrowani klienci w tas:");
        tas.getRegisteredClients().forEach(System.out::println);

        System.out.println("\nZarejestrowani klienci w tas2 (zaimportowani z pliku):");
        tas2.getRegisteredClients().forEach(System.out::println);

        System.out.println("\nPracownicy w tas:");
        tas.getEmployees().forEach(System.out::println);

        System.out.println("\nPracownicy w tas2 (zaimportowani z pliku):");
        tas2.getEmployees().forEach(System.out::println);
    }
}
