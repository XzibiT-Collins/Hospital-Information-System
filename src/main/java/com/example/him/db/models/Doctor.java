package com.example.him.db.models;

public class Doctor {
    int employeeId;
    String specialty;

    public Doctor(int employeeId,String specialty){
        this.employeeId = employeeId;
        this.specialty = specialty;
    }

    //getters
    public int getEmployeeId(){
        return this.employeeId;
    }

    public String getSpecialty(){
        return this.specialty;
    }

    //setters
    public void setEmployeeId(int id){
        this.employeeId = id;
    }
}
