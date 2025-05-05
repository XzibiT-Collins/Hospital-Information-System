package com.example.him.db.models;

public class Employee {
    private int id;
    private String surname;
    private String firstName;
    private String address;
    private String phone;

    public  Employee(){

    }
    public Employee(int id,String surname, String firstName, String address, String phone){
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.address = address;
        this.phone =phone;
    }


    // Getters
    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
