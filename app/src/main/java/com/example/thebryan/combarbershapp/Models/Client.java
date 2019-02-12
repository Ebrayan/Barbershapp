package com.example.thebryan.combarbershapp.Models;

import java.util.ArrayList;
import java.util.List;

public class Client {

    String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFrecuents_service() {
        return frecuents_service;
    }

    public void setFrecuents_service(List<String> frecuents_service) {
        this.frecuents_service = frecuents_service;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    String name;

    List<String> frecuents_service;

    String  image;

    public ArrayList<Order> getServicioActivo() {
        return ServicioActivo;
    }

    public void setServicioActivo(ArrayList<Order> servicioActivo) {
        ServicioActivo = servicioActivo;
    }

    ArrayList<Order> ServicioActivo;

    public Client(String name) {

        ServicioActivo = new ArrayList<>();
        this.name = name;

    }
}