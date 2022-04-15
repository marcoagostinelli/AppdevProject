package com.example.finalproject;

import java.util.Objects;

public class HotelRoom {
    private String hotelName;
    private int rating;
    private int ratingNum;
    private int price;
    private String image;

    public HotelRoom(String hotelName, int rating, int ratingNum, int price, String image) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.ratingNum = ratingNum;
        this.price = price;
        this.image = image;
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "hotelName='" + hotelName + '\'' +
                ", rating=" + rating +
                ", ratingNum=" + ratingNum +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRatingNum() {
        return ratingNum;
    }

    public void setRatingNum(int ratingNum) {
        this.ratingNum = ratingNum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
