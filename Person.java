package com.example.assignment2;

public class Person {
    private String name;
    private String fatherName;
    private String cnic;
    private String date;
    private String gender;
    private String city;
    private String imageUrl;

    public Person(String name, String fatherName, String cnic, String date, String gender, String city, String imageUrl) {
        this.name = name;
        this.fatherName = fatherName;
        this.cnic = cnic;
        this.date = date;
        this.gender = gender;
        this.city = city;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", cnic='" + cnic + '\'' +
                ", date='" + date + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
