package com.example.him.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private BorderPane mainContainer;

    @FXML
    private VBox sideMenu;

    @FXML
    private Button btnEmployees, btnDoctors, btnNurses, btnPatients,
            btnHospitalizations, btnTransfers, btnWards, btnDepartments;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set default view
        loadPage("/com/example/him/EmployeePage.fxml");

        // Set up button actions
        btnEmployees.setOnAction(e -> loadPage("/com/example/him/EmployeePage.fxml"));
        btnDoctors.setOnAction(e -> loadPage("/com/example/him/DoctorPage.fxml"));
        btnNurses.setOnAction(e -> loadPage("/com/example/him/NursePage.fxml"));
        btnPatients.setOnAction(e -> loadPage("/com/example/him/PatientPage.fxml"));
        btnHospitalizations.setOnAction(e -> loadPage("/com/example/him/HospitalizationPage.fxml"));
        btnTransfers.setOnAction(e -> loadPage("/com/example/him/TransferPage.fxml"));
        btnWards.setOnAction(e -> loadPage("/com/example/him/WardPage.fxml"));
        btnDepartments.setOnAction(e -> loadPage("/com/example/him/DepartmentPage.fxml"));
    }

    private void loadPage(String fxmlPath) {
        try {
            Parent page = FXMLLoader.load(getClass().getResource(fxmlPath));
            mainContainer.setCenter(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
