package com.example.him.db.models;

public class Hospitalization {
    private int id;
    private int patientId;
    private int wardId;
    private int doctorId;
    private int departmentId;
    private String diagnosis;
    private int bedNumber;

    public Hospitalization(int patientId, int wardId, int doctorId, int departmentId, String diagnosis, int bedNumber) {
        this.patientId = patientId;
        this.wardId = wardId;
        this.doctorId = doctorId;
        this.departmentId = departmentId;
        this.diagnosis = diagnosis;
        this.bedNumber = bedNumber;
    }

    public Hospitalization() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getWardId() {
        return wardId;
    }

    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }
}
