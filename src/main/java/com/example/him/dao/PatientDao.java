package com.example.him.dao;

import com.example.him.db.DatabaseConnector;
import com.example.him.db.models.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDao {

    private final Connection connection;

    public PatientDao() throws SQLException {
        this.connection = DatabaseConnector.getConnection();
    }

    // GET a patient by ID
    public Patient getPatient(int id) throws SQLException {
        String query = "SELECT * FROM patient WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Patient patient = new Patient(
                        resultSet.getString("first_name"),
                        resultSet.getString("surname"),
                        resultSet.getString("address"),
                        resultSet.getString("phone")
                );
                patient.setId(resultSet.getInt("id"));
                return patient;
            }
        } catch (SQLException e) {
            throw new SQLException();
        }
        return null;
    }

    // CREATE a new patient
    public void createPatient(Patient patient) throws SQLException {
        String query = "INSERT INTO patient (first_name, surname, address, phone) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, patient.getFirstName());
            preparedStatement.setString(2, patient.getSurname());
            preparedStatement.setString(3, patient.getAddress());
            preparedStatement.setString(4, patient.getPhone());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    // UPDATE a patient
    public void updatePatient(int id, String firstName, String surname, String address, String phone) throws SQLException {
        String query = "UPDATE patient SET first_name = ?, surname = ?, address = ?, phone = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, phone);
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    // DELETE a patient
    public void deletePatient(int id) throws SQLException {
        String query = "DELETE FROM patient WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }
}
