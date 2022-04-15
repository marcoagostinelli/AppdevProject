package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;

public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SearchView searchView;          // W.I.P
        RecyclerView recyclerView;
        RecyclerAdapter adapter;

        ArrayList<String> rooms = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);


    }
}