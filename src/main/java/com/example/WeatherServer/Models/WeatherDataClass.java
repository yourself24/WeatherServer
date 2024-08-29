package com.example.WeatherServer.Models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity(name = "weatherdata")
public class WeatherDataClass {

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getFeels() {
        return feels;
    }

    public void setFeels(double feels) {
        this.feels = feels;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "provider")
    private String provider;
    @Column(name = "address")
    private String address;
    @Column(name = "temperature")
    private double temperature;
    @Column(name = "feels")
    private double feels;
    @Column(name = "precipitation")
    private double precipitation;
    @Column(name = "humidity")
    private int humidity;
    @Column(name = "pressure")
    private double pressure;
    @Column(name = "userid")
    private Long userid;
    @Column(name = "date")
    private java.sql.Timestamp date;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public  WeatherDataClass(){

    }
    public WeatherDataClass(String provider, String address, double temperature, double feels, double precipitation, int humidity, double pressure, Long userid, Timestamp date) {
        this.provider = provider;
        this.address = address;
        this.temperature = temperature;
        this.feels = feels;
        this.precipitation = precipitation;
        this.humidity = humidity;
        this.pressure = pressure;
        this.userid = userid;
        this.date = date;
    }
}


