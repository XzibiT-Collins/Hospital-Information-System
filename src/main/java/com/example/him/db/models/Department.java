package com.example.him.db.models;

public class Department {
    private int id;
    private String depName;
    private String building;
    private int doctorId;

    public Department(String depName, String building, int doctorId) {
        this.depName = depName;
        this.building = building;
        this.doctorId = doctorId;
    }

    public Department() {}

    public int getId() {
        return id;
    }

    public Department setId(int id) {
        this.id = id;
        return this;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
}
