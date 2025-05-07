package com.example.him.db.models;

public class Transfer {
    private int id;
    private int patientId;
    private int fromHospitalizationId;
    private int toHospitalizationId;
    private String reason;

    public Transfer(int patientId, int fromHospitalizationId, int toHospitalizationId, String reason) {
        this.patientId = patientId;
        this.fromHospitalizationId = fromHospitalizationId;
        this.toHospitalizationId = toHospitalizationId;
        this.reason = reason;
    }

    public Transfer() {}

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

    public int getFromHospitalizationId() {
        return fromHospitalizationId;
    }

    public void setFromHospitalizationId(int fromHospitalizationId) {
        this.fromHospitalizationId = fromHospitalizationId;
    }

    public int getToHospitalizationId() {
        return toHospitalizationId;
    }

    public void setToHospitalizationId(int toHospitalizationId) {
        this.toHospitalizationId = toHospitalizationId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
