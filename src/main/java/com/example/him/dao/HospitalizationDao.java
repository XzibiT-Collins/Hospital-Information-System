package com.example.him.dao;

import com.example.him.db.DatabaseConnector;
import com.example.him.db.models.Hospitalization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalizationDao {

    private final Connection connection;

    public HospitalizationDao() throws SQLException {
        this.connection = DatabaseConnector.getConnection();
    }

    // Get hospitalization by ID
    public Hospitalization getHospitalization(int id) throws SQLException {
        String query = "SELECT * FROM hospitalization WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Hospitalization hospitalization = new Hospitalization(
                        resultSet.getInt("patient_id"),
                        resultSet.getInt("local_ward_number"),
                        resultSet.getInt("doctor_id"),
                        resultSet.getInt("department_ward_id"),
                        resultSet.getString("diagnosis"),
                        resultSet.getInt("bed_number"),
                        resultSet.getInt("room_number")
                );
                hospitalization.setId(resultSet.getInt("id"));

                return hospitalization;
            }
        } catch (SQLException e) {
            throw new SQLException();
        }

        return null;
    }

    // Create hospitalization
    public void createHospitalization(Hospitalization hospitalization) throws SQLException {
        String query = "INSERT INTO hospitalization (patient_id, local_ward_number, doctor_id, department_ward_id, diagnosis, bed_number) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, hospitalization.getPatientId());
            preparedStatement.setInt(2, hospitalization.getWardId());
            preparedStatement.setInt(3, hospitalization.getDoctorId());
            preparedStatement.setInt(4, hospitalization.getDepartmentId());
            preparedStatement.setString(5, hospitalization.getDiagnosis());
            preparedStatement.setInt(6, hospitalization.getBedNumber());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    // Update hospitalization
    public void updateHospitalization(int id, int patientId, int wardId, int doctorId, int departmentId, String diagnosis, int bedNumber) throws SQLException {
        String query = "UPDATE hospitalization SET patient_id = ?, local_ward_number = ?, doctor_id = ?, department_ward_id = ?, diagnosis = ?, bed_number = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, patientId);
            preparedStatement.setInt(2, wardId);
            preparedStatement.setInt(3, doctorId);
            preparedStatement.setInt(4, departmentId);
            preparedStatement.setString(5, diagnosis);
            preparedStatement.setInt(6, bedNumber);
            preparedStatement.setInt(7, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    // Delete hospitalization
    public void deleteHospitalization(int id) throws SQLException {
        String query = "DELETE FROM hospitalization WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }
}
