package com.example.thebryan.combarbershapp.Models;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Service  implements Serializable{


    public  Service(String s){
        id = "sdg654sFGs_d";
        Name = "Service"+s;
        Price  = 150;
        mainimage = "www.image.com/hola.jpg";
        Sesion = "Pelo";
        EmployedList = new ArrayList<>();
        EmployedList.add(new Employed("1"));
        EmployedList.add(new Employed("2"));
        EmployedList.add(new Employed("3"));


    }
    public  Service(String id,String name, int price,String image,String sesion){
        id = "sdg654sFGs_d";
        this.Name = name;
        this.Price  = price;
        this.mainimage = image;
        Sesion = sesion;
        EmployedList = new ArrayList<>();
        EmployedList.add(new Employed("1"));
        EmployedList.add(new Employed("2"));
        EmployedList.add(new Employed("3"));


    }




    String id;
    String  Name;
    String mainimage;
    int Price;
    String Sesion;
    HashSet Opinions;
    ArrayList<Employed> EmployedList;
    List <String> ImagesList;






    public ArrayList<Employed> getEmployedList() {
        return EmployedList;
    }

    public void setEmployedList(ArrayList<Employed> employedList) {
        EmployedList = employedList;
    }

    public List<String> getImagesList() {
        return ImagesList;
    }

    public void setImagesList(List<String> imagesList) {
        ImagesList = imagesList;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getSesion() {
        return Sesion;
    }

    public void setSesion(String sesion) {
        Sesion = sesion;
    }

    public HashSet getOpinions() {
        return Opinions;
    }

    public void setOpinions(HashSet opinions) {
        Opinions = opinions;
    }
}
