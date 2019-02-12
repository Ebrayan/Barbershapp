package com.example.thebryan.combarbershapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.thebryan.combarbershapp.Adapters.Barber_Services;
import com.example.thebryan.combarbershapp.Models.Service;

import java.util.ArrayList;

public class Services_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services__list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recyclerServiceList);
        recyclerView.setLayoutManager(new LinearLayoutManager(Services_List.this));
        ArrayList <Service> serviceArrayList = new ArrayList<>();
        Barber_Services barber_servicesAdapter  = new Barber_Services( serviceArrayList,this);



        serviceArrayList.add(new   Service("id","Corte de Ninos", 75,"f","Pelo"));
        serviceArrayList.add(new   Service("id","Corte de Hombre", 125,"f","Pelo"));
        serviceArrayList.add(new   Service("id","Corte + Afeitada ", 200,"f","Pelo"));
        serviceArrayList.add(new   Service("id","Limpieza de ejas", 125,"f","Pelo"));
        serviceArrayList.add(new   Service("id","Barba", 190,"f","Pelo"));
        serviceArrayList.add(new   Service("id","Bigote", 95,"f","Pelo"));
        serviceArrayList.add(new   Service("id","Limpieza Facial", 100,"f","Pelo"));
        serviceArrayList.add(new   Service("id","Manicure", 100,"f","Pelo"));
        serviceArrayList.add(new   Service("id","Pedicure", 100,"f","Pelo"));
        serviceArrayList.add(new   Service("id","Apartar villar", 100,"f","Pelo"));
            serviceArrayList.add(new Service("1"));
            serviceArrayList.add(new Service("2"));
        serviceArrayList.add(new Service("3"));
        serviceArrayList.add(new Service("4"));
        serviceArrayList.add(new Service("5"));
        recyclerView.setAdapter(barber_servicesAdapter);






    }
}
