package com.example.him.db.models;

public class Ward {
    private int id;
    private int wardNumber;
    private int noOfBeds;
    private int supervisorId;
    private int departmentId;

    public Ward(int wardNumber, int noOfBeds, int supervisorId, int departmentId) {
        this.wardNumber = wardNumber;
        this.noOfBeds = noOfBeds;
        this.supervisorId = supervisorId;
        this.departmentId = departmentId;
    }

    public Ward() {}

    public int getId() {
        return id;
    }

    public int getWardNumber(){
        return this.wardNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setNurseId(int nurseId) {
        this.supervisorId = nurseId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
