package com.example.sparks.cafe_detail.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.sparks.cafe_detail.R;
import com.example.sparks.cafe_detail.activity.DetailActivity;
import com.example.sparks.cafe_detail.model.Detail;

import java.util.ArrayList;
import java.util.List;



public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder>  {
    RequestOptions options ;
    private Context mContext ;
    private List<Detail> mData ;
ArrayList<Detail>arrayList;





    public RvAdapter(Context mContext, List lst) {
            this.mContext = mContext;
            this.mData = lst;
            options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.loading);
this.arrayList=new ArrayList<>();

        }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.row,parent,false);

        final MyViewHolder viewHolder=new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DetailActivity.class);

                i.putExtra("cafe_phone",mData.get(viewHolder.getAdapterPosition()).getCafe_phone());
                i.putExtra("cafe_rate",mData.get(viewHolder.getAdapterPosition()).getCafe_rate());
                i.putExtra("cafe_name",mData.get(viewHolder.getAdapterPosition()).getCafe_name());
                i.putExtra("cafe_address",mData.get(viewHolder.getAdapterPosition()).getCafe_address());
                i.putExtra("cafe_image",mData.get(viewHolder.getAdapterPosition()).getCafe_image());
                mContext.startActivity(i);
            }
        });

       return viewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.cafe_name.setText(mData.get(position).getCafe_name());
         // holder.cafe_address.setText(mData.get(position).getCafe_address());
        holder.cafe_phone.setText(mData.get(position).getCafe_phone());
        holder.cafe_rate.setText(mData.get(position).getCafe_rate());
        holder.cafe_open.setText(mData.get(position).getCafe_open());
        holder.cafe_showadd.setText(mData.get(position).getCafe_showadd());


        // load image from the internet using Glide
        Glide.with(mContext).load(mData.get(position).getCafe_image()).apply(options).into(holder.cafe_image);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }






    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView cafe_name,cafe_rate,cafe_phone,cafe_address,cafe_open,cafe_showadd;
        ImageView cafe_image;
        LinearLayout view_container;


        public MyViewHolder(View itemView) {
            super(itemView);
            cafe_showadd=(TextView)itemView.findViewById(R.id.cafe_showadd);
            cafe_name = (TextView) itemView.findViewById(R.id.cafe_name);
            cafe_phone = (TextView) itemView.findViewById(R.id.cafe_phone);
            cafe_rate = (TextView) itemView.findViewById(R.id.cafe_rate);
            //cafe_address = (TextView) itemView.findViewById(R.id.cafe_address);
            cafe_open = (TextView) itemView.findViewById(R.id.cafe_open);
            cafe_image = (ImageView) itemView.findViewById(R.id.cafe_image);
            view_container = (LinearLayout) itemView.findViewById(R.id.view_container);
        }
    }
}
