package com.example.him.dao;

import com.example.him.db.DatabaseConnector;
import com.example.him.db.models.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDao {

    private final Connection connection;

    public DepartmentDao() throws SQLException {
        this.connection = DatabaseConnector.getConnection();
    }

    // GET department by ID
    public Department getDepartment(int id) throws SQLException {
        String query = "SELECT * FROM department WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department department = new Department(
                        resultSet.getString("dep_name"),
                        resultSet.getString("building"),
                        resultSet.getInt("doctor_id")
                );
                department.setId(resultSet.getInt("id"));
                return department;
            }
        } catch (SQLException e) {
            throw new SQLException();
        }

        return null;
    }

    // CREATE department
    public void createDepartment(Department department) throws SQLException {
        String query = "INSERT INTO department (dep_name, building, doctor_id) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, department.getDepName());
            preparedStatement.setString(2, department.getBuilding());
            preparedStatement.setInt(3, department.getDoctorId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    // UPDATE department
    public void updateDepartment(int id, String depName, String building, int doctorId) throws SQLException {
        String query = "UPDATE department SET dep_name = ?, building = ?, doctor_id = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, depName);
            preparedStatement.setString(2, building);
            preparedStatement.setInt(3, doctorId);
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    // DELETE department
    public void deleteDepartment(int id) throws SQLException {
        String query = "DELETE FROM department WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }
}
