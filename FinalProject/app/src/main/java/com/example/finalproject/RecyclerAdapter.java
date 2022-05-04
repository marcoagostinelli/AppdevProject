package com.example.finalproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<String> hotelNames;
    ArrayList<String> prices;
    ArrayList<String> ratings;

    public RecyclerAdapter(Context context, ArrayList<String> hotelNames,ArrayList<String> prices, ArrayList<String> ratings ) {
        this.context = context;
        this.hotelNames = hotelNames;
        this.prices = prices;
        this.ratings = ratings;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_design, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textNames.setText(hotelNames.get(position));
        holder.textPrices.setText(prices.get(position) + " / night");
        holder.textNames.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Click on " + hotelNames.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,Details.class);
                intent.putExtra("name",hotelNames.get(position));
                intent.putExtra("price",prices.get(position));
                intent.putExtra("rating",ratings.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotelNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textNames;
        TextView textPrices;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textNames = itemView.findViewById(R.id.textNames);
            textPrices = itemView.findViewById(R.id.textPrice);
        }
    }
}
