package com.example.him.dao;

import com.example.him.db.DatabaseConnector;
import com.example.him.db.models.Doctor;

import javax.print.Doc;
import java.sql.*;
import java.util.List;

public class DoctorDao {
    private final Connection connection;

    public DoctorDao() throws SQLException {
        this.connection = DatabaseConnector.getConnection();
    }

    //getters
    public Doctor getDoctor(int id) throws SQLException{
        String query = "SELECT * FROM doctor WHERE employee_id=?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);

            //execute query
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Doctor doctor = new Doctor(
                        resultSet.getInt("employee_id"),
                        resultSet.getString("specialty")
                );

                return doctor;
            }
        }catch (SQLException e){
            throw new SQLException();
        }
        return null;
    }

    //create doctor
    public void createDoctor(Doctor doctor)throws SQLException{
        String query = "INSERT INTO doctor (employee_id,specialty) VALUES(?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,doctor.getEmployeeId());
            preparedStatement.setString(2,doctor.getSpecialty());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new SQLException();
        }
    }

    //update doctor
    public void updateSpecialty(int id,String specialty)throws SQLException{
        String query = "UPDATE doctor SET specialty = ? WHERE employee_id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,specialty);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            throw new SQLException();
        }
    }

    //delete doctor
    public void deleteDoctor(int id)throws SQLException{
        String query = "DELETE FROM doctor WHERE employee_id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new SQLException();
        }
    }

    //get all doctors
    public List<Doctor> getAllDoctors() throws SQLException{
        String query = "SELECT * FROM doctors";
        List<Doctor> doctorList = null;

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                //create employee obj
                Doctor doctor = new Doctor(
                        resultSet.getInt("employee_id"),
                        resultSet.getString("specialty")
                );

                //add doctor to list
                doctorList.add(doctor);
            }
        }catch (SQLException e){
            throw new SQLException();
        }
        return null;
    }
}
