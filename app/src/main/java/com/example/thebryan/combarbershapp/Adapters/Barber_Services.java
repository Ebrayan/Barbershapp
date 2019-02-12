package com.example.thebryan.combarbershapp.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thebryan.combarbershapp.Models.Service;
import com.example.thebryan.combarbershapp.R;
import com.example.thebryan.combarbershapp.Reservation;

import java.io.Serializable;
import java.util.ArrayList;

public class Barber_Services extends RecyclerView.Adapter<Barber_Services.ServicesView>{


    ArrayList<Service> Services_List;

    Context context;


    public  Barber_Services(ArrayList<Service> list, Context contexts){
        Services_List = list;
        context = contexts;
    }



    @Override
    public ServicesView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service, parent,false);
        return new ServicesView(view);
    }

    @Override
    public void onBindViewHolder(ServicesView holder, int position) {
        final Service  service = Services_List.get(position);

        TextView Name = holder.Name;
        TextView Price = holder.Price;
        final CardView backgroud = holder.backgroud;

        Name.setText(service.getName());
        Price.setText("$" + service.getPrice());
        backgroud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openServiceView(service);
            }
        });
        backgroud.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                backgroud.setCardBackgroundColor(ColorStateList.valueOf(context.getResources().getColor(R.color.colorAccent)));
                return false;
            }
        });

    }


    @Override
    public int getItemCount() {
        return Services_List.size();
    }


    void openServiceView(final Service service){
        final Dialog dialog =  new Dialog(context);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.fragment_service_dialog);
        dialog.findViewById(R.id.btnTurn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Reservation.class);
                intent.putExtra("service",service);
                context.startActivity(intent);
            }
        });

         dialog.findViewById(R.id.close_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 dialog.dismiss();
            }
        });

        ImageView mainImageService =   dialog.findViewById(R.id.main_image);
        TextView service_name=   dialog.findViewById(R.id.service_name);
        service_name.setText(service.getName());


        //  here load the Image code

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        dialog.show();


    }




    public  class ServicesView extends  RecyclerView.ViewHolder {

        TextView Name;
        TextView Price;
        CardView backgroud;

        public ServicesView(View itemView) {
        super(itemView);

        Name = itemView.findViewById(R.id.service_name);
        Price= itemView.findViewById(R.id.service_price);
        backgroud= itemView.findViewById(R.id.background);

        backgroud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }



    }
}
