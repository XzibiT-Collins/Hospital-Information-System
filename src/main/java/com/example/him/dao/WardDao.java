package com.example.him.dao;

import com.example.him.db.DatabaseConnector;
import com.example.him.db.models.Ward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WardDao {
    private final Connection connection;

    public WardDao() throws SQLException {
        this.connection = DatabaseConnector.getConnection();
    }

    // Get ward by ID
    public Ward getWard(int id) throws SQLException {
        String query = "SELECT * FROM ward WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ward ward = new Ward(
                        resultSet.getInt("local_ward_number "),
                        resultSet.getInt("no_of_beds"),
                        resultSet.getInt("supervisor_id"),
                        resultSet.getInt("department_id")
                );
                ward.setId(resultSet.getInt("id"));
                return ward;
            }
        } catch (SQLException e) {
            throw new SQLException();
        }

        return null;
    }

    // Create ward
    public void createWard(Ward ward) throws SQLException {
        String query = "INSERT INTO ward (no_of_beds,local_ward_number , supervisor_id, department_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, ward.getNoOfBeds());
            preparedStatement.setInt(2, ward.getWardNumber());
            preparedStatement.setInt(3, ward.getSupervisorId());
            preparedStatement.setInt(4, ward.getDepartmentId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    // Update ward
    public void updateWard(int id,int wardNumber, int noOfBeds, int nurseId, int departmentId) throws SQLException {
        String query = "UPDATE ward SET no_of_beds = ?,local_ward_number  = ?, supervisor_id = ?, department_id = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, noOfBeds);
            preparedStatement.setInt(2, wardNumber);
            preparedStatement.setInt(3, nurseId);
            preparedStatement.setInt(4, departmentId);
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    // Delete ward
    public void deleteWard(int id) throws SQLException {
        String query = "DELETE FROM ward WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }
}
