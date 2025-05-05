package com.example.him.db.models;

public class Employee {
    private int id;
    private String surname;
    private String firstName;
    private String address;
    private String phone;

    public  Employee(){}

    public Employee(String surname, String firstName, String address, String phone){
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
}
