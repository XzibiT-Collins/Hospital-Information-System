package com.example.him.db.models;

public class Department {
    private int id;
    private String depName;
    private String building;
    private int director_id;

    public Department(String depName, String building, int director_id) {
        this.depName = depName;
        this.building = building;
        this.director_id = director_id;
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

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }
}
