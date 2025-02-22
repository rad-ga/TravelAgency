package com.travelagency;

import com.travelagency.model.Employee;
import com.travelagency.model.Tour;
import com.travelagency.model.TravelAgencyService;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {
    @FXML
    private Button btnShowTours;

    @FXML
    private Button btnShowEmployees;

    @FXML
    private Button btnSaveExit;

    @FXML
    private TableView<Employee> tableEmployees;

    @FXML
    private TableView<Tour> tableTours;

    private TravelAgencyService travelAgencyService;

    public void setTravelAgencyService(TravelAgencyService travelAgencyService){
        this.travelAgencyService=travelAgencyService;
    }

    @FXML
    public void initialize() {
        TableColumn<Tour, String> colTourId = (TableColumn<Tour, String>) tableTours.getColumns().get(0);
        colTourId.setCellValueFactory(new PropertyValueFactory<>("tourId"));

        TableColumn<Tour, String> colTourType = (TableColumn<Tour, String>) tableTours.getColumns().get(1);
        colTourType.setCellValueFactory(new PropertyValueFactory<>("tourType"));

        TableColumn<Tour, Double> colPrice = (TableColumn<Tour, Double>) tableTours.getColumns().get(2);
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Tour, String> colCity = (TableColumn<Tour, String>) tableTours.getColumns().get(3);

        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));

        TableColumn<Tour, String> colCountry = (TableColumn<Tour, String>) tableTours.getColumns().get(4);
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));


        TableColumn<Employee, String> colName = (TableColumn<Employee, String>) tableEmployees.getColumns().get(0);
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Employee, String> colSurname = (TableColumn<Employee, String>) tableEmployees.getColumns().get(1);
        colSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));

        TableColumn<Employee, String> colEmail = (TableColumn<Employee, String>) tableEmployees.getColumns().get(2);
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Employee, String> colPhone = (TableColumn<Employee, String>) tableEmployees.getColumns().get(3);
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<Employee, String> colEmploymentType = (TableColumn<Employee, String>) tableEmployees.getColumns().get(4);
        colEmploymentType.setCellValueFactory(new PropertyValueFactory<>("employmentType"));

        TableColumn<Employee, String> colType = (TableColumn<Employee, String>) tableEmployees.getColumns().get(5);

        colType.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));

        tableTours.setVisible(false);
        tableEmployees.setVisible(false);
    }

    @FXML
    private void handleShowTours() {
        ObservableList<Tour> tours = FXCollections.observableArrayList(travelAgencyService.getTours());
        tableTours.setItems(tours);
        tableTours.setVisible(true);
        tableEmployees.setVisible(false);
    }

    @FXML
    private void handleShowEmployees() {
        ObservableList<Employee> employees = FXCollections.observableArrayList(travelAgencyService.getEmployees());
        tableEmployees.setItems(employees);
        tableEmployees.setVisible(true);
        tableTours.setVisible(false);
    }

    @FXML
    private void handleSaveExit() {
        //travelAgencyService.saveSystemData();
        javafx.application.Platform.exit();
    }
}