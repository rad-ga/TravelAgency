package com.travelagency.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TravelAgencyService {

    public TravelAgencyService() {

    }

    public static <T extends Serialized> List<T> getAll(Class<T> clazz){
        return Serialized.database.values().stream()
                .flatMap(List::stream)
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    public List<RegisteredClient> getRegisteredClients() {
        return getAll(RegisteredClient.class);
    }

    public List<Tour> getTours() {
        return getAll(Tour.class);
    }

    public List<Employee> getEmployees() {
        return getAll(Employee.class);
    }

    public List<Purchase> getPurchases() {
        return getAll(Purchase.class);
    }

    public List<Reservation> getReservations() {
        return getAll(Reservation.class);
    }

    public void addRegisteredClient(RegisteredClient client) {
        List<RegisteredClient> list = getRegisteredClients();
        if (!list.contains(client)) {
            Serialized.database.computeIfAbsent(RegisteredClient.class, k -> new ArrayList<>()).add(client);
        }
    }

    public void addEmployee(Employee employee) {
        List<Employee> list = getEmployees();
        if (!list.contains(employee)) {
            Serialized.database.computeIfAbsent(Employee.class, k -> new ArrayList<>()).add(employee);
        }
    }

    public void addTour(Tour tour) {
        List<Tour> list = getTours();
        if (!list.contains(tour)) {
            Serialized.database.computeIfAbsent(Tour.class, k -> new ArrayList<>()).add(tour);
        }
    }

    public void removeRegisteredClient(RegisteredClient client) {
        List<Serialized<?>> list = Serialized.database.get(RegisteredClient.class);
        if (list != null) {
            list.remove(client);
        }
    }

  /*  public void removeRegisteredClient(String clientId) {
        List<RegisteredClient> list = getRegisteredClients();
        list.removeIf(c -> c.getClientId().equals(clientId));
        Serialized.database.put(RegisteredClient.class, new ArrayList<>(list));
    }*/

    public void buyTourUnregisteredClient(UnregisteredClient unregisteredClient, Tour tour, double price) {
        new Purchase(unregisteredClient, tour, price, LocalDate.now());
    }

    public void makeReservationRegisteredClient(RegisteredClient registeredClient, CustomerServiceSpecialist customerServiceSpecialist, Tour tour, double price) {
        new Reservation(registeredClient, customerServiceSpecialist, tour, price, LocalDate.now());
    }

    public void buyTourRegisteredClient(RegisteredClient registeredClient, CustomerServiceSpecialist customerServiceSpecialist, Tour tour, double price) {
        new Purchase(registeredClient, customerServiceSpecialist, tour, price, LocalDate.now());
    }

    public void makeReservationUnregisteredClient(UnregisteredClient unregisteredClient, Tour tour, double price) {
        new Reservation(unregisteredClient, tour, price, LocalDate.now());
    }

    public List<Tour> searchForClientTours(Client client) {
        return getPurchases().stream()
                .filter(purchase -> purchase.getClient().equals(client))
                .map(Purchase::getTour)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Client> getAllClients() {
        List<Client> registered = new ArrayList<>(getRegisteredClients());
        List<Client> purchaseClients = getPurchases().stream()
                .map(Purchase::getClient)
                .collect(Collectors.toList());
        return Stream.concat(registered.stream(), purchaseClients.stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public Client getTopSpendingClient() {
        Map<Client, Double> sumByClient = getPurchases().stream()
                .collect(Collectors.groupingBy(
                        Purchase::getClient,
                        Collectors.summingDouble(Purchase::getPrice)
                ));
        return sumByClient.entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public void saveSystemData(ObjectOutputStream stream) throws IOException {
        Serialized.save(stream);
    }

    public void loadSystemData(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        Serialized.load(stream);
    }

}
