package com.example.hp.pharmacist;

/**
 * Created by Hp on 24-02-2018.
 */

public class prescription {
    String $class;
    String pre_id;
    String patient_id;
    String doctor_id;

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    String prescription_data;
    //String status;
    public String get$class() {
        return $class;
    }

    public void set$class(String $class) {
        this.$class = $class;
    }

    public String getPre_id() {
        return pre_id;
    }

    public void setPre_id(String pre_id) {
        this.pre_id = pre_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getPrescription_data() {
        return prescription_data;
    }

    public void setPrescription_data(String prescription_data) {
        this.prescription_data = prescription_data;
    }
}
