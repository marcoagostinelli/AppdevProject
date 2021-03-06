package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "data", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Hotel(hotel_id INTEGER  primary key AUTOINCREMENT, hotel_name TEXT, rating INTEGER," +
                "num_ratings INTEGER, price INTEGER, image TEXT)");
        DB.execSQL("INSERT INTO Hotel(hotel_name, rating, num_ratings, price, image) VALUES('Vanilla Resort & Spa',0,0,150,'hotel1.png')");
        DB.execSQL("INSERT INTO Hotel(hotel_name, rating, num_ratings, price, image) VALUES('Diamond Resort',0,0,180,'hotel2.png')");
        DB.execSQL("INSERT INTO Hotel(hotel_name, rating, num_ratings, price, image) VALUES('Revolution Hotel and Spa',0,0,130,'hotel3.png')");
        DB.execSQL("INSERT INTO Hotel(hotel_name, rating, num_ratings, price, image) VALUES('Paradise Hotel',0,0,80,'hotel4.png')");
        DB.execSQL("INSERT INTO Hotel(hotel_name, rating, num_ratings, price, image) VALUES('Voyage Motel',0,0,70,'hotel5.png')");
        DB.execSQL("INSERT INTO Hotel(hotel_name, rating, num_ratings, price, image) VALUES('Coastline Resort',0,0,140,'hotel6.png')");
        DB.execSQL("INSERT INTO Hotel(hotel_name, rating, num_ratings, price, image) VALUES('Freedom Hotel',0,0,140,'hotel7.png')");
        DB.execSQL("INSERT INTO Hotel(hotel_name, rating, num_ratings, price, image) VALUES('Fantasy Hotel and Spa',0,0,200,'hotel8.png')");
        DB.execSQL("INSERT INTO Hotel(hotel_name, rating, num_ratings, price, image) VALUES('Royal Hotel',0,0,105,'hotel9.png')");
        DB.execSQL("INSERT INTO Hotel(hotel_name, rating, num_ratings, price, image) VALUES('Southern Beach Resort',0,0,210,'hotel10.png')");

        DB.execSQL("create Table Booking(booking_Id INTEGER primary key AUTOINCREMENT, check_in TEXT, check_out TEXT," +
                "num_people INTEGER, full_name TEXT, address TEXT, credit_card_num TEXT, hotel_id INTEGER," +
                "CONSTRAINT fk_hotels FOREIGN KEY (hotel_id) REFERENCES Hotel(hotel_id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS Hotel");
        DB.execSQL("DROP TABLE IF EXISTS Booking");
    }

    public Boolean insertBookingData(int check_in, int check_out, int num_people, String full_name,
                                     String address, int credit_card_num, int hotel_id) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("check_in", check_in);
        contentValues.put("check_out", check_out);
        contentValues.put("num_people", num_people);
        contentValues.put("full_name", full_name);
        contentValues.put("address", address);
        contentValues.put("credit_card_num", credit_card_num);
        contentValues.put("hotel_id", hotel_id);

        long result = DB.insert("Booking", null, contentValues);

        return result != -1;
    }

    public Boolean deleteBookingData(int booking_Id) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String idToString = Integer.toString(booking_Id);

        Cursor cursor = DB.rawQuery("Select * from Booking where booking_Id = ?", new String[]{idToString});

        if (cursor.getCount() > 0) {
            long result = DB.delete("Booking", "booking_Id=?", new String[]{idToString});
            return result != -1;
        } else {
            return false;
        }
    }

    public Boolean insertHotelData(String hotel_name, int rating, int num_ratings, int price, String image) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();

        contentvalues.put("hotel_name", hotel_name);
        contentvalues.put("rating", rating);
        contentvalues.put("num_ratings", num_ratings);
        contentvalues.put("price", price);
        contentvalues.put("image", image);

        long result = DB.insert("Hotel", null, contentvalues);
        return result != -1;
    }


    public Cursor getHotelData() {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("SELECT * FROM Hotel", null);
         //cursor to object to arraylist
        return cursor;
    }

}
