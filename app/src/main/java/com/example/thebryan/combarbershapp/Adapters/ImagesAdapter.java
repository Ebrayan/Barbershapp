package com.example.thebryan.combarbershapp.Adapters;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.thebryan.combarbershapp.Models.Image;
import com.example.thebryan.combarbershapp.Models.Service;
import com.example.thebryan.combarbershapp.R;
import com.example.thebryan.combarbershapp.Reservation;
import com.example.thebryan.combarbershapp.ViewImage;

import java.util.ArrayList;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImageViewe>{


    ArrayList<Image> Services_List;

    Context context;


    public ImagesAdapter(ArrayList<Image> list, Context contexts){
        Services_List = list;
        context = contexts;
    }



    @Override
    public ImageViewe onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent,false);
        return new ImageViewe(view);
    }

    @Override
    public void onBindViewHolder(final ImageViewe holder, int position) {
        final Image image = Services_List.get(position);
        final View viewn = holder.imageview;

        holder.backgroud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(context, ViewImage.class);
                inten.putExtra("like",image.getLike());



                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) context, viewn, "image");
                context.startActivity(inten, options.toBundle());

            }
        });


    }


    @Override
    public int getItemCount() {
        return Services_List.size();
    }






    public  class ImageViewe extends  RecyclerView.ViewHolder {

        LinearLayout backgroud;
        ImageView  imageview;

        public ImageViewe (View itemView) {
        super(itemView);

        backgroud= itemView.findViewById(R.id.background);
        imageview= itemView.findViewById(R.id.imageview);


    }



    }
}
