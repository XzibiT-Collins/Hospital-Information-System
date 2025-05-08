package com.example.him.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.example.him.dao.EmployeeDao;
import com.example.him.db.models.Employee;
import com.example.him.db.models.Ward;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<Employee, String> colAddress;

    @FXML
    private TableColumn<Employee, String > colFirstname;

    @FXML
    private TableColumn<Employee, Integer> colId;

    @FXML
    private TableColumn<Employee, String> colPhone;

    @FXML
    private TableColumn<Employee, String> colSurname;

    @FXML
    private TableView<Employee> tableEmployees;

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

    //Logger
    Logger logger = Logger.getLogger(EmployeeController.class.getName());

    //create employee list
    List<Employee> employeeList = new ArrayList<>();
    ObservableList<Employee>observableList;

    @FXML
    void HandleClearFields(ActionEvent event) {
        txtId.setText("");
        txtAddress.setText("");
        txtFirstname.setText("");
        txtSurname.setText("");
        txtPhone.setText("");
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

            //undate employee table
            updateEmployeeTable();

            showAlert("Success","Employee created.", Alert.AlertType.CONFIRMATION);
            //clear input fields
            HandleClearFields(null);
        }catch (SQLException e){
            showAlert("Error","There was an error creating employee.", Alert.AlertType.ERROR);
            logger.info("Error while creating employee: "+ e.getMessage());
        }
    }

    @FXML
    void handleDeleteEmployee(ActionEvent event) {
        String str_emp_id = txtId.getText();
        int emp_id = Integer.parseInt(str_emp_id);
        logger.info("Deleting Employee with id: "+ emp_id);
        try{
            EmployeeDao employeeDao = new EmployeeDao();
            employeeDao.deleteEmployee(emp_id);
            showAlert("Success", "Employee deleted successful", Alert.AlertType.CONFIRMATION);

            //refresh table and clear fields
            updateEmployeeTable();
            HandleClearFields(null);

        }catch (SQLException e){
            showAlert("Error","Unable to delete user with ID: "+ emp_id,Alert.AlertType.ERROR);
            logger.info("Error deleting employee with ID: "+ emp_id + " :" + e.getMessage());
        }
    }

    @FXML
    void handleUpdateEmployee(ActionEvent event) {
        String str_emp_id = txtId.getText();
        String surname = txtSurname.getText();
        String firstname = txtFirstname.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();
        int emp_id = 0;

        try {
            emp_id = Integer.parseInt(str_emp_id);
        }catch (Exception e){
            showAlert("Error", "Enter a valid ID.", Alert.AlertType.ERROR);
            logger.info("Error invalid ID: "+ e.getMessage());
        }

        try{
            EmployeeDao employeeDao = new EmployeeDao();
            employeeDao.updateEmployee(emp_id,surname,firstname,address,phone);
            showAlert("Success","Employee updated successfully.", Alert.AlertType.CONFIRMATION);
            logger.info("Employee updated ID: "+ emp_id);

            //update table and clear fields
            updateEmployeeTable();
            HandleClearFields(null);

        }catch (SQLException e){
            showAlert("Error", "Unable to update Employee.", Alert.AlertType.ERROR);
            logger.info("Error updating employee: "+ e.getMessage());
        }
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

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        colFirstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        //preload existing data
        try {
            updateEmployeeTable();
        }catch (SQLException e){
            showAlert("Error","Failed to load data from source", Alert.AlertType.ERROR);
            logger.info("Error preloading employee table: "+ e.getMessage());
        }
    }

    //Alert
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //fetch all employees and display to user in listview
    private void updateEmployeeTable()throws SQLException{
        try{
            EmployeeDao employeeDao = new EmployeeDao();
            employeeList = employeeDao.getAllEmployees();

            //update table
            if(employeeList != null){
                observableList = FXCollections.observableArrayList(employeeList);
                tableEmployees.setItems(observableList);
            }
        }catch (SQLException e){
            showAlert("Error","An error occurred fetching employees.", Alert.AlertType.ERROR);
            logger.info("Error updating employee table :"+ e.getMessage());
        }
    }

}
