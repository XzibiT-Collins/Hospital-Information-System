package com.example.him.dao;

import com.example.him.db.DatabaseConnector;
import com.example.him.db.models.Transfer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferDao {

    private final Connection connection;

    public TransferDao() throws SQLException {
        this.connection = DatabaseConnector.getConnection();
    }

    // Get a transfer by ID
    public Transfer getTransfere(int id) throws SQLException {
        String query = "SELECT * FROM transfere WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Transfer transfere = new Transfer(
                        resultSet.getInt("patient_id"),
                        resultSet.getInt("from_hospitalization_id"),
                        resultSet.getInt("to_hospitalization_id"),
                        resultSet.getString("reason")
                );
                transfere.setId(resultSet.getInt("id"));

                return transfere;
            }
        } catch (SQLException e) {
            throw new SQLException();
        }

        return null;
    }

    // Create a new transfer
    public void createTransfere(Transfer transfere) throws SQLException {
        String query = "INSERT INTO transfere (patient_id, from_hospitalization_id, to_hospitalization_id, reason) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, transfere.getPatientId());
            preparedStatement.setInt(2, transfere.getFromHospitalizationId());
            preparedStatement.setInt(3, transfere.getToHospitalizationId());
            preparedStatement.setString(4, transfere.getReason());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    // Update a transfer
    public void updateTransfere(int id, int patientId, int fromHospitalizationId, int toHospitalizationId, String reason) throws SQLException {
        String query = "UPDATE transfere SET patient_id = ?, from_hospitalization_id = ?, to_hospitalization_id = ?, reason = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, patientId);
            preparedStatement.setInt(2, fromHospitalizationId);
            preparedStatement.setInt(3, toHospitalizationId);
            preparedStatement.setString(4, reason);
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    // Delete a transfer
    public void deleteTransfere(int id) throws SQLException {
        String query = "DELETE FROM transfere WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }
}
