package com.example.sparks.cafe_detail.model;

/**
 * Created by Sparks on 7/24/2018.
 */

public class Detail {
    private String cafe_name ;
    private String cafe_image;
    private String cafe_rate ;
    private String cafe_address;
    private String cafe_open;
    private String cafe_phone;
    private String cafe_showadd;

    public Detail() {
        this.cafe_name = cafe_name;
        this.cafe_image = cafe_image;
        this.cafe_rate = cafe_rate;
        this.cafe_address = cafe_address;
        this.cafe_open = cafe_open;
        this.cafe_phone = cafe_phone;
    }

    public String getCafe_showadd() {
        return cafe_showadd;
    }

    public void setCafe_showadd(String cafe_showadd) {
        this.cafe_showadd = cafe_showadd;
    }

    public String getCafe_name() {
        return cafe_name;
    }

    public void setCafe_name(String cafe_name) {
        this.cafe_name = cafe_name;
    }

    public String getCafe_image() {
        return cafe_image;
    }

    public void setCafe_image(String cafe_image) {
        this.cafe_image = cafe_image;
    }

    public String getCafe_rate() {
        return cafe_rate;
    }

    public void setCafe_rate(String cafe_rate) {
        this.cafe_rate = cafe_rate;
    }

    public String getCafe_address() {
        return cafe_address;
    }

    public void setCafe_address(String cafe_address) {
        this.cafe_address = cafe_address;
    }

    public String getCafe_open() {
        return cafe_open;
    }

    public void setCafe_open(String cafe_open) {
        this.cafe_open = cafe_open;
    }

    public String getCafe_phone() {
        return cafe_phone;
    }

    public void setCafe_phone(String cafe_phone) {
        this.cafe_phone = cafe_phone;
    }
}
