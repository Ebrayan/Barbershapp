package com.example.thebryan.combarbershapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.thebryan.combarbershapp.Adapters.Barber_Services;
import com.example.thebryan.combarbershapp.Adapters.ImagesAdapter;
import com.example.thebryan.combarbershapp.Models.Image;
import com.example.thebryan.combarbershapp.Models.Service;
import com.example.thebryan.combarbershapp.R;

import java.util.ArrayList;

public class Portafolio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portafolio);
        initUI();



    }


    private   void  initUI(){
        RecyclerView recyclerView =  findViewById(R.id.recyclerImages);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        ArrayList<Image> imagesArrayList = new ArrayList<>();

        for (int i = 0 ; i<20;i++){
            imagesArrayList.add(new Image(i));
        }

        ImagesAdapter imagesAdapter = new ImagesAdapter( imagesArrayList,this);

        recyclerView.setAdapter(imagesAdapter );

    }

}
