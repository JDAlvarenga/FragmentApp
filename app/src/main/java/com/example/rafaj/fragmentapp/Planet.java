package com.example.rafaj.fragmentapp;

import android.net.Uri;

import java.io.Serializable;

/**
 * Created by Jaime on 4/16/2018.
 */

public class Planet implements Serializable {
    private String name, mass, gravity;
    private int picture;

    public static String KEY_PLANET = "KEY_PLANET";

    public Planet(String name, String mass, String gravity, int picture) {
        this.name = name;
        this.mass = mass;
        this.gravity = gravity;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getMass() {
        return mass;
    }

    public String getGravity() {
        return gravity;
    }

    public int getPicture() {
        return picture;
    }
}
