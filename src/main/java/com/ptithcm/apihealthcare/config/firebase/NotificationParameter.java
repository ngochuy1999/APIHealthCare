package com.ptithcm.apihealthcare.config.firebase;

public enum NotificationParameter {
    SOUND("alarm"),
    COLOR("#FFFF00"),
    CHANNEL_ID("fcm_health_care");

    private String value;

    NotificationParameter(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
