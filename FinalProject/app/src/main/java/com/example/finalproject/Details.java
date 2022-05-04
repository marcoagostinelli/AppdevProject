package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle intent = getIntent().getExtras();

        TextView hotelName = findViewById(R.id.hotelName);
        TextView hotelPrice = findViewById(R.id.hotelPrice);
        RatingBar hotelRating = findViewById(R.id.ratingBar);
        Button leaveRating = findViewById(R.id.rating);

        leaveRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(view.getContext(),LeaveRating.class);
                newIntent.putExtra("name",intent.getString("name"));
                newIntent.putExtra("price","$"+ intent.getString("price") + " / Night");
                newIntent.putExtra("rating",intent.getString("rating"));
            }
        });

        hotelName.setText(intent.getString("name"));
        hotelPrice.setText("$"+ intent.getString("price") + " / Night");
        hotelRating.setRating(Integer.parseInt(intent.getString("rating")));
    }
}