package com.example.him;

import com.example.him.dao.EmployeeDao;
import com.example.him.db.DatabaseConnector;
import com.example.him.db.models.Employee;
import javafx.scene.chart.PieChart;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestDb {
    public static void main(String[] args){
        try{
            //create new employee Dao
            EmployeeDao employeeDao = new EmployeeDao();
            //create employee object
            Employee newEmp = new Employee("John","Doe","Accra","0548730194");

            //create employee in db
//            employeeDao.createEmployee(newEmp);
//            System.out.println("Employee created successfully");

            //update employee details
//            employeeDao.updateEmployee(2,"Huvison","Etornam","East Legon","0550570368");
//            System.out.println("User updated successfully");

            //delete an employee
//            employeeDao.deleteEmployee(1);
//            System.out.println("Employee deleted successfully");

            //get all employees
            List<Employee> employeeList = employeeDao.getAllEmployees();
            for(Employee emp: employeeList){
                System.out.println(emp.getSurname() + " "+ emp.getFirstName());
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
