package com.example.him.db.models;

public class Nurse {
    private int employeeId;
    private int departmentId;
    private String rotation;
    private Double salary;

    public Nurse(){}

    public Nurse(int employeeId,int departmentId, String rotation, Double salary){
        this.employeeId = employeeId;
        this.departmentId = departmentId;
        this.rotation = rotation;
        this.salary = salary;
    }

    //getters
    public int getEmployeeId(){
        return this.employeeId;
    }

    public int getDepartmentId(){
        return this.departmentId;
    }

    public String getRotation(){
        return this.rotation;
    }
    public Double getSalary(){
        return this.salary;
    }

    //setters
    public void setEmployeeId(int id){
        this.employeeId = id;
    }
}
