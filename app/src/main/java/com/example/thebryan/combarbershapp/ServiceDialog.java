package com.example.thebryan.combarbershapp;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thebryan.combarbershapp.R;

public class ServiceDialog  extends DialogFragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_service_dialog, container, false);
        getDialog().setTitle("Servicios");
        return rootView;
    }



}
