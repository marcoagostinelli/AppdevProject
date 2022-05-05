package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking);

        Bundle intent = getIntent().getExtras();

        TextView hotelName = findViewById(R.id.hotelName);
        Button confirm = findViewById(R.id.confirm);

        hotelName.setText(intent.getString("name"));


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(ConfirmBooking.this, "My Notification");
                builder.setContentTitle("NOTICE");
                builder.setContentText("Hotel Successfully Booked");
                builder.setSmallIcon(R.drawable.ic_launcher_foreground);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(ConfirmBooking.this);
                managerCompat.notify(1, builder.build());

                startActivity(new Intent(view.getContext(),MainActivity.class));
            }
        });
    }
}