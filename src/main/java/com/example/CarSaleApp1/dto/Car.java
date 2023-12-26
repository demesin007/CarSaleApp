package com.example.CarSaleApp1.dto;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "year")
    private String year;

    @Column(name = "model")
    private String model;
    @Column(name = "price")
    private int price;
    @Column(name="kmtraveled")
    private int kmTraveled;
    @Column(name = "info")
    private String extraInfo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public int getId() {
        return id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getKmTraveled() {
        return kmTraveled;
    }

    public void setKmTraveled(int kmTraveled) {
        this.kmTraveled = kmTraveled;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", year='" + year + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", kmTraveled=" + kmTraveled +
                ", extraInfo='" + extraInfo + '\'' +
                '}';
    }

    public void setId(int hashCode) {
        this.id=hashCode;
    }

}
