package com.ptithcm.apihealthcare.model.request;

public class PrescriptionParam {

    private Integer medicineId;

    private Integer quantity;

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
