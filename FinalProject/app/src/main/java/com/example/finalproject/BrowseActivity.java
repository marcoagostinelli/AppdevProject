package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import java.util.ArrayList;

public class BrowseActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    ArrayList<String> hotelNames;
    ArrayList<String> hotelPrices;
    public DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        SearchView searchView;          // W.I.P
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DB = new DBHelper(this);

        hotelNames = new ArrayList<String>();
        hotelPrices = new ArrayList<String>();
        Cursor res = DB.getHotelData();

        while (res.moveToNext()){
            hotelNames.add(res.getString(1));
            hotelPrices.add(res.getString(4));
        }
        adapter = new RecyclerAdapter(this,hotelNames,hotelPrices);
        recyclerView.setAdapter(adapter);

        ArrayList<String> rooms = new ArrayList<>();




    }
}