package com.smoki.internetapp;

public class InternetPackage {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private int internetSpeed;
    private String bandwidth;
    private int contractLength;

    public InternetPackage(int id, String firstName, String lastName, String address, int internetSpeed, String bandwidth, int contractLength) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.internetSpeed = internetSpeed;
        this.bandwidth = bandwidth;
        this.contractLength = contractLength;
    }

    public InternetPackage(String firstName, String lastName, String address, int internetSpeed, String bandwidth, int contractLength) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.internetSpeed = internetSpeed;
        this.bandwidth = bandwidth;
        this.contractLength = contractLength;
    }

    public InternetPackage() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getInternetSpeed() {
        return internetSpeed;
    }

    public void setInternetSpeed(int internetSpeed) {
        this.internetSpeed = internetSpeed;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(int contractLength) {
        this.contractLength = contractLength;
    }

    @Override
    public String toString() {
        return "InternetPackage{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", internetSpeed=" + internetSpeed +
                ", bandwidth='" + bandwidth + '\'' +
                ", contractLength=" + contractLength +
                '}';
    }
}



