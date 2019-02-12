package com.example.thebryan.combarbershapp.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thebryan.combarbershapp.Aplicacion;
import com.example.thebryan.combarbershapp.Models.Order;
import com.example.thebryan.combarbershapp.R;

import java.util.ArrayList;

public class Reservationes extends RecyclerView.Adapter<Reservationes.OrderView>{


    ArrayList<Order> Services_List;

    Context context;


    public Reservationes(ArrayList<Order> list, Context contexts){
        Services_List = list;
        context = contexts;
    }



    @Override
    public OrderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recent, parent,false);
        return new OrderView(view);
    }

    @Override
    public void onBindViewHolder(OrderView holder, final int position) {
        final Order order= Services_List.get(position);

        TextView Name = holder.Name;
        TextView date = holder.date;
        final CardView backgroud = holder.backgroud;


        Name.setText(order.getServiceName());
        date.setText(" " + order.getDate()+ " a las "+ order.getHour()+" : 00"+ order.getTanda());
        backgroud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openServiceView(position);
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


    void openServiceView(final int posi){
        final Dialog dialog =  new Dialog(context);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_cancel);
        dialog.findViewById(R.id.btncancelar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Aplicacion.whoLoged.getServicioActivo().remove(posi);
                notifyItemChanged(posi);
                dialog.dismiss();

            }
        });


//        dialog.setCancelable(false);
//        dialog.setCanceledOnTouchOutside(false);

        dialog.show();


    }




    public  class OrderView extends  RecyclerView.ViewHolder {

        TextView Name;
        TextView date;
        CardView backgroud;

        public OrderView(View itemView) {
        super(itemView);

        Name = itemView.findViewById(R.id.NameOrder);
        date= itemView.findViewById(R.id.dateOrder);
        backgroud= itemView.findViewById(R.id.background);
        backgroud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }



    }
}
