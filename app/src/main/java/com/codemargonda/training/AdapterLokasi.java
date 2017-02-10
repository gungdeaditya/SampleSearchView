package com.codemargonda.training;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gungde on 08/02/17.
 */

public class AdapterLokasi extends RecyclerView.Adapter<AdapterLokasi.LokasiViewHolder>{

    ArrayList<Lokasi> list = new ArrayList<Lokasi>();
    Context context;

    public AdapterLokasi(ArrayList<Lokasi> list,Context context ){
        this.list = list;
        this.context = context;
    }


    @Override
    public AdapterLokasi.LokasiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout,parent,false);
        LokasiViewHolder lokasiViewHolder = new LokasiViewHolder(view);
        return lokasiViewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterLokasi.LokasiViewHolder holder, int position) {
        holder.text.setText(list.get(position).getTempat());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class LokasiViewHolder extends RecyclerView.ViewHolder{

        TextView text;

        public LokasiViewHolder(View itemView) {
            super(itemView);
            text = (TextView)itemView.findViewById(R.id.text);
        }
    }

    public void setFilter(ArrayList<Lokasi> newList){
        list = new ArrayList<>();
        list.addAll(newList);
        notifyDataSetChanged();
    }
}
