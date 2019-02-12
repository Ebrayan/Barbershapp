package com.example.thebryan.combarbershapp.Models;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Order {


    public  final static int  CHANGEQUANTITY = 1,CHANGEHOUR =3, CHANGEBARBER=4,CHANGEDATE=2;

    String serviceName;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    int Hour;

    String Tanda;

    String date;

    int finalPrice;

    int Quantity =1;

    Employed barberSelected;

    String weekday;

    Calendar calendar;

    public String getTanda() {
        return Tanda;
    }

    public void setTanda(String tanda) {
        Tanda = tanda;
    }
    public String getWeekday() {
        return weekday;

    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public  Order(){

        calendar = Calendar.getInstance();

        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int month = calendar.get(Calendar.MONTH);
        int day= calendar.get(Calendar.DAY_OF_MONTH);
        int year= calendar.get(Calendar.YEAR);
        int dayOfWeek= calendar.get(Calendar.DAY_OF_WEEK);



        Hour = hourOfDay;
        this.date = ""+day+" / "+ month+ " / "+ year;
        weekday = getStringWeekDay(dayOfWeek);

    }


    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity <1)
            Quantity =1;
        else
        Quantity = quantity;
    }

    public Employed getBarberSelected() {
        return barberSelected;
    }

    public void setBarberSelected(Employed barberSelected) {
        this.barberSelected = barberSelected;
    }

    public int getHour() {
        return Hour;
    }

    public void setHour(int  hour) {
        Hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }


    public void next(int change){

        switch (change){
            case  CHANGEQUANTITY:
                if(Quantity>=10)
                    Quantity =  10;
                else
                    Quantity++;
                break;


            case  CHANGEDATE:

                calendar.add(Calendar.DATE,1);
                //int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
                int month = calendar.get(Calendar.MONTH);
                int day= calendar.get(Calendar.DAY_OF_MONTH);
                int year= calendar.get(Calendar.YEAR);
                int dayOfWeek= calendar.get(Calendar.DAY_OF_WEEK);


                //Hour = hourOfDay;
                this.date = ""+day+" / "+ month+ " / "+ year;
                weekday = getStringWeekDay(dayOfWeek);



                break;
            case  CHANGEHOUR:
                calendar.add(Calendar.HOUR,1);
                Hour = calendar.get(Calendar.HOUR);

                int am_pm = calendar.get(Calendar.AM_PM);
                if(am_pm == Calendar.AM)
                    Tanda = "AM";
                else if(am_pm == Calendar.PM)
                    Tanda = "PM";

                month = calendar.get(Calendar.MONTH);
                day= calendar.get(Calendar.DAY_OF_MONTH);
                year= calendar.get(Calendar.YEAR);
                dayOfWeek= calendar.get(Calendar.DAY_OF_WEEK);

                break;
            case  CHANGEBARBER:

                break;

        }
    }
    public void before(int change){
         Calendar calendar1 = Calendar.getInstance();
        switch (change){
            case  CHANGEQUANTITY:
                if(Quantity<=1)
                    Quantity =  1;
                else
                    Quantity--;
                break;


            case  CHANGEDATE:

                if (calendar.getTime().after(calendar1.getTime())){

                    calendar.add(Calendar.DATE,-1);
                }
                //int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
                int month = calendar.get(Calendar.MONTH);
                int day= calendar.get(Calendar.DAY_OF_MONTH);
                int year= calendar.get(Calendar.YEAR);
                int dayOfWeek= calendar.get(Calendar.DAY_OF_WEEK);
                //Hour = hourOfDay;
                this.date = ""+day+" / "+ month+ " / "+ year;
                weekday = getStringWeekDay(dayOfWeek);


                break;
            case  CHANGEHOUR:
                calendar.add(Calendar.HOUR,-1);
                 Hour = calendar.get(Calendar.HOUR);
                 int am_pm = calendar.get(Calendar.AM_PM);
                 if(am_pm == Calendar.AM)
                    Tanda = "AM";
                 else
                    if(am_pm == Calendar.PM)
                        Tanda = "PM";

                 month = calendar.get(Calendar.MONTH);
                 day= calendar.get(Calendar.DAY_OF_MONTH);
                 year= calendar.get(Calendar.YEAR);
                 dayOfWeek= calendar.get(Calendar.DAY_OF_WEEK);
                 //Hour = hourOfDay;
                 this.date = ""+day+" / "+ month+ " / "+ year;
                 weekday = getStringWeekDay(dayOfWeek);

                 break;
            case  CHANGEBARBER:

                 break;

        }
    }

    private  String getStringWeekDay(int  dayweek){
        String day = "nulo";
        switch (dayweek){



            case 2  : day ="Lunes";
            break;

            case 3: day ="Martes";
            break;

            case 4  : day ="Miercoles";
            break;

            case 5: day ="Jueves";
            break;

            case 6  : day ="Viernes";
            break;

            case 7: day ="Sabado";
            break;

            case 1 : day ="Domingo";
            break;
        }

return  day;
    }
}