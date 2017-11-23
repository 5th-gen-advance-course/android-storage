package com.example.ratha.storagedemo.entity.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;

/**
 * Created by ratha on 11/23/2017.
 */

public class Address {

    private String street;
    @ColumnInfo(name = "zip_code")
    private String zipCode;
    private String country;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
