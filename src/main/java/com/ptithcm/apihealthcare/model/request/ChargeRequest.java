package com.ptithcm.apihealthcare.model.request;

import lombok.Data;

@Data
public class ChargeRequest {
    public enum Currency {
        EUR, USD;
    }
    private int billId;
    private String description;
    private int amount;
    private Currency currency;
    private String stripeToken;
}
