package com.example.thebryan.combarbershapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.thebryan.combarbershapp.Adapters.Barber_Services;
import com.example.thebryan.combarbershapp.Adapters.Reservationes;
import com.example.thebryan.combarbershapp.Models.Order;
import com.example.thebryan.combarbershapp.Models.Service;

import java.util.ArrayList;

public class MyReservatios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reservatios);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        uiInit();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MyReservatios.this,Services_List.class));
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }




    private  void uiInit(){
        RecyclerView recyclerView = findViewById(R.id.recyclerActivas);

        recyclerView.setLayoutManager(new LinearLayoutManager(MyReservatios.this));

        if (!(Aplicacion.whoLoged==null)){

            ArrayList<Order> orderArrayList = Aplicacion.whoLoged.getServicioActivo();

            Reservationes reservationes  = new Reservationes( orderArrayList,this);

            recyclerView.setAdapter(reservationes);
        }else {

            Toast.makeText(this,"Usted no ha iniciado Sesion", Toast.LENGTH_LONG);
        }

    }

}
