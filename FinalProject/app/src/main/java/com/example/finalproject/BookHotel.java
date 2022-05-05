package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class BookHotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_hotel);

        Bundle intent = getIntent().getExtras();

        TextView hotelName = findViewById(R.id.hotelName);
        TextView price = findViewById(R.id.price);
        Button next = findViewById(R.id.next);

        hotelName.setText(intent.getString("name"));
        price.setText(intent.getString("price"));
    }
}