package com.example.him.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.example.him.dao.EmployeeDao;
import com.example.him.db.models.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EmployeeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colFirstname;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colSurname;

    @FXML
    private TableView<?> tableEmployees;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtFirstname;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtSurname;

    //create employee list
    List<Employee> employeeList = new ArrayList<>();

    @FXML
    void HandleClearFields(ActionEvent event) {

    }

    @FXML
    void handleCreateEmployee(ActionEvent event) {
        String surname = txtSurname.getText();
        String firstName = txtFirstname.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();
        if(surname.isBlank() || firstName.isBlank() || address.isBlank() || phone.isBlank()){
            showAlert("Warning", "Make sure you fill all fields.", Alert.AlertType.WARNING);
            return;
        }

        //create employee
        try{
            EmployeeDao employeeDao = new EmployeeDao();
            Employee employee = new Employee(surname,firstName,address,phone);
            employeeDao.createEmployee(employee);
            showAlert("Success","Employee created.", Alert.AlertType.CONFIRMATION);
        }catch (SQLException e){
            showAlert("Error","There was an error creating employee.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void handleDeleteEmployee(ActionEvent event) {

    }

    @FXML
    void handleUpdateEmployee(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'EmployeePage.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'EmployeePage.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'EmployeePage.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'EmployeePage.fxml'.";
        assert colAddress != null : "fx:id=\"colAddress\" was not injected: check your FXML file 'EmployeePage.fxml'.";
        assert colFirstname != null : "fx:id=\"colFirstname\" was not injected: check your FXML file 'EmployeePage.fxml'.";
        assert colId != null : "fx:id=\"colId\" was not injected: check your FXML file 'EmployeePage.fxml'.";
        assert colPhone != null : "fx:id=\"colPhone\" was not injected: check your FXML file 'EmployeePage.fxml'.";
        assert colSurname != null : "fx:id=\"colSurname\" was not injected: check your FXML file 'EmployeePage.fxml'.";
        assert tableEmployees != null : "fx:id=\"tableEmployees\" was not injected: check your FXML file 'EmployeePage.fxml'.";
        assert txtAddress != null : "fx:id=\"txtAddress\" was not injected: check your FXML file 'EmployeePage.fxml'.";
        assert txtFirstname != null : "fx:id=\"txtFirstname\" was not injected: check your FXML file 'EmployeePage.fxml'.";
        assert txtId != null : "fx:id=\"txtId\" was not injected: check your FXML file 'EmployeePage.fxml'.";
        assert txtPhone != null : "fx:id=\"txtPhone\" was not injected: check your FXML file 'EmployeePage.fxml'.";
        assert txtSurname != null : "fx:id=\"txtSurname\" was not injected: check your FXML file 'EmployeePage.fxml'.";

    }

    //Alert
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
