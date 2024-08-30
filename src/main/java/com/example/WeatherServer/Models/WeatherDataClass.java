package com.example.WeatherServer.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime date;

    @Override
    public String toString() {
        return "WeatherDataClass{" +
                "id=" + id +
                ", provider='" + provider + '\'' +
                ", address='" + address + '\'' +
                ", temperature=" + temperature +
                ", feels=" + feels +
                ", precipitation=" + precipitation +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", userid=" + userid +
                ", date=" + date +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public  WeatherDataClass(){

    }
    public WeatherDataClass(String provider, String address, double temperature, double feels, double precipitation, int humidity, double pressure, Long userid, LocalDateTime date) {
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


