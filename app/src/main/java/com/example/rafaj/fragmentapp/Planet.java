package com.example.rafaj.fragmentapp;

import android.net.Uri;

import java.io.Serializable;

/**
 * Created by Jaime on 4/16/2018.
 */

public class Planet implements Serializable {
    private String name, mass, temp;
    private int picture;

    public static String KEY_PLANET = "KEY_PLANET";

    public Planet(String name, String mass, String temp, int picture) {
        this.name = name;
        this.mass = mass;
        this.temp = temp;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getMass() {
        return mass;
    }

    public String getTemp() {
        return temp;
    }

    public int getPicture() {
        return picture;
    }
}
