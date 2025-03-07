package com.example.myapplication;

public class DataClass {
    private String imageUrl;
    private String caption;
    private String eventType;
    private String date;
    private String eventName;
    private String coordinatorName;
    private String eventTime;
    private String cordineterNumber;
    private String registrationLink;

    public DataClass() {
        // Default constructor required for Firebase
    }

    public DataClass(String imageUrl, String caption, String eventType, String date, String eventName, String coordinatorName, String eventTime, String cordineterNumber, String registrationLink) {
        this.imageUrl = imageUrl;
        this.caption = caption;
        this.eventType = eventType;
        this.date = date;
        this.eventName = eventName;
        this.coordinatorName = coordinatorName;
        this.eventTime = eventTime;
        this.cordineterNumber = cordineterNumber;
        this.registrationLink = registrationLink;
    }

    // Getters and setters for imageUrl, caption, eventType, date, eventName, coordinatorName, eventTime, cordineterNumber, registrationLink

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCoordinatorName() {
        return coordinatorName;
    }

    public void setCoordinatorName(String coordinatorName) {
        this.coordinatorName = coordinatorName;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getCordineterNumber() {
        return cordineterNumber;
    }

    public void setCordineterNumber(String cordineterNumber) {
        this.cordineterNumber = cordineterNumber;
    }

    public String getRegistrationLink() {
        return registrationLink;
    }

    public void setRegistrationLink(String registrationLink) {
        this.registrationLink = registrationLink;
    }
}
