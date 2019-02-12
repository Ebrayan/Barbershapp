package com.example.thebryan.combarbershapp.Models;

import java.io.Serializable;
import java.util.List;

public class Employed implements Serializable {

    String code;

    String name;

    String Image;

    int inTurn;



    public  Employed(String test){
        code = "s574v";

        name = "Empleado " + test;

         Image = "wfgwekfgs";

        inTurn = 6;

    }

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

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getInTurn() {
        return inTurn;
    }

    public void setInTurn(int inTurn) {
        this.inTurn = inTurn;
    }

    public List<String> getList_service() {
        return List_service;
    }

    public void setList_service(List<String> list_service) {
        List_service = list_service;
    }
    //String Horario??;

    List<String> List_service;


}
