package com.example.rafaj.fragmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView txt_name, txt_mass, txt_gravity;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt_name = findViewById(R.id.txt_name);
        txt_mass = findViewById(R.id.txt_mass);
        txt_gravity = findViewById(R.id.txt_gravity);
        image = findViewById(R.id.img_planet);

        Intent callingIntent = getIntent();


        if (Intent.ACTION_SEND.equals(callingIntent.getAction()) ){
                handleReceivedText(callingIntent);

        }

    }

    private void handleReceivedText(Intent intent){
        Planet planet = (Planet)intent.getSerializableExtra(Planet.KEY_PLANET);

        if (txt_name != null && txt_mass != null && txt_gravity != null && image != null){
            txt_name.setText(planet.getName());
            txt_mass.setText(planet.getMass() + "\n" + getResources().getString(R.string.mass_units));
            txt_gravity.setText(planet.getTemp() + "\n" + getResources().getString(R.string.gravity_units));
            image.setImageResource(planet.getPicture());
        }
    }
}
