package com.example.him.dao;

import com.example.him.db.DatabaseConnector;
import com.example.him.db.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDao {
    private final Connection connection;

    public EmployeeDao() throws SQLException {
        this.connection = DatabaseConnector.getConnection();
    }

    //get employee
    public Employee getEmployeeById(int id) throws SQLException{
        String query = "SELECT * FROM employee WHERE id= ?"; //sql query to retrieve employee

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);

            //Execute and collect result
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Employee employee = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("first_name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone")
                );

                return employee;
            }
        }catch (SQLException e){
            throw new SQLException(); //throw the error to where it was called
        }
        return null;
    }

    //create an employee
    public void createEmployee(Employee employee) throws SQLException{
        String query = "INSERT INTO employee (surname, first_name, address, phone) VALUES(?,?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            //set fields to create
            preparedStatement.setString(1,employee.getSurname());
            preparedStatement.setString(2,employee.getFirstName());
            preparedStatement.setString(3,employee.getAddress());
            preparedStatement.setString(4,employee.getPhone());

            //execute query
            preparedStatement.executeQuery(); //creates user

        }catch (SQLException e){
            throw new SQLException();
        }
    }
}
