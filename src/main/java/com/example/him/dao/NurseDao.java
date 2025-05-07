package com.example.him.dao;

import com.example.him.db.DatabaseConnector;
import com.example.him.db.models.Doctor;
import com.example.him.db.models.Nurse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class NurseDao {

    private final Connection connection;

    public NurseDao() throws SQLException {
        this.connection = DatabaseConnector.getConnection();
    }

    //getters
    public Nurse getNurse(int id) throws SQLException{
        String query = "SELECT * FROM nurse WHERE employee_id=?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);

            //execute query
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Nurse nurse = new Nurse(
                        resultSet.getInt("employee_id"),
                        resultSet.getInt("department_id"),
                        resultSet.getString("rotation"),
                        resultSet.getDouble("salary")
                );

                return nurse;
            }
        }catch (SQLException e){
            throw new SQLException();
        }
        return null;
    }

    //create nurse
    public void createNurse(Nurse nurse)throws SQLException{
        String query = "INSERT INTO nurse (employee_id,department_id,rotation,salary) VALUES(?,?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,nurse.getEmployeeId());
            preparedStatement.setInt(2,nurse.getDepartmentId());
            preparedStatement.setString(3,nurse.getRotation());
            preparedStatement.setDouble(4,nurse.getSalary());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new SQLException();
        }
    }

    //update nurse
    public void updateNurse(int id,int dep_id,String rotation, Double salary)throws SQLException{
        String query = "UPDATE nurse SET department_id = ?,rotation = ?, salary = ? WHERE employee_id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,dep_id);
            preparedStatement.setString(2,rotation);
            preparedStatement.setDouble(3,salary);
            preparedStatement.setInt(4,id);

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            throw new SQLException();
        }
    }

    //delete nurse
    public void deleteNurse(int id)throws SQLException{
        String query = "DELETE FROM nurse WHERE employee_id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new SQLException();
        }
    }

    //get all nurses
    public List<Nurse> getAllNurses() throws SQLException{
        String query = "SELECT * FROM nurse";
        List<Nurse> nurseList = null;

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                //create employee obj
                Nurse nurse = new Nurse(
                        resultSet.getInt("employee_id"),
                        resultSet.getInt("department_id"),
                        resultSet.getString("rotation"),
                        resultSet.getDouble("salary")
                );

                //add doctor to list
                nurseList.add(nurse);
            }
        }catch (SQLException e){
            throw new SQLException();
        }
        return null;
    }
}
